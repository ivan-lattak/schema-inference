package cz.cuni.mff.ksi.nosql.s13e;

import cz.cuni.mff.ksi.nosql.s13e.impl.DataLoader;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema;
import cz.cuni.mff.ksi.nosql.s13e.impl.SchemaInference;
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.mongo.MongoDataLoader;

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
                DataLoader dataLoader = new MongoDataLoader("localhost", dbName);
                long start = System.currentTimeMillis();
                NoSQLSchema schema = SchemaInference.infer("local[*]", dataLoader, "Inference DB");
                writer.println(System.currentTimeMillis() - start);
            }
        }
    }

}
