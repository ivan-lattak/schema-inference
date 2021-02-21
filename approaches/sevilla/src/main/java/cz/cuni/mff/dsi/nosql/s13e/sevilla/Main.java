package cz.cuni.mff.dsi.nosql.s13e.sevilla;

import com.google.gson.JsonArray;
import es.um.nosql.s13e.json2dbschema.main.BuildNoSQLSchema;
import es.um.nosql.s13e.nosqlimport.db.mongodb.MongoDBImport;

public class Main {

    public static final String PROPERTY_MONGO_HOST = "sevilla.mongoHost";
    public static final String PROPERTY_DB_NAME = "sevilla.dbName";
    public static final String PROPERTY_MAP_REDUCE_DIR = "sevilla.mapReduceDir";
    public static final String PROPERTY_OUTPUT_FILE = "sevilla.outputFile";

    private static String mongoHost = System.getProperty(PROPERTY_MONGO_HOST, "localhost");
    private static String dbName = System.getProperty(PROPERTY_DB_NAME, "inference");
    private static String mapReduceDir = System.getProperty(PROPERTY_MAP_REDUCE_DIR, "mapreduce/v2");
    private static String outputFile = System.getProperty(PROPERTY_OUTPUT_FILE, "schema.xml");

    public static void main(String[] args) {
        parseArgs(args);

        MongoDBImport importer = new MongoDBImport(mongoHost, dbName);
        JsonArray array = importer.mapRed2Array(mapReduceDir);
        new BuildNoSQLSchema().buildFromGsonArray(dbName, array, outputFile);
    }

    private static void parseArgs(String[] args) {
        if (args.length == 0) {
            return;
        }
        if (args.length != 4) {
            throw new IllegalArgumentException("Usage: cz.cuni.mff.dsi.nosql.s13e.sevilla.Main <mongoHost> <dbName> <mapReduceDir> <outputFile>");
        }

        mongoHost = args[0];
        dbName = args[1];
        mapReduceDir = args[2];
        outputFile = args[3];
    }

}
