package cz.cuni.mff.ksi.nosql.s13e.impl.inference.util

case object OptionOrdering {

  def compareOptions[T](x: Option[T], y: Option[T])(implicit ord: Ordering[T]): Int = (x, y) match {
    case (None, None) => 0
    case (None, Some(_)) => -1
    case (Some(_), None) => 1
    case (Some(left), Some(right)) => ord.compare(left, right)
  }

}
