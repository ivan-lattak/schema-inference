package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import com.fasterxml.jackson.databind.node.ObjectNode
import cz.cuni.mff.ksi.nosql.s13e.impl.DataLoader
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.{Entity, NoSQLSchema}
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.{EmptyInternalNoSqlSchema, SchemaConverter}
import org.apache.spark.sql.SparkSession

import java.io.Writer
import java.nio.file.Path
import javax.annotation.Nullable

case object SchemaInferenceImpl {

  def infer(sparkMaster: String,
            dataLoader: DataLoader,
            schemaName: String): NoSQLSchema = {
    val session = SparkSession.builder()
      .master(sparkMaster)
      .appName("NoSQL Schema Inference")
      .getOrCreate()
    val internalSchema = dataLoader.loadData(session)
      .map(TypedDocumentImpl.apply)
      .map(_.getRawSchema)
      .distinct()
      .map(Injector(schemaName))
      .fold(EmptyInternalNoSqlSchema(schemaName))(Combiner)
    SchemaConverter.internalToModel(internalSchema)
  }

  def extend(schema: NoSQLSchema,
             sparkMaster: String,
             dataLoader: DataLoader,
             @Nullable newSchemaName: String): NoSQLSchema = ???

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
