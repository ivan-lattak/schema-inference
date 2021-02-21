package cz.cuni.mff.dsi.nosql.s13e.canovas.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Spliterator;
import java.util.stream.StreamSupport;

public class MongoImporter {

    private final String host;
    private final String dbName;
    private final String collectionName;
    private final String outputDir;

    public MongoImporter(String host, String dbName, String collectionName, String outputDir) {
        this.host = host;
        this.dbName = dbName;
        this.collectionName = collectionName;
        this.outputDir = outputDir;
    }

    public void importToFile() throws IOException {
        MongoClient client = new MongoClient(host, 27017);
        MongoDatabase database = client.getDatabase(dbName);
        if (!Files.exists(Path.of(outputDir))) {
            Files.createDirectory(Path.of(outputDir));
        }

        JsonArray documents = new JsonArray();
        Spliterator<Document> spliterator = database.getCollection(collectionName).find().spliterator();
        StreamSupport.stream(spliterator, false)
                .map(MongoImporter::jsonObjectFromDocument)
                .forEach(documents::add);

        Path jsonFile = Path.of(outputDir).resolve(collectionName + ".json");
        try (BufferedWriter writer = Files.newBufferedWriter(jsonFile)) {
            new Gson().toJson(documents, writer);
        }
    }

    private static JsonObject jsonObjectFromDocument(Document document) {
        return new JsonParser().parse(document.toJson()).getAsJsonObject();
    }

}
