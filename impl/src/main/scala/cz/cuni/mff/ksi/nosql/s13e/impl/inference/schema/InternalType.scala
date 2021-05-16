package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalEntityVersion.PropertiesOrdering
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.OptionOrdering

import scala.annotation.tailrec

sealed abstract case class InternalType() extends Ordered[InternalType] {

  override def compare(that: InternalType): Int = InternalType.compare(this, that)

}

case object InternalType {

  private def subtypeOrder(t: InternalType): Int = t match {
    case InternalUnknownType => 0
    case InternalBoolean => 1
    case InternalNumber => 2
    case InternalString => 3
    case InternalArray(_) => 4
    case InternalAggregate(_) => 5
    case InternalEntityReference(_, _) => 6
    case InternalUnionType(_) => 7
    case _ => throw new RuntimeException("Not all cases covered")
  }

  private def compare(x: InternalType, y: InternalType): Int = subtypeOrder(x) - subtypeOrder(y) match {
    case c if c != 0 => c
    case _ => (x, y) match {
      case (InternalArray(left), InternalArray(right)) => left.compare(right)
      case (InternalAggregate(left), InternalAggregate(right)) => PropertiesOrdering.compare(left, right)
      case (InternalEntityReference(leftTarget, leftOrig), InternalEntityReference(rightTarget, rightOrig)) =>
        leftTarget.compare(rightTarget) match {
          case c if c != 0 => c
          case _ => OptionOrdering.compareOptions[InternalType](leftOrig, rightOrig)
        }
      case (InternalUnionType(left), InternalUnionType(right)) => compareLists(left, right)
      case _ => 0 // other subtypes do not have parameters
    }
  }

  @tailrec
  private def compareLists(left: List[InternalSingleType], right: List[InternalSingleType]): Int = (left, right) match {
    case (Nil, Nil) => 0
    case (Nil, _ :: _) => -1
    case (_ :: _, Nil) => 1
    case (lh :: lt, rh :: rt) => lh.compare(rh) match {
      case c if c != 0 => c
      case _ => compareLists(lt, rt)
    }
  }

}

sealed case class InternalUnionType(types: List[InternalSingleType]) extends InternalType

sealed abstract case class InternalSingleType() extends InternalType

sealed case class InternalEntityReference(targetEntityName: String, originalType: Option[InternalPrimitiveType] = None)
  extends InternalSingleType

sealed abstract case class InternalPrimitiveType() extends InternalSingleType

case object InternalBoolean extends InternalPrimitiveType

case object InternalNumber extends InternalPrimitiveType

case object InternalString extends InternalPrimitiveType

sealed abstract case class InternalComplexType() extends InternalSingleType

sealed case class InternalAggregate(target: InternalEntityVersion) extends InternalComplexType

sealed case class InternalArray(elementType: InternalType) extends InternalComplexType

case object InternalUnknownType extends InternalSingleType
