package parametric

import com.mongodb.spark.MongoSpark
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import parametric.typeDefinition._
import parametric.typeInference._
import parametric.typeReduction._
import play.api.libs.json.{JsNull, JsValue, Json}

object SchemaInference {
  def infer(sparkMaster: String,
            mongoHost: String,
            dbName: String,
            collectionName: String,
            equivalence: String): CountingType = {
    val spark = SparkSession.builder()
      .master(sparkMaster)
      .appName("JSON Schema Inference, Baazizi Approach")
      .config("spark.mongodb.input.uri", s"mongodb://$mongoHost/")
      .config("spark.mongodb.input.database", dbName)
      .config("spark.mongodb.input.collection", collectionName)
      .getOrCreate()

    try {
      println(s"infer the $equivalence schema from MongoDB collection at $mongoHost/$dbName/$collectionName")
      val helper: Helper = new Helper()
      val order: (StructuralType, StructuralType) => Int = helper.whichOrdering(equivalence)
      /* load json documents */
      val objects: RDD[String] = MongoSpark.load(spark.sparkContext).map(_.toJson)

      /* infer the schema */
      val reduction = new Reduction()
      val inference = new Inference()

      val parsed: RDD[JsValue] = objects.filter(_.nonEmpty).map { document =>
        try Json.parse(document.stripMargin)
        catch {
          case e: Throwable => e.printStackTrace(); JsNull
          //a quick trick to avoid crashing the app TODO improve
        }
      }
      val types: RDD[CountingType] = parsed.map(x => inference.inferStructType(x, reduction.Reduce, order).asInstanceOf[CountingType])
      types.reduce((t, u) => reduction.Reduce(t, u, order))
    } finally {
      spark.stop()
    }
  }
}
