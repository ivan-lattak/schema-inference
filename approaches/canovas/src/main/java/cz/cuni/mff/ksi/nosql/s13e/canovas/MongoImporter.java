package cz.cuni.mff.ksi.nosql.s13e.canovas;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bson.Document;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class MongoImporter {

    String host;
    String dbName;
    String collectionName;
    String outputDir;

    public void importToFile() throws IOException {
        MongoClient client = new MongoClient(host, 27017);
        MongoDatabase database = client.getDatabase(dbName);
        if (!Files.exists(Paths.get(outputDir))) {
            Files.createDirectory(Paths.get(outputDir));
        }

        JsonArray documents = new JsonArray();
        Spliterator<Document> spliterator = database.getCollection(collectionName).find().spliterator();
        StreamSupport.stream(spliterator, false)
                .map(MongoImporter::jsonObjectFromDocument)
                .forEach(documents::add);

        Path jsonFile = Paths.get(outputDir).resolve(collectionName + ".json");
        try (BufferedWriter writer = Files.newBufferedWriter(jsonFile)) {
            new Gson().toJson(documents, writer);
        }
    }

    private static JsonObject jsonObjectFromDocument(Document document) {
        return new JsonParser().parse(document.toJson()).getAsJsonObject();
    }

}
