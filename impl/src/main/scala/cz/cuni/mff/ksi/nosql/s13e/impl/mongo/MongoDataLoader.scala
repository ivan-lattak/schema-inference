package cz.cuni.mff.ksi.nosql.s13e.impl.mongo

import com.mongodb.spark.MongoSpark
import com.mongodb.spark.config.ReadConfig
import cz.cuni.mff.ksi.nosql.s13e.api.DataLoader
import cz.cuni.mff.ksi.nosql.s13e.impl.TypedDocumentImpl
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import play.api.libs.json.{JsNull, Json}

sealed case class MongoDataLoader(mongoHost: String,
                                  dbName: String) extends DataLoader[TypedDocumentImpl] {

  private def getReadConfig(collectionName: String): ReadConfig = ReadConfig(Map(
    "uri" -> s"mongodb://$mongoHost/",
    "database" -> dbName,
    "collection" -> collectionName,
  ))

  override def loadData(sparkSession: SparkSession): RDD[TypedDocumentImpl] = MongoSpark.load(sparkSession.sparkContext)
    .map(_.toJson)
    .filter(_.nonEmpty)
    .map { document =>
      try Json.parse(document.stripMargin)
      catch {
        case e: Throwable => e.printStackTrace(); JsNull
        //a quick trick to avoid crashing the app TODO improve
      }
    }

}
