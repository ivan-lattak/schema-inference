package cz.cuni.mff.ksi.nosql.s13e.performance;

import com.mongodb.MongoClient;
import org.bson.Document;
import org.gradle.tooling.BuildException;
import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class PerformanceExperiment {

    public static final int EXPERIMENT_COUNT = 8;
    public static final int PERMUTATION_COUNT = 30;
    public static final int PERMUTATION_SIZE_MULTIPLIER = 1000;
    public static final int ITERATIONS_PER_APPROACH = 10;
    public static final String COLLECTION_NAME = "articles";

    public static final String PROPERTY_DB_NAME = "performance.dbName";
    public static final String PROPERTY_OUTPUT_DIR = "performance.outputDir";
    public static final String PROPERTY_ROOT_PROJECT_DIR = "performance.rootProjectDir";

    private static final String dbName = System.getProperty(PROPERTY_DB_NAME, "experimentPerformance");
    private static final String tempDbName = dbName + "Temp";
    private static final Path outputDir = Paths.get(System.getProperty(PROPERTY_OUTPUT_DIR, "build/measurements")).toAbsolutePath();
    private static final Path tempMeasurementsFile = outputDir.resolve("temp");
    private static final Path rootProjectDir = Paths.get(System.getProperty(PROPERTY_ROOT_PROJECT_DIR, "../..")).toAbsolutePath();

    // experiment size -> approach name -> measurements
    private static final LinkedHashMap<String, List<String>> measurements = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        Files.createDirectories(outputDir);
        for (int i = 0; i < EXPERIMENT_COUNT; i++) {
            runExperiment(1 << i);
        }
        Files.delete(tempMeasurementsFile);
    }

    private static void runExperiment(int size) throws IOException {
        System.out.printf("Starting experiment with size %dk...%n", size);
        for (int i = 0; i < PERMUTATION_COUNT; i++) {
            runPermutation(i, size);
        }
        saveMeasurements(size);
    }

    private static void runPermutation(int permutationNumber, int experimentSize) throws IOException {
        generatePermutation(permutationNumber, experimentSize);

        registerMeasurements(experimentSize, "Sevilla", runAndGatherMeasurements("Sevilla", ":sevilla"));
        registerMeasurements(experimentSize, "Baazizi", runAndGatherMeasurements("Baazizi", ":baazizi"));
        registerMeasurements(experimentSize, "Canovas", runAndGatherMeasurements("Canovas", ":canovas"));
        registerMeasurements(experimentSize, "Frozza", runAndGatherMeasurements("Frozza", ":frozza"));
        registerMeasurements(experimentSize, "New approach", runAndGatherMeasurements("New approach", ""));
    }

    private static void generatePermutation(int permutationNumber, int experimentSize) {
        System.out.printf("  Generating permutation with size %dk, %d/%d...%n", experimentSize, permutationNumber + 1, PERMUTATION_COUNT);
        int documentCount = experimentSize * PERMUTATION_SIZE_MULTIPLIER;
        try (MongoClient client = new MongoClient()) {
            client.dropDatabase(tempDbName);
            List<Document> documents = new ArrayList<>(documentCount);
            client.getDatabase(dbName)
                    .getCollection(COLLECTION_NAME)
                    .aggregate(Collections.singletonList(sampleWithSize(documentCount)))
                    .into(documents);
            client.getDatabase(tempDbName).getCollection(COLLECTION_NAME).insertMany(documents);
        }
    }

    private static Document sampleWithSize(int documentCount) {
        return new Document(Collections.singletonMap(
                "$sample",
                new Document(Collections.singletonMap("size", documentCount))));
    }

    private static List<String> runAndGatherMeasurements(String approachName, String projectPath) throws IOException {
        System.out.printf("    Running iterations for '%s' approach...%n", approachName);
        try {
            runGradleMeasurementsTask(projectPath);
        } catch (BuildException e) {
            return Collections.nCopies(ITERATIONS_PER_APPROACH, "ERROR");
        }

        List<String> measurements = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(tempMeasurementsFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                measurements.add(line.trim());
            }
        }
        return measurements;
    }

    private static void runGradleMeasurementsTask(String projectPath) throws BuildException {
        try (ProjectConnection connection = GradleConnector.newConnector()
                .forProjectDirectory(rootProjectDir.toFile())
                .connect()) {
            connection.newBuild()
                    .withArguments(
                            "-Pmeasurements.iterations=" + ITERATIONS_PER_APPROACH,
                            "-Pmeasurements.outputFile=" + tempMeasurementsFile,
                            "-Pmeasurements.dbName=" + tempDbName,
                            "-Pmeasurements.collectionName=" + COLLECTION_NAME)
                    .forTasks(projectPath + ":runMeasurements")
                    .run();
        }
    }

    private static void registerMeasurements(int experimentSize, String approachName, List<String> values) {
        measurements.computeIfAbsent(approachName, k -> new ArrayList<>()).addAll(values);
    }

    private static void saveMeasurements(int size) throws IOException {
        String fileName = String.format("%dk.csv", size);
        try (BufferedWriter writer = Files.newBufferedWriter(outputDir.resolve(fileName))) {
            for (Map.Entry<String, List<String>> entry : measurements.entrySet()) {
                writer.write(entry.getKey());
                writer.write(",");
                writer.write(String.join(",", entry.getValue()));
                writer.newLine();
            }
        }
        measurements.clear();
    }

}
