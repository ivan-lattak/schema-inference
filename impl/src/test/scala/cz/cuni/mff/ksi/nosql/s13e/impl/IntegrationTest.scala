package cz.cuni.mff.ksi.nosql.s13e.impl

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.mongo.MongoDataLoader
import cz.cuni.mff.ksi.nosql.s13e.impl.testUtil.ModelChecking
import org.scalatest.Tag
import org.scalatest.funspec.PathAnyFunSpec
import org.scalatest.matchers.should.Matchers

import java.nio.file.Files
import scala.collection.JavaConverters.collectionAsScalaIterableConverter
import scala.io.Source

class IntegrationTest extends PathAnyFunSpec with Matchers with ModelChecking {

  private val PREFIX = "impl.integrationTest"

  private val mongoHost = System.getProperty(s"$PREFIX.mongoHost", "localhost")
  private val dbName = System.getProperty(s"$PREFIX.dbName", "inference")
  private val sparkMaster = System.getProperty(s"$PREFIX.sparkMaster", "local[*]")

  describe("SchemaInference") {

    val dataLoader = MongoDataLoader(mongoHost, dbName)
    val schema = SchemaInference.infer(sparkMaster, dataLoader, "Inference DB")

    def flatten(schema: NoSQLSchema.NoSQLSchema, entities: String*): Unit = {
      for (name <- entities) {
        val entity = schema.getEntities.asScala.find(_.getName == name)
        entity shouldBe defined
        SchemaInference.flatten(schema, entity.get)
      }
    }

    describe("infer") {

      it("should correctly infer the schema of the inference database", IntegrationTest) {
        checkRunningExampleSchema(schema)
      }

    }

    describe("flatten") {

      it("should correctly flatten article entity", IntegrationTest) {
        flatten(schema, "article")
        checkRunningExampleSchema(schema, articleFlat = true)
      }

      it("should correctly flatten author entity", IntegrationTest) {
        flatten(schema, "author")
        checkRunningExampleSchema(schema, authorFlat = true)
      }

      it("should correctly flatten location entity", IntegrationTest) {
        flatten(schema, "location")
        checkRunningExampleSchema(schema, locationFlat = true)
      }

      it("should correctly flatten article and author entities", IntegrationTest) {
        flatten(schema, "article", "author")
        checkRunningExampleSchema(schema, articleFlat = true, authorFlat = true)
      }

      it("should correctly flatten article and location entities", IntegrationTest) {
        flatten(schema, "article", "location")
        checkRunningExampleSchema(schema, articleFlat = true, locationFlat = true)
      }

      it("should correctly flatten author and location entities", IntegrationTest) {
        flatten(schema, "author", "location")
        checkRunningExampleSchema(schema, authorFlat = true, locationFlat = true)
      }

      it("should correctly flatten all entities", IntegrationTest) {
        flatten(schema, "author", "location", "article")
        checkRunningExampleSchema(schema, articleFlat = true, authorFlat = true, locationFlat = true)
      }

    }

    describe("save and load") {

      they("should correctly save to file and then load from file", IntegrationTest) {
        val path = Files.createTempFile("SchemaInferenceIntegrationTest", ".xml")
        SchemaInference.save(schema, path)
        path.toFile should exist

        val loaded = SchemaInference.load(path)
        checkRunningExampleSchema(loaded)
      }

      they("should correctly save to file and then load from file even after flattening", IntegrationTest) {
        flatten(schema, "author", "location", "article")
        val path = Files.createTempFile("SchemaInferenceIntegrationTest", ".xml")
        SchemaInference.save(schema, path)
        path.toFile should exist

        val loaded = SchemaInference.load(path)
        checkRunningExampleSchema(loaded, articleFlat = true, authorFlat = true, locationFlat = true)
      }

    }

    describe("convert to JSON Schema") {

      def readClassPathResource(file: String): String = {
        val source = Source.fromInputStream(getClass.getResourceAsStream(file))
        try source.mkString finally source.close()
      }

      it("should correctly convert", IntegrationTest) {
        val expected = readClassPathResource("running_example_article_root.json")
        val article :: _ = schema.getEntities.asScala.toList
        SchemaInference.convertToJsonSchema(schema, article).toString() shouldBe expected
      }

      describe("when author is flattened") {

        val _ :: _ :: author :: _ = schema.getEntities.asScala.toList
        SchemaInference.flatten(schema, author)

        it("should correctly convert", IntegrationTest) {
          val expected = readClassPathResource("running_example_flattened_author.json")
          val article :: _ = schema.getEntities.asScala.toList
          SchemaInference.convertToJsonSchema(schema, article).toString() shouldBe expected
        }

      }

    }

  }

