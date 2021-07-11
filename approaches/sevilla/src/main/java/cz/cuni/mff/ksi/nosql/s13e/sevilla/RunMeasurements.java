package cz.cuni.mff.ksi.nosql.s13e.sevilla;

import com.google.gson.JsonArray;
import es.um.nosql.s13e.nosqlimport.db.mongodb.MongoDBImport;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RunMeasurements {

    public static void main(String[] args) throws IOException {
        int iterations = Integer.parseInt(args[0]);
        Path outputFile = Paths.get(args[1]);
        String dbName = args[2];

        try (BufferedWriter w = Files.newBufferedWriter(outputFile);
             PrintWriter writer = new PrintWriter(w)) {
            for (int i = 0; i < iterations; i++) {
                long start = System.currentTimeMillis();
                MongoDBImport importer = new MongoDBImport("localhost", dbName);
                JsonArray array = importer.mapRed2Array("mapreduce/v2");
                writer.println(System.currentTimeMillis() - start);
            }
        }
    }

}
