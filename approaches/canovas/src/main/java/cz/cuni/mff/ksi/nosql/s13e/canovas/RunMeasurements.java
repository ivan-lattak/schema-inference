package cz.cuni.mff.ksi.nosql.s13e.canovas;

import jsondiscoverer.JsonSimpleDiscoverer;
import jsondiscoverer.JsonSource;
import org.eclipse.emf.ecore.EPackage;

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
                new MongoImporter("localhost", dbName, collectionName, "json").importToFile();
                JsonSource source = new JsonSource(collectionName);
                source.addJsonData(null, Files.newBufferedReader(Paths.get("json").resolve(collectionName + ".json")));

                JsonSimpleDiscoverer discoverer = new JsonSimpleDiscoverer();
                EPackage ePackage = discoverer.discover(source);
                writer.println(System.currentTimeMillis() - start);
            }
        }
    }

}
