package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import com.fasterxml.jackson.databind.node.ObjectNode
import cz.cuni.mff.ksi.nosql.s13e.impl.DataLoader
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.{Entity, NoSQLSchema}
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.{EmptyInternalNoSqlSchema, InternalNoSqlSchema, NamedInternalNoSqlSchema}
import org.apache.spark.sql.SparkSession

import java.io.Writer
import java.nio.file.Path
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
    val newSchema = dataLoader.loadData(session.sparkContext)
      .map(TypedDocumentImpl.apply)
      .map(_.getRawSchema)
      .distinct()
      .map(Injector)
      .fold(baseSchema)(SchemaFolder)
    NamedInternalNoSqlSchema(schemaName, newSchema.entities)
  }

  def flatten(entity: Entity): NoSQLSchema = ???

  def convertToJsonSchema(schema: NoSQLSchema,
                          rootEntity: Entity): ObjectNode = ???

  def load(filePath: Path): NoSQLSchema = ???

  def load(writer: Writer): NoSQLSchema = ???

  def save(schema: NoSQLSchema,
           filePath: Path): NoSQLSchema = ???

  def save(schema: NoSQLSchema,
           writer: Writer): NoSQLSchema = ???

}
