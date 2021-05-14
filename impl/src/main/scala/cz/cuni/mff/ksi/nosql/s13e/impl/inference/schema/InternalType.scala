package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

sealed abstract case class InternalType()

sealed case class InternalUnionType(types: Seq[InternalSingleType]) extends InternalType

sealed abstract case class InternalSingleType() extends InternalType

sealed case class InternalEntityReference(target: InternalEntity, originalType: Option[InternalPrimitiveType])
  extends InternalSingleType

sealed abstract case class InternalPrimitiveType() extends InternalSingleType

case object InternalBoolean extends InternalPrimitiveType

case object InternalNumber extends InternalPrimitiveType

case object InternalString extends InternalPrimitiveType

sealed abstract case class InternalComplexType() extends InternalSingleType

sealed case class InternalAggregate(target: InternalEntityVersion) extends InternalComplexType

sealed case class InternalArray(elementType: InternalType) extends InternalComplexType

case object InternalUnknownType extends InternalSingleType
