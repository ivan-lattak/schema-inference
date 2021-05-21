package cz.cuni.mff.ksi.nosql.s13e.impl.inference.util

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema._

import scala.collection.immutable.{TreeMap, TreeSet}

trait Defaults {

  val schema = new InternalNoSqlSchema(TreeSet.empty(Ordering.by(_.name)))
  val namedSchema: NamedInternalNoSqlSchema = NamedInternalNoSqlSchema("", TreeSet.empty(Ordering.by(_.name)))
  val emptySchema: EmptyInternalNoSqlSchema.type = EmptyInternalNoSqlSchema

  val entity: InternalEntity = InternalEntity("", root = false)

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

  val unknown: InternalUnknownType.type = InternalUnknownType
  val boolean: InternalBoolean.type = InternalBoolean
  val number: InternalNumber.type = InternalNumber
  val string: InternalString.type = InternalString
  val array: InternalArray = InternalArray(unknown)
  val aggregate: InternalAggregate = InternalAggregate(InternalEntityVersion(TreeMap.empty))
  val reference: InternalEntityReference = InternalEntityReference("")
  val union: InternalUnionType = InternalUnionType(Nil)

  val types: List[InternalType] = List(unknown, boolean, number, string, array, aggregate, reference, union)

}
