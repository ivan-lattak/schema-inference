package cz.cuni.mff.dsi.nosql.s13e.frozza;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cuni.mff.dsi.nosql.s13e.frozza.model.Credentials;
import cz.cuni.mff.dsi.nosql.s13e.frozza.model.InputParams;
import cz.cuni.mff.dsi.nosql.s13e.frozza.model.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class RunInference {

    public static final String PROPERTY_INFERRER_URL = "frozza.inferrerUrl";
    public static final String PROPERTY_INFERRER_EMAIL = "frozza.inferrerEmail";
    public static final String PROPERTY_INFERRER_PASSWORD = "frozza.inferrerPassword";
    public static final String PROPERTY_MONGO_HOST = "frozza.mongoHost";
    public static final String PROPERTY_DB_NAME = "frozza.dbName";
    public static final String PROPERTY_COLLECTION_NAME = "frozza.collectionName";
    public static final String PROPERTY_OUTPUT_FILE = "frozza.outputFile";

    private static final String inferrerUrl = System.getProperty(PROPERTY_INFERRER_URL, "http://localhost:3000");
    private static final String inferrerEmail = System.getProperty(PROPERTY_INFERRER_EMAIL, "admin@example.com");
    private static final String inferrerPassword = System.getProperty(PROPERTY_INFERRER_PASSWORD, "administrator");
    private static String mongoHost = System.getProperty(PROPERTY_MONGO_HOST, "localhost");
    private static String dbName = System.getProperty(PROPERTY_DB_NAME, "inference");
    private static String collectionName = System.getProperty(PROPERTY_COLLECTION_NAME, "articles");
    private static String outputFile = System.getProperty(PROPERTY_OUTPUT_FILE, "schema.json");

    public static void main(String[] args) throws IOException {
        parseArgs(args);

        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            InputParams inputParams = new InputParams("http://" + mongoHost, "27017", dbName, collectionName);
            send(client, "/batch/rawschema/steps/all", inputParams);

            User user = new User("admin", inferrerEmail, inferrerPassword);
            Credentials credentials = new Credentials(inferrerEmail, inferrerPassword);
            //send(client, "/register", user);
        }
    }

    private static void send(CloseableHttpClient client, String endpoint, Object data) throws IOException {
        HttpPost httpPost = new HttpPost(inferrerUrl + "/api" + endpoint);
        ObjectMapper objectMapper = new ObjectMapper();
        httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(data)));
        try (CloseableHttpResponse response = client.execute(httpPost)) {
            JsonNode jsonNode = objectMapper.readTree(response.getEntity().getContent());
            System.out.printf("%d %s%n", response.getStatusLine().getStatusCode(), jsonNode.toString());
        }
    }

    private static void parseArgs(String[] args) {
        if (args.length == 0) {
            return;
        }
        if (args.length != 4) {
            throw new IllegalArgumentException("Usage: cz.cuni.mff.dsi.nosql.s13e.frozza.Main <mongoHost> <dbName> <collectionName> <outputFile>");
        }

        mongoHost = args[0];
        dbName = args[1];
        collectionName = args[2];
        outputFile = args[3];
    }

}
