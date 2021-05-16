package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalEntity.getOrAdd

import scala.collection.Map
import scala.collection.immutable.TreeMap

/**
 * @param _versions ordered by natural ordering
 */
sealed case class InternalEntity(name: String, root: Boolean, private var _versions: List[InternalEntityVersion] = List())
  extends Ordered[InternalEntity] {

  def versions: List[InternalEntityVersion] = _versions

  def getOrAddIdenticalVersion(properties: Map[String, InternalProperty]): InternalEntityVersion = {
    val (version, newVersions) = getOrAdd(InternalEntityVersion(0, TreeMap(properties.toSeq: _*)), versions)
    _versions = newVersions
    version
  }

  override def compare(that: InternalEntity): Int = name.compareTo(that.name)

}

case object InternalEntity {

  private def getOrAdd(version: InternalEntityVersion,
                       versions: List[InternalEntityVersion]): (InternalEntityVersion, List[InternalEntityVersion]) =
    versions match {
      case Nil => (version, List(version))
      case head :: tail =>
        val c = version.compare(head)
        if (c < 0) (version, version :: versions)
        else if (c == 0) (head, versions)
        else {
          val (retVersion, retVersions) = getOrAdd(version, tail)
          (retVersion, head :: retVersions)
        }
    }

}
