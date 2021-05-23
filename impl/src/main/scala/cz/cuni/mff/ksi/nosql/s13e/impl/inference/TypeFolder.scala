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
      }

      InternalUnionType(mergeSortedTypes(mkList(left), mkList(right)))
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
            case rh: InternalAggregate => rh.unregister()
          }
          mergeSortedTypes(lt, rt, lh :: acc)
      }
    }

  }

}
