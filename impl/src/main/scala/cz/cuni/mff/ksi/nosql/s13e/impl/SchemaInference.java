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

    /**
     * @param sparkMaster The Spark master URL to be used for the schema inference.
     * @param dataLoader  An instance of {@link DataLoader} which loads the dataset for which to infer the schema.
     * @param schemaName  The desired name for the returned schema.
     * @return A schema describing the dataset returned by {@code dataLoader}.
     */
    public static NoSQLSchema infer(String sparkMaster, DataLoader dataLoader, String schemaName) {
        return SchemaInferenceImpl.infer(sparkMaster, dataLoader, schemaName);
    }

    /**
     * @param schema        The schema to extend with schematic information retrieved from another dataset.
     * @param sparkMaster   The Spark master URL to be used for the schema inference.
     * @param dataLoader    An instance of {@link DataLoader} which loads the new dataset for which to infer the schema.
     * @param newSchemaName The desired name for the newly returned schema.
     * @return A schema describing the union of the initial and the new dataset.
     */
    public static NoSQLSchema extend(NoSQLSchema schema, String sparkMaster, DataLoader dataLoader, @Nullable String newSchemaName) {
        return SchemaInferenceImpl.extend(schema, sparkMaster, dataLoader, newSchemaName);
    }

    /**
     * @param schema The schema containing the {@link Entity} to flatten.
     * @param entity The {@link Entity} to flatten.
     * @return {@code schema}, with {@code entity} flattened.
     */
    public static NoSQLSchema flatten(NoSQLSchema schema, Entity entity) {
        return EntityFlattener.flatten(schema, entity);
    }

    /**
     * @param schema     The schema to convert to JSON Schema.
     * @param rootEntity The {@link Entity}, whose {@link EntityVersion#isRoot() root} {@link Entity#getVersions()
     *                   versions} to use as root versions in the JSON Schema.
     * @return a {@link JsObject} containing the resulting JSON Schema.
     */
    public static JsObject convertToJsonSchema(NoSQLSchema schema, Entity rootEntity) {
        return JsonSchemaConverter.convertToJsonSchema(schema, rootEntity);
    }

    /**
     * @param schema      The schema to convert to JSON Schema.
     * @param rootVersion The {@link EntityVersion} to use as the root version in the JSON Schema.
     * @return a {@link JsObject} containing the resulting JSON Schema.
     */
    public static JsObject convertToJsonSchema(NoSQLSchema schema, EntityVersion rootVersion) {
        return JsonSchemaConverter.convertToJsonSchema(schema, rootVersion);
    }

    /**
     * @param schema   The schema to save to file.
     * @param filePath Path to the file to save the schema to.
     * @return {@code schema}.
     * @throws IOException if anything goes wrong during saving.
     */
    public static NoSQLSchema save(NoSQLSchema schema, Path filePath) throws IOException {
        return SchemaIO.save(schema, filePath);
    }

    /**
     * @param schema       The schema to save to file.
     * @param outputStream The {@link OutputStream} to save the schema to.
     * @return {@code schema}.
     * @throws IOException if anything goes wrong during saving.
     */
    public static NoSQLSchema save(NoSQLSchema schema, OutputStream outputStream) throws IOException {
        return SchemaIO.save(schema, outputStream);
    }

    /**
     * @param filePath Path to the file to load the schema from.
     * @return The loaded schema.
     * @throws IOException if anything goes wrong during loading.
     */
    public static NoSQLSchema load(Path filePath) throws IOException {
        return SchemaIO.load(filePath);
    }

    /**
     * @param inputStream The {@link InputStream} to load the schema from.
     * @return The loaded schema.
     * @throws IOException if anything goes wrong during loading.
     */
    public static NoSQLSchema load(InputStream inputStream) throws IOException {
        return SchemaIO.load(inputStream);
    }

}
