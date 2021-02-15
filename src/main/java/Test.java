import com.google.gson.JsonArray;
import es.um.nosql.s13e.json2dbschema.main.BuildNoSQLSchema;
import es.um.nosql.s13e.nosqlimport.db.mongodb.MongoDBImport;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test {

    private static final String MONGO_HOST = "localhost";
    private static final String DB_NAME = "inference";

    public static void main(String[] args) throws IOException {
        MongoDBImport importer = new MongoDBImport(MONGO_HOST, DB_NAME);
        JsonArray array = importer.mapRed2Array("approaches/sevilla/mapreduce/v2");
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("schema.json"))) {
            writer.write(array.toString());
        }

        new BuildNoSQLSchema().buildFromGsonArray(DB_NAME, array, "schema.xml");
    }

}
