package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.{Aggregate, Entity, EntityReference, EntityVersion, NoSQLSchemaFactory, PrimitiveType, Property, SingleType, Type, UnionType, UnknownType}
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalEntityVersion.PropertiesOrdering
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema._
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.IdentityWrapper

import scala.collection.JavaConverters.collectionAsScalaIterableConverter
import scala.collection.immutable.{TreeMap, TreeSet}
import scala.collection.mutable

private object Converter {

  def internalToModel(internalSchema: NamedInternalNoSqlSchema): NoSQLSchema.NoSQLSchema = new InternalToModel(internalSchema).convert()

  private class InternalToModel(internalSchema: NamedInternalNoSqlSchema) {

    private type IWVersion = IdentityWrapper[InternalEntityVersion]

    private val factory = NoSQLSchemaFactory.eINSTANCE

    private val entities: mutable.LinkedHashMap[String, Entity] = mutable.LinkedHashMap.empty
    private val versions: mutable.Map[IWVersion, EntityVersion] = mutable.HashMap.empty

    def convert(): NoSQLSchema.NoSQLSchema = {
      val schema = factory.createNoSQLSchema()
      schema.setName(internalSchema.name)

      processEntitiesAndVersions(schema)
      processProperties()

      schema
    }

    private def processEntitiesAndVersions(schema: NoSQLSchema.NoSQLSchema): Unit = {
      def processVersions(internalEntity: InternalEntity, entity: Entity): Unit =
        internalEntity.versions.keys zip Stream.from(0) foreach {
          case (internalVersion, id) =>
            val version = factory.createEntityVersion()
            version.setAdditionalCount(internalVersion.additionalCount)
            entity.getVersions.add(version)
            versions(identity(internalVersion)) = version
        }

      for (internalEntity <- internalSchema.entities) {
        val entity = factory.createEntity()
        entity.setName(internalEntity.name)
        entity.setRoot(internalEntity.root)
        schema.getEntities.add(entity)
        entities(entity.getName) = entity

        processVersions(internalEntity, entity)
      }
    }

    private def processProperties(): Unit =
      versions.foreach {
        case (IdentityWrapper(internalVersion), version) =>
          for (internalProperty <- internalVersion.properties.values) {
            val property = factory.createProperty()
            property.setName(internalProperty.name)
            property.setOptional(internalProperty.optional)

            val `type` = tryDetectEntity(internalProperty)
              .getOrElse(convertType(internalProperty.`type`))
            property.setType(`type`)

            version.getProperties.add(property)
          }
      }

    private def tryDetectEntity(internalProperty: InternalProperty): Option[Type] = {
      import cz.cuni.mff.ksi.nosql.s13e.impl.inference.Converter.InternalToModel.EntityReferenceMatcher

      val name = internalProperty.name
      internalProperty.`type` match {
        case primitiveType: InternalPrimitiveType => name.findEntitySingular(entities).map(createReference(_, Some(primitiveType)))
        case InternalArray(elementType: InternalPrimitiveType) => name.findEntityPlural(entities).map(entity => {
          val array = factory.createArray()
          array.setElementType(createReference(entity, Some(elementType)))
          array
        })
        case _ => None
      }
    }

    private def convertType(`type`: InternalType): Type = `type` match {
      case InternalUnknownType => factory.createUnknownType()
      case singleType: InternalSingleType => convertSingleType(singleType)
      case InternalUnionType(types) =>
        val union = factory.createUnionType()
        types.map(convertSingleType).foreach(union.getTypes.add)
        union
    }

    private def convertSingleType(`type`: InternalSingleType): SingleType = `type` match {
      case primitiveType: InternalPrimitiveType => convertPrimitiveType(primitiveType)
      case InternalArray(elementType) =>
        val array = factory.createArray()
        array.setElementType(convertType(elementType))
        array
      case InternalAggregate(target) =>
        val aggregate = factory.createAggregate()
        aggregate.setTarget(versions(identity(target)))
        aggregate
      case InternalEntityReference(targetEntityName, originalType) => createReference(entities(targetEntityName), originalType)
    }

