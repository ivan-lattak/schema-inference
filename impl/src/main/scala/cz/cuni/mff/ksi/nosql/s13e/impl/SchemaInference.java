package cz.cuni.mff.ksi.nosql.s13e.impl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema;
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.SchemaInferenceImpl;

import java.io.Writer;
import java.nio.file.Path;

public final class SchemaInference {

    private SchemaInference() {
        throw new UnsupportedOperationException();
    }

    public static NoSQLSchema infer(String sparkMaster, DataLoader dataLoader) {
        return SchemaInferenceImpl.infer(sparkMaster, dataLoader);
    }

    public static NoSQLSchema extend(NoSQLSchema schema, String sparkMaster, DataLoader dataLoader) {
        return SchemaInferenceImpl.extend(schema, sparkMaster, dataLoader);
    }

    public static NoSQLSchema flatten(Entity entity) {
        return SchemaInferenceImpl.flatten(entity);
    }

    public static ObjectNode convertToJsonSchema(NoSQLSchema schema, Entity rootEntity) {
        return SchemaInferenceImpl.convertToJsonSchema(schema, rootEntity);
    }

    public static NoSQLSchema load(Path filePath) {
        return SchemaInferenceImpl.load(filePath);
    }

    public static NoSQLSchema load(Writer writer) {
        return SchemaInferenceImpl.load(writer);
    }

    public static NoSQLSchema save(NoSQLSchema schema, Path filePath) {
        return SchemaInferenceImpl.save(schema, filePath);
    }

    public static NoSQLSchema save(NoSQLSchema schema, Writer writer) {
        return SchemaInferenceImpl.save(schema, writer);
    }

}
