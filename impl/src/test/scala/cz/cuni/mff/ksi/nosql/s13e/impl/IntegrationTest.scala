package cz.cuni.mff.ksi.nosql.s13e.impl

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.{Entity, EntityVersion, Property}
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.mongo.MongoDataLoader
import cz.cuni.mff.ksi.nosql.s13e.impl.testUtil.ModelCheckers
import org.scalatest.Tag
import org.scalatest.funspec.PathAnyFunSpec
import org.scalatest.matchers.should.Matchers

import java.nio.file.Files
import scala.collection.JavaConverters.collectionAsScalaIterableConverter

class IntegrationTest extends PathAnyFunSpec with Matchers with ModelCheckers {

  private type JList[E] = java.util.List[E]

  private val PREFIX = "impl.integrationTest"

  private val mongoHost = System.getProperty(s"$PREFIX.mongoHost", "localhost")
  private val dbName = System.getProperty(s"$PREFIX.dbName", "inference")
  private val sparkMaster = System.getProperty(s"$PREFIX.sparkMaster", "local[*]")

  describe("SchemaInference") {

    val dataLoader = MongoDataLoader(mongoHost, dbName)
    val schema = SchemaInference.infer(sparkMaster, dataLoader, "Inference DB")

    describe("infer") {

      it("should correctly infer the schema of the inference database", IntegrationTest) {
        checkRunningExampleSchema(schema)
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

    }

    describe("flatten") {

      def flatten(schema: NoSQLSchema.NoSQLSchema, entities: String*): Unit = {
        for (name <- entities) {
          val entity = schema.getEntities.asScala.find(_.getName == name)
          entity shouldBe defined
          SchemaInference.flatten(schema, entity.get)
        }
      }

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
      checkEntity(schema.getEntities.get(0), "article*", root = true, (0, 2)) { versions =>
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
      checkEntity(schema.getEntities.get(0), "article", root = true, (0, 1), (0, 1)) { versions =>
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

    checkEntity(schema.getEntities.get(1), "attachment", false, (1, 1)) { versions =>
      checkProperties(versions.get(0).getProperties, "url" -> aString)
    }

    if (authorFlat) {
      checkEntity(schema.getEntities.get(2), "author*", false, if (articleFlat) (1, 1) else (2, 0)) { versions =>
        checkProperties(versions.get(0).getProperties,
          "first_name" -> aString,
          "last_name" -> aString,
          "location" -> (if (locationFlat) anAggregateOf(location1) else aUnionOf(anAggregateOf(location1), anAggregateOf(location2.get))),
          "phone_number" -> aUnionOf(aNumber, aString),
        )
      }
    } else {
      checkEntity(schema.getEntities.get(2), "author", false, (1, 0), (1, 0)) { versions =>
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

    checkEntity(schema.getEntities.get(3), "body", false, (1, 0)) { versions =>
      checkProperties(versions.get(0).getProperties,
        "content" -> aString,
        "mime_type" -> aString,
      )
    }

    if (locationFlat) {
      checkEntity(schema.getEntities.get(4), "location*", false, if (authorFlat) (1, 1) else (2, 0)) { versions =>
        checkProperties(versions.get(0).getProperties,
          "address?" -> aString,
          "latitude?" -> aString,
          "longitude?" -> aString,
        )
      }
    } else {
      checkEntity(schema.getEntities.get(4), "location", false, (1, 0), (1, 0)) { versions =>
        checkProperties(versions.get(0).getProperties, "address" -> aString)
        checkProperties(versions.get(1).getProperties,
          "latitude" -> aString,
          "longitude" -> aString,
        )
      }
    }
  }

  private def checkEntity(entity: Entity, name: String, root: Boolean, expected: (Int, Int)*)
                         (checker: JList[EntityVersion] => Unit): Unit = {
    val expectedFlattened = name endsWith "*"
    entity.getName shouldBe name.stripSuffix("*")
    entity.isRoot shouldBe root
    entity.isFlattened shouldBe expectedFlattened

    val versions = entity.getVersions
    versions should have size expected.size
    Stream from 0 zip expected foreach {
      case (index, (aggregates, additional)) =>
        val version = versions.get(index)
        version.getId shouldBe index
        version.getAggregates should have size aggregates
        version.getAdditionalCount shouldBe additional
    }

    checker(entity.getVersions)
  }

  private def checkProperties(properties: JList[Property], expected: (String, TypeChecker)*): Unit = {
    properties should have size expected.size
    properties.asScala zip expected foreach {
      case (prop, (name, typeChecker)) =>
        val expectedOptional = name endsWith "?"
        prop.getName shouldBe name.stripSuffix("?")
        prop.isOptional shouldBe expectedOptional
        typeChecker(prop.getType)
    }
  }

}

object IntegrationTest extends Tag("IntegrationTest")
