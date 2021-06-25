package cz.cuni.mff.ksi.nosql.s13e.impl.inference.mongo

import com.mongodb.spark.MongoSpark
import com.mongodb.spark.config.ReadConfig
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.TypedDocumentImpl
import cz.cuni.mff.ksi.nosql.s13e.impl.{DataLoader, TypedDocument}
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.bson.Document
import org.mongodb.scala.{MongoClient, Observable}
import play.api.libs.json.{JsObject, Json}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
 * Loads data from a MongoDB database given by the constructor parameters.
 *
 * @param mongoHost The hostname of the MongoDB instance to load the data from.
 * @param dbName    The name of the database to load the data from.
 */
case class MongoDataLoader(mongoHost: String,
                           dbName: String) extends DataLoader {

  private val mongoUri = s"mongodb://$mongoHost/"

  override def loadData(sc: SparkContext): RDD[TypedDocument] = {
    def getReadConfig(collectionName: String): ReadConfig = ReadConfig(Map(
      "uri" -> mongoUri,
      "database" -> dbName,
      "collection" -> collectionName,
    ))

    def loadFromCollection(collectionName: String): RDD[TypedDocument] =
      loadDocuments(sc, getReadConfig(collectionName))
        .map(_.toJson)
        .map(Json.parse(_).asInstanceOf[JsObject])
        .map(TypedDocumentImpl(collectionName, _))

    Await.result(listCollectionNames
      .map(loadFromCollection)
      .collect()
      .map(sc.union(_))
      .head(), Duration.Inf)
  }

  private[mongo] def listCollectionNames: Observable[String] =
    MongoClient(mongoUri)
      .getDatabase(dbName)
      .listCollectionNames()

  private[mongo] def loadDocuments(sc: SparkContext,
                                   config: ReadConfig): RDD[Document] = MongoSpark.load(sc, config)

}
