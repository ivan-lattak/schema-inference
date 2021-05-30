package cz.cuni.mff.ksi.nosql.s13e.impl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema;
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.SchemaIO;
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.SchemaInferenceImpl;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.file.Path;

public final class SchemaInference {

    private SchemaInference() {
        throw new UnsupportedOperationException();
    }

    public static NoSQLSchema infer(String sparkMaster, DataLoader dataLoader, String schemaName) {
        return SchemaInferenceImpl.infer(sparkMaster, dataLoader, schemaName);
    }

    public static NoSQLSchema extend(NoSQLSchema schema, String sparkMaster, DataLoader dataLoader, @Nullable String newSchemaName) {
        return SchemaInferenceImpl.extend(schema, sparkMaster, dataLoader, newSchemaName);
    }

    public static NoSQLSchema flatten(Entity entity) {
        throw new UnsupportedOperationException();
    }

    public static ObjectNode convertToJsonSchema(NoSQLSchema schema, Entity rootEntity) {
        throw new UnsupportedOperationException();
    }

    public static NoSQLSchema load(Path filePath) {
        throw new UnsupportedOperationException();
    }

    public static NoSQLSchema load(Writer writer) {
        throw new UnsupportedOperationException();
    }

    public static NoSQLSchema save(NoSQLSchema schema, Path filePath) throws IOException {
        return SchemaIO.save(schema, filePath);
    }

    public static NoSQLSchema save(NoSQLSchema schema, OutputStream outputStream) throws IOException {
        return SchemaIO.save(schema, outputStream);
    }

}