  private def checkRunningExampleSchema(schema: NoSQLSchema.NoSQLSchema,
                                        articleFlat: Boolean = false,
                                        authorFlat: Boolean = false,
                                        locationFlat: Boolean = false): Unit = {
    schema.getName shouldBe "Inference DB"
    schema.getEntities should have size 5

    val article = schema.getEntities.get(0)
    val attachment = schema.getEntities.get(1).getVersions.get(0)

    val authorNum = schema.getEntities.get(2).getVersions.get(0)
    val authorStr = if (authorFlat) None else Some(schema.getEntities.get(2).getVersions.get(1))

    val body = schema.getEntities.get(3).getVersions.get(0)

    val location1 = schema.getEntities.get(4).getVersions.get(0)
    val location2 = if (locationFlat) None else Some(schema.getEntities.get(4).getVersions.get(1))

    if (articleFlat) {
      checkEntity(schema.getEntities.get(0), "article*", (true, 0, 2)) { versions =>
        checkProperties(versions.get(0).getProperties,
          "_id" -> aNumber,
          "article_id?" -> aReferenceOf(article, aNumber),
          "attachments?" -> anArrayOf(anAggregateOf(attachment)),
          "author" -> (if (authorFlat) anAggregateOf(authorNum) else aUnionOf(anAggregateOf(authorNum), anAggregateOf(authorStr.get))),
          "body" -> aUnionOf(aString, anAggregateOf(body)),
          "comments" -> aUnionOf(aString, anArrayOf(aString)),
          "published" -> aBoolean,
          "ratings" -> anArrayOf(aNumber),
          "timestamp" -> aString,
        )
      }
    } else {
      checkEntity(schema.getEntities.get(0), "article", (true, 0, 1), (true, 0, 1)) { versions =>
        checkProperties(versions.get(0).getProperties,
          "_id" -> aNumber,
          "article_id" -> aReferenceOf(article, aNumber),
          "author" -> anAggregateOf(authorNum),
          "body" -> aString,
          "comments" -> aString,
          "published" -> aBoolean,
          "ratings" -> anArrayOf(aNumber),
          "timestamp" -> aString,
        )
        checkProperties(versions.get(1).getProperties,
          "_id" -> aNumber,
          "attachments" -> anArrayOf(anAggregateOf(attachment)),
          "author" -> anAggregateOf(if (authorFlat) authorNum else authorStr.get),
          "body" -> anAggregateOf(body),
          "comments" -> anArrayOf(aString),
          "published" -> aBoolean,
          "ratings" -> anArrayOf(aNumber),
          "timestamp" -> aString,
        )
      }
    }

    checkEntity(schema.getEntities.get(1), "attachment", (false, 1, 1)) { versions =>
      checkProperties(versions.get(0).getProperties, "url" -> aString)
    }

    if (authorFlat) {
      checkEntity(schema.getEntities.get(2), "author*", if (articleFlat) (false, 1, 1) else (false, 2, 0)) { versions =>
        checkProperties(versions.get(0).getProperties,
          "first_name" -> aString,
          "last_name" -> aString,
          "location" -> (if (locationFlat) anAggregateOf(location1) else aUnionOf(anAggregateOf(location1), anAggregateOf(location2.get))),
          "phone_number" -> aUnionOf(aNumber, aString),
        )
      }
    } else {
      checkEntity(schema.getEntities.get(2), "author", (false, 1, 0), (false, 1, 0)) { versions =>
        checkProperties(versions.get(0).getProperties,
          "first_name" -> aString,
          "last_name" -> aString,
          "location" -> anAggregateOf(location1),
          "phone_number" -> aNumber,
        )
        checkProperties(versions.get(1).getProperties,
          "first_name" -> aString,
          "last_name" -> aString,
          "location" -> anAggregateOf(if (locationFlat) location1 else location2.get),
          "phone_number" -> aString,
        )
      }
    }

    checkEntity(schema.getEntities.get(3), "body", (false, 1, 0)) { versions =>
      checkProperties(versions.get(0).getProperties,
        "content" -> aString,
        "mime_type" -> aString,
      )
    }

    if (locationFlat) {
      checkEntity(schema.getEntities.get(4), "location*", if (authorFlat) (false, 1, 1) else (false, 2, 0)) { versions =>
        checkProperties(versions.get(0).getProperties,
          "address?" -> aString,
          "latitude?" -> aString,
          "longitude?" -> aString,
        )
      }
    } else {
      checkEntity(schema.getEntities.get(4), "location", (false, 1, 0), (false, 1, 0)) { versions =>
        checkProperties(versions.get(0).getProperties, "address" -> aString)
        checkProperties(versions.get(1).getProperties,
          "latitude" -> aString,
          "longitude" -> aString,
        )
      }
    }
  }

}

object IntegrationTest extends Tag("IntegrationTest")
