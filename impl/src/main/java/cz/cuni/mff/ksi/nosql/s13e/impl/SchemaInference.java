package cz.cuni.mff.ksi.nosql.s13e.impl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import cz.cuni.mff.ksi.nosql.s13e.impl.impl.SchemaInferenceImpl;

import java.io.Writer;
import java.nio.file.Path;

public final class SchemaInference {

    private SchemaInference() {
        throw new UnsupportedOperationException();
    }

    public static NoSqlSchema infer(String sparkMaster, DataLoader dataLoader) {
        return SchemaInferenceImpl.infer(sparkMaster, dataLoader);
    }

    public static NoSqlSchema extend(NoSqlSchema schema, String sparkMaster, DataLoader dataLoader) {
        return SchemaInferenceImpl.extend(schema, sparkMaster, dataLoader);
    }

    public static NoSqlSchema flatten(Entity entity) {
        return SchemaInferenceImpl.flatten(entity);
    }

    public static ObjectNode convertToJsonSchema(NoSqlSchema schema, Entity rootEntity) {
        return SchemaInferenceImpl.convertToJsonSchema(schema, rootEntity);
    }

    public static NoSqlSchema load(Path filePath) {
        return SchemaInferenceImpl.load(filePath);
    }

    public static NoSqlSchema load(Writer writer) {
        return SchemaInferenceImpl.load(writer);
    }

    public static NoSqlSchema save(NoSqlSchema schema, Path filePath) {
        return SchemaInferenceImpl.save(schema, filePath);
    }

    public static NoSqlSchema save(NoSqlSchema schema, Writer writer) {
        return SchemaInferenceImpl.save(schema, writer);
    }

}
