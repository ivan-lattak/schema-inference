package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalEntityVersion.PropertiesOrdering
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalType.NaturalOrdering

import scala.annotation.tailrec

sealed abstract class InternalType extends Ordered[InternalType] {

  override def compare(that: InternalType): Int = NaturalOrdering.compare(this, that)

}

case object InternalType {

  implicit def ordering[T <: InternalType]: Ordering[T] = NaturalOrdering.compare

  private case object NaturalOrdering extends Ordering[InternalType] {

    override def compare(x: InternalType, y: InternalType): Int = SubtypeOrdering.compare(x, y) match {
      case c if c != 0 => c
      case _ => (x, y) match {
        case (InternalArray(left), InternalArray(right)) => left.compare(right)
        case (InternalAggregate(left), InternalAggregate(right)) => PropertiesOrdering.compare(left, right)
        case (InternalEntityReference(leftTarget, leftOrig), InternalEntityReference(rightTarget, rightOrig)) =>
          leftTarget.compare(rightTarget) match {
            case c if c != 0 => c
            case _ => implicitly[Ordering[Option[InternalPrimitiveType]]].compare(leftOrig, rightOrig)
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

  private case object SubtypeOrdering extends Ordering[InternalType] {

    override def compare(x: InternalType, y: InternalType): Int = order(x) - order(y)

    private def order(t: InternalType): Int = t match {
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

  }

}

/**
 * @param types sorted
 */
sealed case class InternalUnionType(types: List[InternalSingleType]) extends InternalType

sealed abstract class InternalSingleType extends InternalType

sealed case class InternalEntityReference(targetEntityName: String, originalType: Option[InternalPrimitiveType] = None)
  extends InternalSingleType

sealed abstract class InternalPrimitiveType extends InternalSingleType

case object InternalBoolean extends InternalPrimitiveType

case object InternalNumber extends InternalPrimitiveType

case object InternalString extends InternalPrimitiveType

sealed abstract class InternalComplexType extends InternalSingleType

/**
 * @param target can change only to a version equivalent according to PropertiesOrdering
 */
sealed case class InternalAggregate(private[schema] var target: InternalEntityVersion) extends InternalComplexType

case object InternalAggregate {

  def apply(target: InternalEntityVersion): InternalAggregate = {
    val aggregate = new InternalAggregate(target)
    target.addAggregate(aggregate)
    aggregate
  }

}

sealed case class InternalArray(elementType: InternalType) extends InternalComplexType

case object InternalUnknownType extends InternalSingleType
