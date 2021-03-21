package cz.cuni.mff.dsi.nosql.s13e.frozza;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cuni.mff.dsi.nosql.s13e.frozza.model.Batch;
import cz.cuni.mff.dsi.nosql.s13e.frozza.model.BatchInputParams;
import cz.cuni.mff.dsi.nosql.s13e.frozza.model.Credentials;

import java.io.File;
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

    private static final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    public static void main(String[] args) throws IOException, InterruptedException {
        parseArgs(args);

        try (CloseableInferenceClient client = new CloseableInferenceClient(inferrerUrl, objectMapper)) {
            client.login(new Credentials(inferrerEmail, inferrerPassword));
            BatchInputParams params = new BatchInputParams(mongoHost, "27017", dbName, collectionName);
            client.createBatch(params);
            Batch batch = client.waitUntilLastBatchDone(params);
            JsonNode schema = client.generateJsonSchema(batch);
            objectMapper.writeValue(new File(outputFile), schema);
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
