package cz.cuni.mff.ksi.nosql.s13e.frozza;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import cz.cuni.mff.ksi.nosql.s13e.frozza.model.*;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

public class CloseableInferenceClient implements Closeable {

    private static final JavaType BATCH_LIST_TYPE = TypeFactory.defaultInstance().constructType(new TypeReference<List<Batch>>() {
    });
    private static final JavaType GENERATED_SCHEMA_LIST_TYPE = TypeFactory.defaultInstance().constructType(new TypeReference<List<GeneratedSchema>>() {
    });
    private static final Logger log = LoggerFactory.getLogger(CloseableInferenceClient.class);

    private final CloseableHttpClient client = HttpClientBuilder.create().build();

    private final String inferrerUrl;
    private final ObjectMapper objectMapper;

    @Nullable
    private Token token;

    public CloseableInferenceClient(String inferrerUrl, ObjectMapper objectMapper) {
        this.inferrerUrl = inferrerUrl;
        this.objectMapper = objectMapper;
    }

    public void login(Credentials credentials) throws IOException {
        token = postForObject("/login", credentials, Token.class);
    }

    public void createBatch(BatchInputParams params) throws IOException {
        String response = postForObject("/batch/rawschema/steps/all", params, String.class);
        if (!"OK".equals(response)) {
            throw new RuntimeException("Failed to create batch");
        }
    }

    public Optional<Batch> waitUntilLastBatchDone(BatchInputParams params) throws IOException, InterruptedException {
        String expectedDbUri = String.format("%s:%s/%s", params.getAddress(), params.getPort(), params.getDatabaseName());
        while (true) {
            List<Batch> batches = getForObject("/batches", BATCH_LIST_TYPE);
            Optional<Batch> lastCreatedBatch = batches.stream()
                .filter(b -> b.getDbUri().equals(expectedDbUri))
                .filter(b -> b.getCollectionName().equals(params.getCollectionName()))
                .max(comparing(Batch::getCreatedAt))
                .filter(b -> b.getStatus().equals("DONE") || b.getStatus().equals("ERROR"));
            if (lastCreatedBatch.isPresent()) {
                return lastCreatedBatch.filter(b -> b.getStatus().equals("DONE"));
            }
            //noinspection BusyWait
            Thread.sleep(1000);
        }
    }

    public JsonNode generateJsonSchema(Batch batch) throws IOException {
        List<GeneratedSchema> schema = getForObject("/batch/jsonschema/generate/" + batch.getId(), GENERATED_SCHEMA_LIST_TYPE);
        return schema.get(0).getJsonSchema();
    }

    @Override
    public void close() throws IOException {
        client.close();
    }

    private <T> T postForObject(String endpoint, Object data, Class<T> tClass) throws IOException {
        HttpPost httpPost = new HttpPost(inferrerUrl + "/api" + endpoint);
        setHeaders(httpPost);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
        httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(data)));
        try (CloseableHttpResponse response = client.execute(httpPost)) {
            JsonNode jsonTree = objectMapper.readTree(response.getEntity().getContent());
            log.debug("{} {}", response.getStatusLine().getStatusCode(), jsonTree.toString());
            return objectMapper.treeToValue(jsonTree, tClass);
        }
    }

    private <T> T getForObject(String endpoint, Class<T> tClass) throws IOException {
        return getForObject(endpoint, TypeFactory.defaultInstance().constructType(tClass));
    }

    private <T> T getForObject(String endpoint, JavaType type) throws IOException {
        JsonNode result;
        HttpGet httpGet = new HttpGet(inferrerUrl + "/api" + endpoint);
        setHeaders(httpGet);
        try (CloseableHttpResponse response = client.execute(httpGet)) {
            JsonNode jsonTree1 = objectMapper.readTree(response.getEntity().getContent());
            log.debug("{} {}", response.getStatusLine().getStatusCode(), jsonTree1.toString());
            result = jsonTree1;
        }
        JsonNode jsonTree = result;
        return objectMapper.convertValue(jsonTree, type);
    }

    private void setHeaders(HttpRequestBase request) {
        if (token != null) {
            request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token.getToken());
        }
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    }

}
