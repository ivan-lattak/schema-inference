package cz.cuni.mff.ksi.nosql.s13e.impl;

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema;
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.EntityFlattener;
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.JsonSchemaConverter;
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.SchemaIO;
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.SchemaInferenceImpl;
import play.api.libs.json.JsObject;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

    public static NoSQLSchema flatten(NoSQLSchema schema, Entity entity) {
        return EntityFlattener.flatten(schema, entity);
    }

    public static JsObject convertToJsonSchema(NoSQLSchema schema, Entity rootEntity) {
        return JsonSchemaConverter.convertToJsonSchema(schema, rootEntity);
    }

    public static JsObject convertToJsonSchema(NoSQLSchema schema, EntityVersion rootVersion) {
        return JsonSchemaConverter.convertToJsonSchema(schema, rootVersion);
    }

    public static NoSQLSchema save(NoSQLSchema schema, Path filePath) throws IOException {
        return SchemaIO.save(schema, filePath);
    }

    public static NoSQLSchema save(NoSQLSchema schema, OutputStream outputStream) throws IOException {
        return SchemaIO.save(schema, outputStream);
    }

    public static NoSQLSchema load(Path filePath) throws IOException {
        return SchemaIO.load(filePath);
    }

    public static NoSQLSchema load(InputStream inputStream) throws IOException {
        return SchemaIO.load(inputStream);
    }

}
