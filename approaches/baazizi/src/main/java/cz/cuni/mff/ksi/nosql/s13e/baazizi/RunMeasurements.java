package cz.cuni.mff.ksi.nosql.s13e.baazizi;

import parametric.SchemaInference;

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
        String collectionName = args[3];

        try (BufferedWriter w = Files.newBufferedWriter(outputFile);
             PrintWriter writer = new PrintWriter(w)) {
            for (int i = 0; i < iterations; i++) {
                long start = System.currentTimeMillis();
                SchemaInference.infer("local[*]", "localhost", dbName, collectionName, "k");
                writer.println(System.currentTimeMillis() - start);
            }
        }
    }

}
