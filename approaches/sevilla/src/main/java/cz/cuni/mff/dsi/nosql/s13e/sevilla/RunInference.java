package cz.cuni.mff.dsi.nosql.s13e.sevilla;

import com.google.gson.JsonArray;
import es.um.nosql.s13e.json2dbschema.main.BuildNoSQLSchema;
import es.um.nosql.s13e.nosqlimport.db.mongodb.MongoDBImport;

public class RunInference {

    public static final String PROPERTY_MONGO_HOST = "sevilla.mongoHost";
    public static final String PROPERTY_DB_NAME = "sevilla.dbName";
    public static final String PROPERTY_MAP_REDUCE_DIR = "sevilla.mapReduceDir";
    public static final String PROPERTY_OUTPUT_FILE = "sevilla.outputFile";

    private static final String mongoHost = System.getProperty(PROPERTY_MONGO_HOST, "localhost");
    private static final String dbName = System.getProperty(PROPERTY_DB_NAME, "inference");
    private static final String mapReduceDir = System.getProperty(PROPERTY_MAP_REDUCE_DIR, "mapreduce/v2");
    private static final String outputFile = System.getProperty(PROPERTY_OUTPUT_FILE, "build/schema.xml");

    public static void main(String[] args) {
        MongoDBImport importer = new MongoDBImport(mongoHost, dbName);
        JsonArray array = importer.mapRed2Array(mapReduceDir);
        new BuildNoSQLSchema().buildFromGsonArray(dbName, array, outputFile);
    }

}
