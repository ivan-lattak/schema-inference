package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalEntityVersion.compareProperties

import scala.annotation.tailrec
import scala.collection.SortedMap

sealed case class InternalEntityVersion(private var _count: Long, properties: SortedMap[String, InternalProperty])
  extends Ordered[InternalEntityVersion] {

  def count: Long = _count

  def increment: this.type = {
    _count += 1
    this
  }

  override def compare(that: InternalEntityVersion): Int = {
    val sizeDiff = properties.size - that.properties.size
    if (sizeDiff != 0) sizeDiff else compareProperties(properties.toList, that.properties.toList)
  }

}

case object InternalEntityVersion {

  @tailrec
  def compareProperties(left: List[(String, InternalProperty)],
                        right: List[(String, InternalProperty)]): Int = (left, right) match {
    case (Nil, Nil) => 0
    case ((lk, lv) :: lt, (rk, rv) :: rt) =>
      val keyDiff = lk.compare(rk)
      if (keyDiff != 0) keyDiff
      val valDiff = lv.compare(rv)
      if (valDiff != 0) valDiff else compareProperties(lt, rt)
  }

}
