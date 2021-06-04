package cz.cuni.mff.ksi.nosql.s13e.impl.testUtil

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.{Aggregate, Entity, EntityReference, EntityVersion, NoSQLSchemaFactory, Property, SingleType, Type, UnionType, UnknownType}

import scala.Function.tupled
import scala.collection.JavaConverters.seqAsJavaListConverter

trait ModelDefaults {

  val factory: NoSQLSchemaFactory = NoSQLSchemaFactory.eINSTANCE

  val schema: NoSQLSchema.NoSQLSchema = factory.createNoSQLSchema()

  val entity: Entity = factory.createEntity()

  val version: EntityVersion = factory.createEntityVersion()
  val versionWithX: EntityVersion = versionWith(
    "x" -> string,
  )
  val versionWithXAndY: EntityVersion = versionWith(
    "x" -> number,
    "y" -> number,
  )

  def unknown: UnknownType = factory.createUnknownType()

  def boolean: NoSQLSchema.Boolean = factory.createBoolean()

  def number: NoSQLSchema.Number = factory.createNumber()

  def string: NoSQLSchema.String = factory.createString()

  val array: NoSQLSchema.Array = arrayOf(unknown)
  val aggregate: Aggregate = aggregateOf(factory.createEntityVersion())
  val reference: EntityReference = {
    val r = factory.createEntityReference()
    r.setTarget(factory.createEntity())
    r
  }
  val union: UnionType = unionOf(boolean, number)
  val types = List(unknown, boolean, number, string, array, aggregate, reference, union)

  def versionWith(properties: (String, Type)*): EntityVersion = {
    val v = factory.createEntityVersion()
    v.getProperties.addAll(properties.map(tupled(property)).asJava)
    v
  }

  private def property(name: String, `type`: Type): Property = {
    val p = factory.createProperty()
    p.setName(name)
    p.setType(`type`)
    p
  }

  def arrayOf(elementType: Type): NoSQLSchema.Array = {
    val a = factory.createArray()
    a.setElementType(elementType)
    a
  }

  def aggregateOf(version: EntityVersion): Aggregate = {
    val a = factory.createAggregate()
    a.setTarget(version)
    a
  }

  def unionOf(types: SingleType*): UnionType = {
    val u = factory.createUnionType()
    types.foreach(u.getTypes.add)
    u
  }

}
