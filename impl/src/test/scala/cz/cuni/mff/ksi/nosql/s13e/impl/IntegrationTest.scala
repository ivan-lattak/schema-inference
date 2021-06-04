package cz.cuni.mff.ksi.nosql.s13e.impl

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.{Aggregate, Entity, EntityReference, EntityVersion, Property, Type}
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.mongo.MongoDataLoader
import org.scalatest.Tag
import org.scalatest.funspec.PathAnyFunSpec
import org.scalatest.matchers.should.Matchers

import java.nio.file.Files

class IntegrationTest extends PathAnyFunSpec with Matchers {

  private type JList[E] = java.util.List[E]

  private val PREFIX = "impl.integrationTest"

  private val mongoHost = System.getProperty(s"$PREFIX.mongoHost", "localhost")
  private val dbName = System.getProperty(s"$PREFIX.dbName", "inference")
  private val sparkMaster = System.getProperty(s"$PREFIX.sparkMaster", "local[*]")

  describe("SchemaInference.infer") {

    it("should correctly infer the schema of the inference database", IntegrationTest) {
      val dataLoader = MongoDataLoader(mongoHost, dbName)
      val schema = SchemaInference.infer(sparkMaster, dataLoader, "Inference DB")

      checkSchemaForRunningExample(schema)
    }

  }

  describe("SchemaInference.save and .load") {

    they("should correctly save to file and then load from file", IntegrationTest) {
      val path = Files.createTempFile("SchemaInferenceIntegrationTest", ".xml")
      val dataLoader = MongoDataLoader(mongoHost, dbName)
      val schema = SchemaInference.infer(sparkMaster, dataLoader, "Inference DB")

      SchemaInference.save(schema, path)
      path.toFile should exist

      val loaded = SchemaInference.load(path)
      checkSchemaForRunningExample(loaded)
    }

  }

  describe("SchemaInference.flatten") {

    it("should correctly flatten article entity", IntegrationTest) {
      // TODO this
    }

  }

  private def checkSchemaForRunningExample(schema: NoSQLSchema.NoSQLSchema): Unit = {
    schema.getName shouldBe "Inference DB"
    schema.getEntities should have size 5

    val article = schema.getEntities.get(0)
    val attachment = schema.getEntities.get(1).getVersions.get(0)
    val authorNum = schema.getEntities.get(2).getVersions.get(0)
    val authorStr = schema.getEntities.get(2).getVersions.get(1)
    val body = schema.getEntities.get(3).getVersions.get(0)
    val location1 = schema.getEntities.get(4).getVersions.get(0)
    val location2 = schema.getEntities.get(4).getVersions.get(1)

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
        "author" -> anAggregateOf(authorStr),
        "body" -> anAggregateOf(body),
        "comments" -> anArrayOf(aString),
        "published" -> aBoolean,
        "ratings" -> anArrayOf(aNumber),
        "timestamp" -> aString,
      )
    }

    checkEntity(schema.getEntities.get(1), "attachment", false, (1, 1)) { versions =>
      checkProperties(versions.get(0).getProperties, "url" -> aString)
    }

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
        "location" -> anAggregateOf(location2),
        "phone_number" -> aString,
      )
    }

    checkEntity(schema.getEntities.get(3), "body", false, (1, 0)) { versions =>
      checkProperties(versions.get(0).getProperties,
        "content" -> aString,
        "mime_type" -> aString,
      )
    }

    checkEntity(schema.getEntities.get(4), "location", false, (1, 0), (1, 0)) { versions =>
      checkProperties(versions.get(0).getProperties, "address" -> aString)
      checkProperties(versions.get(1).getProperties,
        "latitude" -> aString,
        "longitude" -> aString,
      )
    }
  }

  private def checkEntity(entity: Entity, name: String, root: Boolean, expected: (Int, Int)*)
                         (checker: JList[EntityVersion] => Unit): Unit = {
    entity.getName shouldBe name
    entity.isRoot shouldBe root
    entity.isFlattened shouldBe false

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
    Stream from 0 zip expected foreach {
      case (index, (name, typeChecker)) =>
        val prop = properties.get(index)
        prop.getName shouldBe name
        prop.isOptional shouldBe false
        typeChecker.check(prop.getType)
    }
  }

  private def aBoolean: TypeChecker = t => t shouldBe a[NoSQLSchema.Boolean]

  private def aNumber: TypeChecker = t => t shouldBe a[NoSQLSchema.Number]

  private def aString: TypeChecker = t => t shouldBe a[NoSQLSchema.String]

  private def anArrayOf(inner: TypeChecker): TypeChecker = t => {
    t shouldBe a[NoSQLSchema.Array]
    inner.check(t.asInstanceOf[NoSQLSchema.Array].getElementType)
  }

  private def anAggregateOf(target: EntityVersion): TypeChecker = t => {
    t shouldBe an[Aggregate]
    t.asInstanceOf[Aggregate].getTarget shouldBe target
  }

  private def aReferenceOf(target: Entity, originalTypeChecker: TypeChecker): TypeChecker = t => {
    t shouldBe an[EntityReference]
    t.asInstanceOf[EntityReference].getTarget shouldBe target
    originalTypeChecker.check(t.asInstanceOf[EntityReference].getOriginalType)
  }

  private trait TypeChecker {
    def check(`type`: Type): Unit
  }

}

object IntegrationTest extends Tag("IntegrationTest")
