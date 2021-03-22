package cz.cuni.mff.dsi.nosql.s13e.baazizi;

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

    private static String sparkMaster = System.getProperty(PROPERTY_SPARK_MASTER, "local[*]");
    private static String mongoHost = System.getProperty(PROPERTY_MONGO_HOST, "localhost");
    private static String dbName = System.getProperty(PROPERTY_DB_NAME, "inference");
    private static String collectionName = System.getProperty(PROPERTY_COLLECTION_NAME, "articles");
    private static String equivalence = System.getProperty(PROPERTY_EQUIVALENCE, "k");
    private static String outputFile = System.getProperty(PROPERTY_OUTPUT_FILE, "schema.txt");

    public static void main(String[] args) throws IOException {
        parseArgs(args);

        CountingType type = SchemaInference.infer(sparkMaster, mongoHost, dbName, collectionName, equivalence);
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile))) {
            writer.write(type.toString());
            writer.newLine();
        }
    }

    private static void parseArgs(String[] args) {
        if (args.length == 0) {
            return;
        }
        if (args.length != 6) {
            throw new IllegalArgumentException("Usage: cz.cuni.mff.dsi.nosql.s13e.baazizi.RunInference <sparkMaster> <mongoHost> <dbName> <collectionName> <equivalence> <outputFile>");
        }

        sparkMaster = args[0];
        mongoHost = args[1];
        dbName = args[2];
        collectionName = args[3];
        equivalence = args[4];
        outputFile = args[5];
    }

}
