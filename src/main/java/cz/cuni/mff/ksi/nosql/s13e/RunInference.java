package cz.cuni.mff.ksi.nosql.s13e;

import cz.cuni.mff.ksi.nosql.s13e.impl.DataLoader;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema;
import cz.cuni.mff.ksi.nosql.s13e.impl.SchemaInference;
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.mongo.MongoDataLoader;

import java.io.IOException;
import java.nio.file.Paths;

public class RunInference {

    public static final String PROPERTY_SPARK_MASTER = "schemaInference.sparkMaster";
    public static final String PROPERTY_MONGO_HOST = "schemaInference.mongoHost";
    public static final String PROPERTY_DB_NAME = "schemaInference.dbName";
    public static final String PROPERTY_OUTPUT_FILE = "schemaInference.outputFile";

    private static final String sparkMaster = System.getProperty(PROPERTY_SPARK_MASTER, "local[*]");
    private static final String mongoHost = System.getProperty(PROPERTY_MONGO_HOST, "localhost");
    private static final String dbName = System.getProperty(PROPERTY_DB_NAME, "inference");
    private static final String outputFile = System.getProperty(PROPERTY_OUTPUT_FILE, "build/schema.xml");

    public static void main(String[] args) throws IOException {
        DataLoader dataLoader = new MongoDataLoader(mongoHost, dbName);
        NoSQLSchema schema = SchemaInference.infer(sparkMaster, dataLoader, "Inference DB");
        SchemaInference.save(schema, Paths.get(outputFile));
    }

}
