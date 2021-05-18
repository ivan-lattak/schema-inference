package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import scala.annotation.tailrec
import scala.collection.{SortedMap, mutable}

sealed case class InternalEntityVersion(properties: SortedMap[String, InternalProperty],
                                        private val aggregates: mutable.Buffer[InternalAggregate] = mutable.ArrayBuffer.empty) {

  def count: Int = aggregates.size

  def mergeAggregatesFrom(that: InternalEntityVersion): this.type = {
    that.aggregates.foreach(_.target = this)
    aggregates ++= that.aggregates
    this
  }

  private[schema] def addAggregate(aggregate: InternalAggregate): this.type = {
    aggregates += aggregate
    this
  }

}

case object InternalEntityVersion {

  /**
   * We use an external Ordering[T] here instead of natural order (Ordered[T]), because it is not compliant with ==
   */
  case object PropertiesOrdering extends Ordering[InternalEntityVersion] {

    override def compare(x: InternalEntityVersion, y: InternalEntityVersion): Int = {
      x.properties.size - y.properties.size match {
        case c if c != 0 => c
        case _ => compareProperties(x.properties.toList, y.properties.toList)
      }
    }

    /**
     * Compares the given lists element by element. The arguments are equally long sorted lists.
     *
     * @param left  sorted
     * @param right sorted
     * @return the first non-zero comparison between keys or values
     */
    @tailrec
    private def compareProperties(left: List[(String, InternalProperty)],
                                  right: List[(String, InternalProperty)]): Int = (left, right) match {
      case (Nil, Nil) => 0
      case ((lk, lv) :: lt, (rk, rv) :: rt) => lk.compare(rk) match {
        case c if c != 0 => c
        case _ => lv.compare(rv) match {
          case c if c != 0 => c
          case _ => compareProperties(lt, rt)
        }
      }
      case _ => throw new RuntimeException("The lists are not equally long")
    }

  }

}
