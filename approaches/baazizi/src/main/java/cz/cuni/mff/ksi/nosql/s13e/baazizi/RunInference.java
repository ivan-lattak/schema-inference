package cz.cuni.mff.ksi.nosql.s13e.baazizi;

import parametric.SchemaInference;
import parametric.typeDefinition.CountingType;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RunInference {

    public static final String PROPERTY_SPARK_MASTER = "baazizi.sparkMaster";
    public static final String PROPERTY_MONGO_HOST = "baazizi.mongoHost";
    public static final String PROPERTY_DB_NAME = "baazizi.dbName";
    public static final String PROPERTY_COLLECTION_NAME = "baazizi.collectionName";
    public static final String PROPERTY_EQUIVALENCE = "baazizi.equivalence";
    public static final String PROPERTY_OUTPUT_FILE = "baazizi.outputFile";

    private static final String sparkMaster = System.getProperty(PROPERTY_SPARK_MASTER, "local[*]");
    private static final String mongoHost = System.getProperty(PROPERTY_MONGO_HOST, "localhost");
    private static final String dbName = System.getProperty(PROPERTY_DB_NAME, "inference");
    private static final String collectionName = System.getProperty(PROPERTY_COLLECTION_NAME, "articles");
    private static final String equivalence = System.getProperty(PROPERTY_EQUIVALENCE, "k");
    private static final String outputFile = System.getProperty(PROPERTY_OUTPUT_FILE, "build/schema.txt");

    public static void main(String[] args) throws IOException {
        CountingType type = SchemaInference.infer(sparkMaster, mongoHost, dbName, collectionName, equivalence);
        Files.createDirectories(Paths.get(outputFile).getParent());
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile))) {
            writer.write(type.toString());
            writer.newLine();
        }
    }

}
