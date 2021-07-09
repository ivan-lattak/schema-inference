package cz.cuni.mff.ksi.nosql.s13e.sevilla;

import com.google.gson.JsonArray;
import es.um.nosql.s13e.json2dbschema.main.BuildNoSQLSchema;
import es.um.nosql.s13e.nosqlimport.db.mongodb.MongoDBImport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

public class RunInference {

    public static final String PROPERTY_MONGO_HOST = "sevilla.mongoHost";
    public static final String PROPERTY_DB_NAME = "sevilla.dbName";
    public static final String PROPERTY_MAP_REDUCE_DIR = "sevilla.mapReduceDir";
    public static final String PROPERTY_OUTPUT_FILE = "sevilla.outputFile";
    public static final String PROPERTY_MEASUREMENT_OUTPUT_FILE = "sevilla.measurementFile";

    private static final String mongoHost = System.getProperty(PROPERTY_MONGO_HOST, "localhost");
    private static final String dbName = System.getProperty(PROPERTY_DB_NAME, "inference");
    private static final String mapReduceDir = System.getProperty(PROPERTY_MAP_REDUCE_DIR, "mapreduce/v2");
    private static final String outputFile = System.getProperty(PROPERTY_OUTPUT_FILE, "build/schema.xml");
    private static final String measurementOutputFile = System.getProperty(PROPERTY_MEASUREMENT_OUTPUT_FILE);

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        MongoDBImport importer = new MongoDBImport(mongoHost, dbName);
        JsonArray array = importer.mapRed2Array(mapReduceDir);
        long runtime = System.currentTimeMillis() - start;
        if (measurementOutputFile == null) {
            System.out.printf("Inference finished in: %d milliseconds%n", runtime);
        } else {
            Files.write(Paths.get(measurementOutputFile), Collections.singleton(String.valueOf(runtime)));
        }
        Files.createDirectories(Paths.get(outputFile).getParent());
        new BuildNoSQLSchema().buildFromGsonArray(dbName, array, outputFile);
    }

}
