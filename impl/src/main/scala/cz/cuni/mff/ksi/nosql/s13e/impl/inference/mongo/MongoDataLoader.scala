package cz.cuni.mff.ksi.nosql.s13e.impl.inference.mongo

import com.mongodb.spark.MongoSpark
import com.mongodb.spark.config.ReadConfig
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.TypedDocumentImpl
import cz.cuni.mff.ksi.nosql.s13e.impl.{DataLoader, TypedDocument}
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.mongodb.scala.MongoClient
import play.api.libs.json.{JsObject, Json}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

sealed case class MongoDataLoader(mongoHost: String,
                                  dbName: String) extends DataLoader {

  private val mongoUri = s"mongodb://$mongoHost/"

  override def loadData(sc: SparkContext): RDD[TypedDocument] = {
    def getReadConfig(collectionName: String): ReadConfig = ReadConfig(Map(
      "uri" -> mongoUri,
      "database" -> dbName,
      "collection" -> collectionName,
    ))

    def loadFromCollection(collectionName: String): RDD[TypedDocument] =
      MongoSpark.load(sc, getReadConfig(collectionName))
        .map(_.toJson)
        .map(Json.parse(_).asInstanceOf[JsObject])
        .map(TypedDocumentImpl(collectionName, _))

    Await.result(MongoClient(mongoUri)
      .getDatabase(dbName)
      .listCollectionNames()
      .map(loadFromCollection)
      .foldLeft(sparkSession.sparkContext.emptyRDD[TypedDocument])(_.union(_))
      .head(), Duration.Inf)
  }

}
