package cz.cuni.mff.ksi.nosql.s13e.datagen;

import net.jimblackler.jsongenerator.Configuration;
import net.jimblackler.jsongenerator.Generator;
import net.jimblackler.jsongenerator.JsonGeneratorException;
import net.jimblackler.jsonschemafriend.GenerationException;
import net.jimblackler.jsonschemafriend.Schema;
import net.jimblackler.jsonschemafriend.SchemaStore;
import org.json.JSONArray;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class GenerateJson {

    public static final String PROPERTY_SEED = "datagen.seed";
    public static final String PROPERTY_DOCUMENT_COUNT = "datagen.documentCount";
    public static final String PROPERTY_OUTPUT_FILE = "datagen.outputFile";

    private static final long seed = Long.getLong(PROPERTY_SEED, 0xdeadbeef);
    private static final long documentCount = Long.getLong(PROPERTY_DOCUMENT_COUNT, 10_000);
    private static final String outputFile = System.getProperty(PROPERTY_OUTPUT_FILE, "build/generated.json");

    public static void main(String[] args) throws GenerationException, JsonGeneratorException, IOException {
        SchemaStore schemaStore = new SchemaStore();
        Schema schema = schemaStore.loadSchema(GenerateJson.class.getResource("schema.json"));
        Generator generator = new Generator(new GeneratorConfiguration(), schemaStore, new Random(seed));
        JSONArray array = new JSONArray();
        for (long i = 0; i < documentCount; i++) {
            array.put(generator.generate(schema, 100));
        }

        Path outputPath = Paths.get(outputFile);
        Files.createDirectories(outputPath.getParent());
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
            array.write(writer);
        }
    }

    private static class GeneratorConfiguration implements Configuration {

        @Override
        public boolean isPedanticTypes() {
            return false;
        }

        @Override
        public boolean isGenerateNulls() {
            return true;
        }

        @Override
        public boolean isGenerateMinimal() {
            return false;
        }

        @Override
        public float nonRequiredPropertyChance() {
            return .5f;
        }

    }

}
