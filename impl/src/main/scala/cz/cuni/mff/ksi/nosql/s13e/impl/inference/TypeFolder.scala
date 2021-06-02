package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema._

import scala.annotation.tailrec

private case object TypeFolder extends ((InternalType, InternalType) => InternalType) {

  override def apply(left: InternalType, right: InternalType): InternalType = (left, right) match {
    case (_, InternalUnknownType) => left
    case (InternalUnknownType, _) => right
    case _ =>
      def mkList(t: InternalType): List[InternalSingleType] = t match {
        case InternalUnionType(types) => types
        case t: InternalSingleType => List(t)
        case InternalUnknownType => throw new IllegalArgumentException("Unexpected unknown type")
      }

      mergeSortedTypes(mkList(left), mkList(right)) match {
        case Nil => throw new RuntimeException("Merged list should not be empty")
        case loneElement :: Nil => loneElement
        case types => InternalUnionType(types)
      }
  }

  /**
   * @param left  sorted
   * @param right sorted
   * @param acc   reverse-sorted accumulator
   * @return merged sorted list
   */
  @tailrec
  private def mergeSortedTypes(left: List[InternalSingleType],
                               right: List[InternalSingleType],
                               acc: List[InternalSingleType] = Nil): List[InternalSingleType] = (left, right) match {
    case (_, Nil) => acc reverse_::: left
    case (Nil, _) => acc reverse_::: right
    case (lh :: lt, rh :: rt) => (lh, rh) match {
      case (InternalArray(leftType), InternalArray(rightType)) =>
        mergeSortedTypes(lt, rt, InternalArray(TypeFolder(leftType, rightType)) :: acc)
      case _ => lh.compare(rh) match {
        case c if c < 0 => mergeSortedTypes(lt, right, lh :: acc)
        case c if c > 0 => mergeSortedTypes(left, rt, rh :: acc)
        case _ =>
          rh match {
            case rh: InternalAggregate => if (lh ne rh) rh.unregister()
            case _ => // do nothing
          }
          mergeSortedTypes(lt, rt, lh :: acc)
      }
    }

  }

}
