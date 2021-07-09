package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import scala.annotation.tailrec
import scala.collection.{SortedMap, mutable}

sealed case class InternalEntityVersion(properties: SortedMap[String, InternalProperty],
                                        private var _root: Boolean,
                                        private[schema] val liveAggregates: mutable.Buffer[InternalAggregate] = mutable.ListBuffer.empty,
                                        private var _additionalCount: Int = 0) {

  def root: Boolean = _root

  def additionalCount: Int = _additionalCount

  def count: Int = liveAggregates.size + additionalCount

  def mergeFrom(that: InternalEntityVersion): this.type = {
    _root ||= that.root
    that.liveAggregates.foreach(_.target = this)
    liveAggregates ++= that.liveAggregates
    that.liveAggregates.clear()
    _additionalCount += that._additionalCount
    that._additionalCount = 0
    this
  }

  private[schema] def register(aggregate: InternalAggregate): this.type = {
    liveAggregates += aggregate
    this
  }

  // this aggregate is being merged with another or is root, we forget it but increment the additional counter
  private[schema] def unregister(aggregate: InternalAggregate): this.type = {
    liveAggregates.remove(liveAggregates.indexWhere(_ eq aggregate))
    _additionalCount += 1
    this
  }

  override def toString: String = s"${getClass.getSimpleName}($properties, (${liveAggregates.size} + $additionalCount) aggregates)"

  override def canEqual(that: Any): Boolean = that.isInstanceOf[InternalEntityVersion]

  override def equals(obj: Any): Boolean = obj match {
    case that: InternalEntityVersion => (this eq that) || that.canEqual(this) && properties == that.properties
    case _ => false
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
      case _ => throw new IllegalArgumentException("The lists are not equally long")
    }

  }

}
