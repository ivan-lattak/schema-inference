package cz.cuni.mff.ksi.nosql.s13e.impl.testUtil

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema._

import scala.collection.immutable.{TreeMap, TreeSet}

trait InternalDefaults {

  val schema = new InternalNoSqlSchema(TreeSet.empty(Ordering.by(_.name)))
  val namedSchema: NamedInternalNoSqlSchema = schema.named("")
  val emptySchema: EmptyInternalNoSqlSchema.type = EmptyInternalNoSqlSchema
  val schemas = List(schema, namedSchema, emptySchema)

  val entity: InternalEntity = InternalEntity("", root = false)
  val entities = List(entity)

  val propertiesWithX: TreeMap[String, InternalProperty] = TreeMap(
    "x" -> InternalProperty("x", InternalNumber),
  )
  val propertiesWithXAndY: TreeMap[String, InternalProperty] = TreeMap(
    "x" -> InternalProperty("x", InternalNumber),
    "y" -> InternalProperty("y", InternalNumber),
  )

  val version: InternalEntityVersion = InternalEntityVersion(TreeMap.empty)
  val versionWithX: InternalEntityVersion = InternalEntityVersion(propertiesWithX)
  val versionWithXAndY: InternalEntityVersion = InternalEntityVersion(propertiesWithXAndY)
  val versions = List(version, versionWithX, versionWithXAndY)

  val unknown: InternalUnknownType.type = InternalUnknownType
  val boolean: InternalBoolean.type = InternalBoolean
  val number: InternalNumber.type = InternalNumber
  val string: InternalString.type = InternalString
  val array: InternalArray = InternalArray(unknown)
  val aggregate: InternalAggregate = InternalAggregate(InternalEntityVersion(TreeMap.empty))
  val reference: InternalEntityReference = InternalEntityReference("")
  val union: InternalUnionType = InternalUnionType(List(boolean, number))
  val types: List[InternalType] = List(unknown, boolean, number, string, array, aggregate, reference, union)

  val schemaObjects: List[Serializable] = schemas ++ entities ++ versions ++ types

}
