package cz.cuni.mff.ksi.nosql.s13e.impl.impl

import com.fasterxml.jackson.databind.node.ObjectNode
import cz.cuni.mff.ksi.nosql.s13e.impl.DataLoader
import org.apache.spark.sql.SparkSession

import java.io.Writer
import java.nio.file.Path

object SchemaInferenceImpl {

  def infer(sparkMaster: String,
            dataLoader: DataLoader): NoSqlSchema = {
    val session = SparkSession.builder()
      .master(sparkMaster)
      .appName("NoSQL Schema Inference")
      .getOrCreate()
    val docs = dataLoader.loadData(session).map(TypedDocumentImpl.apply)
    val schemas = docs.map(_.getRawSchema).distinct()
    schemas.map()
  }

  def extend(schema: NoSqlSchema, sparkMaster: String, dataLoader: DataLoader): NoSqlSchema = ???

  def flatten(entity: Entity): NoSqlSchema = ???

  def convertToJsonSchema(schema: NoSqlSchema, rootEntity: Entity): ObjectNode = ???

  def load(filePath: Path): NoSqlSchema = ???

  def load(writer: Writer): NoSqlSchema = ???

  def save(schema: NoSqlSchema, filePath: Path): NoSqlSchema = ???

  def save(schema: NoSqlSchema, writer: Writer): NoSqlSchema = ???

}