    private def convertPrimitiveType(`type`: InternalPrimitiveType): PrimitiveType = `type` match {
      case InternalBoolean => factory.createBoolean()
      case InternalNumber => factory.createNumber()
      case InternalString => factory.createString()
    }

    private def createReference(entity: Entity, primitiveType: Option[InternalPrimitiveType] = None): EntityReference = {
      val reference = factory.createEntityReference()
      reference.setTarget(entity)
      primitiveType.map(convertPrimitiveType).foreach(reference.setOriginalType)
      reference
    }

  }

  object InternalToModel {

    private object EntityReferenceMatcher {

      private val singularPattern = "(.+)(_id|Id)".r
      private val pluralPattern = "(.+)(_ids|Ids)".r

    }

    private implicit class EntityReferenceMatcher(val string: String) extends AnyVal {

      import EntityReferenceMatcher._

      def findEntitySingular(entities: collection.Map[String, Entity]): Option[Entity] = string match {
        case singularPattern(entityName, _) => entities.get(entityName)
        case _ => None
      }

      def findEntityPlural(entities: collection.Map[String, Entity]): Option[Entity] = string match {
        case pluralPattern(entityName, _) => entities.get(entityName)
        case _ => None
      }

    }

  }

  def modelToInternal(schema: NoSQLSchema.NoSQLSchema): NamedInternalNoSqlSchema = new ModelToInternal(schema).convert()

  private class ModelToInternal(schema: NoSQLSchema.NoSQLSchema) {

    private type IWVersion = IdentityWrapper[EntityVersion]

    private val versions: mutable.Map[IWVersion, InternalEntityVersion] = mutable.HashMap.empty

    def convert(): NamedInternalNoSqlSchema = {
      val internalEntities = schema.getEntities.asScala.map(convertEntity).toSeq
      val entityMap = TreeSet(internalEntities: _*)(Ordering.by(_.name))
      NamedInternalNoSqlSchema(schema.getName, entityMap)
    }

    private def convertEntity(entity: Entity): InternalEntity = {
      val internalVersions = entity.getVersions.asScala.map(convertVersion).map(v => (v, v)).toSeq
      val versionMap = mutable.TreeMap(internalVersions: _*)(PropertiesOrdering)
      InternalEntity(entity.getName, entity.isRoot, versionMap)
    }

    private def convertVersion(version: EntityVersion): InternalEntityVersion =
      versions.getOrElseUpdate(identity(version), {
        val internalProperties = version.getProperties.asScala.map(convertProperty).map(p => (p.name, p)).toSeq
        InternalEntityVersion(TreeMap(internalProperties: _*), _additionalCount = version.getAdditionalCount)
      })

    private def convertProperty(property: Property): InternalProperty =
      InternalProperty(property.getName, convertType(property.getType), property.isOptional)

    private def convertType(`type`: Type): InternalType = `type` match {
      case _: UnknownType => InternalUnknownType
      case singleType: SingleType => convertSingleType(singleType)
      case unionType: UnionType => InternalUnionType(unionType.getTypes.asScala.map(convertSingleType).toList)
    }

    private def convertSingleType(singleType: SingleType): InternalSingleType = singleType match {
      case primitiveType: PrimitiveType => convertPrimitiveType(primitiveType)
      case aggregate: Aggregate => InternalAggregate(convertVersion(aggregate.getTarget))
      case array: NoSQLSchema.Array => InternalArray(convertType(array.getElementType))
      case reference: EntityReference => convertEntityReference(reference)
    }

    private def convertPrimitiveType(primitiveType: PrimitiveType): InternalPrimitiveType = primitiveType match {
      case _: NoSQLSchema.Boolean => InternalBoolean
      case _: NoSQLSchema.Number => InternalNumber
      case _: NoSQLSchema.String => InternalString
    }

    private def convertEntityReference(reference: EntityReference): InternalEntityReference =
      InternalEntityReference(reference.getTarget.getName, Option(reference.getOriginalType).map(convertPrimitiveType))

  }

  private def identity[T <: AnyRef](t: T): IdentityWrapper[T] = IdentityWrapper(t)

}
