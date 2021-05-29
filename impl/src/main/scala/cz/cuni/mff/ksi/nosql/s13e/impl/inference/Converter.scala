package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.{Entity, EntityReference, EntityVersion, NoSQLSchema, NoSQLSchemaFactory, PrimitiveType, SingleType, Type}
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema._
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.IdentityWrapper

import scala.collection.mutable

private object Converter {

  def modelToInternal(schema: NoSQLSchema): NamedInternalNoSqlSchema = ???

  def internalToModel(internalSchema: NamedInternalNoSqlSchema): NoSQLSchema = new InternalToModel(internalSchema).convert()

  private class InternalToModel(internalSchema: NamedInternalNoSqlSchema) {

    private type IWVersion = IdentityWrapper[InternalEntityVersion]

    private val factory = NoSQLSchemaFactory.eINSTANCE

    private val entities: mutable.LinkedHashMap[String, Entity] = mutable.LinkedHashMap.empty
    private val versions: mutable.Map[IWVersion, EntityVersion] = mutable.HashMap.empty

    private def identity[T <: AnyRef](t: T): IdentityWrapper[T] = IdentityWrapper(t)

    def convert(): NoSQLSchema = {
      val schema = factory.createNoSQLSchema()
      schema.setName(internalSchema.name)

      processEntitiesAndVersions(schema)
      processProperties()

      schema
    }

    private def processEntitiesAndVersions(schema: NoSQLSchema): Unit = {
      def processVersions(internalEntity: InternalEntity, entity: Entity): Unit =
        internalEntity.versions.keys zip Stream.from(0) foreach {
          case (internalVersion, id) =>
            val version = factory.createEntityVersion()
            version.setId(id)
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

}
