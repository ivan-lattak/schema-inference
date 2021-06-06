package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.{Aggregate, Entity, EntityReference, EntityVersion, PrimitiveType, Type, UnionType, UnknownType}
import play.api.libs.json._

import scala.collection.JavaConverters.collectionAsScalaIterableConverter
import scala.collection.mutable

object JsonSchemaConverter {

  def convertToJsonSchema(schema: NoSQLSchema.NoSQLSchema, rootEntity: Entity): JsObject =
    convertToJsonSchema(schema, rootEntity.getVersions.asScala.toList)

  def convertToJsonSchema(schema: NoSQLSchema.NoSQLSchema, rootVersion: EntityVersion): JsObject =
    convertToJsonSchema(schema, List(rootVersion))

  private def convertToJsonSchema(schema: NoSQLSchema.NoSQLSchema, rootVersions: List[EntityVersion]): JsObject =
    new JsonSchemaBuilder(schema, rootVersions).build

  private class JsonSchemaBuilder(schema: NoSQLSchema.NoSQLSchema, rootVersions: List[EntityVersion])
    extends VersionTraversal {

    // maps all versions in the NoSQL schema to the name of their containing entities
    private val versionToEntityName: Map[EntityVersion, String] =
      schema.getEntities.asScala
        .flatMap { entity =>
          entity.getVersions.asScala zip Stream.continually(entity.getName)
        }.toMap

    // Contains only versions that will be used in the resulting JSON schema, in the order they will be listed,
    // mapping them to their unique ID in the schema. ID = "<entityName>.<counter from 0>"
    private val usedVersionsToId: mutable.LinkedHashMap[EntityVersion, String] = mutable.LinkedHashMap.empty
    private val entityNameToLastUsedCounter: mutable.Map[String, Int] = mutable.HashMap.empty

    def build: JsObject = {
      detectUsedVersions(rootVersions)
      JsObject(Seq(
        "$id" -> JsString("http://ksi.mff.cuni.cz/schemas/inferred"),
        "$schema" -> JsString("http://json-schema.org/draft-07/schema#"),
        "description" -> JsString(schema.getName),
        "definitions" -> createDefinitions(),
      ) :+ root)
    }

    private def createDefinitions(): JsObject =
      JsObject(usedVersionsToId map {
        case (version, id) => (id, createVersion(id, version))
      })

    private def root: (String, JsValue) = rootVersions match {
      case version :: Nil => createVersionRef(version)
      case _ =>
        "anyOf" -> JsArray(rootVersions.map(createVersionRef)
          .map(Seq(_))
          .map(JsObject))
    }

    private def detectUsedVersions(versions: List[EntityVersion]): Unit = {
      if (versions.isEmpty) return
      detectUsedVersions(versions.flatMap(getDirectDescendants))

      versions.foreach { version =>
        if (usedVersionsToId.contains(version)) return

        val entityName = versionToEntityName(version)
        val counter = entityNameToLastUsedCounter.getOrElse(entityName, -1) + 1
        entityNameToLastUsedCounter(entityName) = counter
        usedVersionsToId(version) = s"$entityName.$counter"
      }
    }

    private def createVersion(versionId: String, version: EntityVersion): JsObject =
      JsObject(Seq(
        "$id" -> JsString(versionId),
        "type" -> JsString("object"),
        "additionalProperties" -> JsFalse,
        "required" -> createRequired(version),
        "properties" -> createProperties(version),
      ))

    private def createRequired(version: EntityVersion): JsArray =
      JsArray(version.getProperties.asScala
        .filterNot(_.isOptional)
        .map(_.getName)
        .map(JsString)
        .toSeq)

    private def createProperties(version: EntityVersion): JsObject =
      JsObject(version.getProperties.asScala
        .map(property => (property.getName, createType(property.getType)))
        .toSeq)

    private def createType(`type`: Type): JsObject = `type` match {
      case _: UnknownType => JsObject.empty
      case primitiveType: PrimitiveType => createPrimitiveType(primitiveType)
      case array: NoSQLSchema.Array => JsObject(Seq(
        "type" -> JsString("array"),
        "items" -> createType(array.getElementType),
      ))
      case aggregate: Aggregate => JsObject(Seq(
        createVersionRef(aggregate.getTarget)
      ))
      case reference: EntityReference => JsObject(Seq(
        "description" -> JsString(s"A reference to the '${reference.getTarget.getName}' entity"),
      )) ++ createPrimitiveType(reference.getOriginalType)
      case unionType: UnionType => JsObject(Seq(
        "anyOf" -> JsArray(unionType.getTypes.asScala
          .map(createType)
          .toSeq)
      ))
      case _ => throw new RuntimeException("Not all cases covered")
    }

    private def createVersionRef(version: EntityVersion): (String, JsString) =
      "$ref" -> JsString(usedVersionsToId(version))

    private def createPrimitiveType(primitiveType: PrimitiveType): JsObject =
      JsObject(Seq(
        "type" -> JsString(primitiveType match {
          case _: NoSQLSchema.Boolean => "boolean"
          case _: NoSQLSchema.Number => "number"
          case _: NoSQLSchema.String => "string"
        })
      ))
  }

}
