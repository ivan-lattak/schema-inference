package cz.cuni.mff.ksi.nosql.s13e.frozza;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cuni.mff.ksi.nosql.s13e.frozza.model.Batch;
import cz.cuni.mff.ksi.nosql.s13e.frozza.model.BatchInputParams;
import cz.cuni.mff.ksi.nosql.s13e.frozza.model.Credentials;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Optional;

public class RunMeasurements {

    private static final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    public static void main(String[] args) throws IOException, InterruptedException {
        int iterations = Integer.parseInt(args[0]);
        Path outputFile = Paths.get(args[1]);
        String dbName = args[2];
        String collectionName = args[3];

        try (BufferedWriter w = Files.newBufferedWriter(outputFile);
             PrintWriter writer = new PrintWriter(w)) {
            for (int i = 0; i < iterations; i++) {
                try (CloseableInferenceClient client = new CloseableInferenceClient("http://localhost:3000", objectMapper)) {
                    client.login(new Credentials("admin@example.com", "administrator"));
                    BatchInputParams params = new BatchInputParams("localhost", "27017", dbName, collectionName);
                    long start = System.currentTimeMillis();
                    client.createBatch(params);
                    Optional<Batch> batch = client.waitUntilLastBatchDone(params, Duration.ofMillis(100), Duration.ofMinutes(1));
                    if (batch.isPresent()) {
                        JsonNode schema = client.generateJsonSchema(batch.get());
                        writer.println(System.currentTimeMillis() - start);
                    } else {
                        writer.println("TIMEOUT");
                    }
                }
            }
        }
    }

}
