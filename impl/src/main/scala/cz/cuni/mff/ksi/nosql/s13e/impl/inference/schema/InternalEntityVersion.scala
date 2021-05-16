package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import scala.annotation.tailrec
import scala.collection.SortedMap

sealed case class InternalEntityVersion(private var _count: Long, properties: SortedMap[String, InternalProperty]) {

  def count: Long = _count

  def increment: this.type = {
    _count += 1
    this
  }

  def addCount(that: InternalEntityVersion): this.type = {
    _count += that._count
    this
  }

}

case object InternalEntityVersion {

  /**
   * We use an external Ordering[T] here instead of natural order (Ordered[T]), because it is not compliant with ==
   */
  case object PropertiesOrdering extends Ordering[InternalEntityVersion] {

    override def compare(x: InternalEntityVersion, y: InternalEntityVersion): Int = {
      val sizeDiff = x.properties.size - y.properties.size
      if (sizeDiff != 0) sizeDiff else compareProperties(x.properties.toList, y.properties.toList)
    }

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
    }

  }

}
