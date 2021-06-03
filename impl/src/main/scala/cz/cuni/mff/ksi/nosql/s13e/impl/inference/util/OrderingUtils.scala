package cz.cuni.mff.ksi.nosql.s13e.impl.inference.util

import scala.math.Ordering

object OrderingUtils {

  def nullsFirst[T](implicit ord: Ordering[T]): Ordering[T] = (x: T, y: T) => (x, y) match {
    case (null, null) => 0
    case (null, _) => -1
    case (_, null) => 1
    case _ => ord.compare(x, y)
  }

  implicit class OrderingAndThen[T](val outer: Ordering[T]) extends AnyVal {

    def andThen(ord: Ordering[T]): Ordering[T] = andThenBy(identity)(ord)

    def andThenBy[S](f: T => S)(implicit ord: Ordering[_ >: S]): Ordering[T] = (x: T, y: T) => outer.compare(x, y) match {
      case c if c != 0 => c
      case _ => ord.compare(f(x), f(y))
    }

  }

}
