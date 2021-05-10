package cz.cuni.mff.ksi.nosql.s13e.impl

import cz.cuni.mff.ksi.nosql.s13e.api.{DataLoader, NoSqlSchema}
import org.apache.spark.sql.SparkSession

object SchemaInferenceImpl {

  def infer(sparkMaster: String,
            dataLoader: DataLoader): NoSqlSchema = {
    val session = SparkSession.builder()
      .master(sparkMaster)
      .appName("NoSQL Schema Inference")
      .getOrCreate()
    val reduced = dataLoader.loadData(session)
      .map(TypedDocumentImpl.apply)
      .map(_.getRawSchema)
      .distinct()
  }

}
