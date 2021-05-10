package cz.cuni.mff.ksi.nosql.s13e.api;

import cz.cuni.mff.ksi.nosql.s13e.impl.SchemaInferenceImpl;

import java.io.Writer;
import java.nio.file.Path;
import java.util.Set;

public final class SchemaInference {

    private SchemaInference() {
        throw new UnsupportedOperationException();
    }

    public static NoSqlSchema infer(String sparkMaster, DataLoader dataLoader) {
        return SchemaInferenceImpl.infer(sparkMaster, dataLoader);
    }

    public static NoSqlSchema extend(NoSqlSchema schema, String sparkMaster, DataLoader dataLoader) {

    }

    public static void convertToJsonSchema(NoSqlSchema schema, Entity rootEntity, Set<Entity> entitiesToFlatten) {

    }

    public static NoSqlSchema load(Path filePath) {

    }

    public static NoSqlSchema load(Writer writer) {

    }

    public static NoSqlSchema save(NoSqlSchema schema, Path filePath) {

    }

    public static NoSqlSchema save(NoSqlSchema schema, Writer writer) {

    }

}
