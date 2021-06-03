package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.DataLoader
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.{EmptyInternalNoSqlSchema, InternalNoSqlSchema, NamedInternalNoSqlSchema}
import org.apache.spark.sql.SparkSession

import javax.annotation.Nullable

case object SchemaInferenceImpl {

  def infer(sparkMaster: String,
            dataLoader: DataLoader,
            schemaName: String): NoSQLSchema =
    Converter.internalToModel(
      createInternal(sparkMaster, dataLoader, schemaName))

  def extend(schema: NoSQLSchema,
             sparkMaster: String,
             dataLoader: DataLoader,
             @Nullable newSchemaName: String): NoSQLSchema = {
    if (schema.getEntities.stream().anyMatch(_.isFlattened)) {
      throw new IllegalArgumentException("Cannot extend a schema containing a flattened entity")
    }

    val internalSchema = Converter.modelToInternal(schema)
    Converter.internalToModel(
      createInternal(sparkMaster, dataLoader,
        Option(newSchemaName).getOrElse(internalSchema.name),
        internalSchema))
  }

  private def createInternal(sparkMaster: String,
                             dataLoader: DataLoader,
                             schemaName: String,
                             baseSchema: InternalNoSqlSchema = EmptyInternalNoSqlSchema): NamedInternalNoSqlSchema = {
    val session = SparkSession.builder()
      .master(sparkMaster)
      .appName("NoSQL Schema Inference")
      .getOrCreate()
    dataLoader.loadData(session.sparkContext)
      .map(TypedDocumentImpl.apply)
      .map(_.getRawSchema)
      .distinct()
      .map(Injector)
      .fold(baseSchema)(SchemaFolder)
      .named(schemaName)
  }

}
