package cz.cuni.mff.ksi.nosql.s13e.impl.inference.mongo

import com.mongodb.spark.config.ReadConfig
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.UnitTest
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.ContainedInPropertyMatcher.containedIn
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.bson.Document
import org.mongodb.scala.Observable
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import play.api.libs.json.Json

import scala.collection.immutable.HashMap
import scala.collection.mutable

class MongoDataLoaderTest extends UnitTest {

  describe("MongoDataLoader") {

    val MONGO_URI = "testMongoUri"
    val DB_NAME = "testDbName"

    val loader = new FakeMongoDataLoader(MONGO_URI, DB_NAME)

    it("should correctly load data") {
      val ss = SparkSession.builder().master("local[*]").getOrCreate()
      val actual = loader.loadData(ss.sparkContext)
        .collect()
        .groupBy(_.getTypeName)
        .mapValues(_.map(_.getDocument).toList)
      val expected = loader.database.mapValues(_.map(Json.parse))

      actual shouldEqual expected
    }

  }

}

private class FakeMongoDataLoader(override val mongoHost: String,
                                  override val dbName: String) extends MongoDataLoader(mongoHost, dbName) {

  val database: Map[String, List[String]] = HashMap(
    "collectionA" -> List(
      """{"x":0,"y":1}""",
      """{"x":0,"y":1,"z":2}""",
      """{"x":0,"y":1}""",
      """{"x":0,"y":1,"z":"Z"}""",
    ),
    "collectionB" -> List(
      """{"first":"John","last":"Doe"}""",
      """{"first":"Bruce","last":"Wayne","location":"BatCave"}""",
      """{"first":"Will","last":"Smith","location":{"city":"Bel Air","state":"CA"}}""",
      """{"first":"John","last":"Doe"}""",
      """{"first":"Tony","last":"Stark","age":null}""",
    ),
  )
  val collectionsRead: mutable.Map[String, Boolean] = mutable.HashMap(
    "collectionA" -> false,
    "collectionB" -> false,
  )

  override private[mongo] def listCollectionNames: Observable[String] = Observable(database.keys)

  override private[mongo] def loadDocuments(sc: SparkContext,
                                            config: ReadConfig): RDD[Document] = {
    checkConfig(config)
    sc.parallelize(database(config.collectionName).map(Document.parse))
  }

  private def checkConfig(config: ReadConfig): Unit = {
    config.connectionString shouldBe Some(s"mongodb://$mongoHost/")
    config.databaseName shouldEqual dbName
    config.collectionName shouldBe containedIn(database.keys)
    collectionsRead get config.collectionName shouldBe Some(false)
    collectionsRead(config.collectionName) = true
  }

}
