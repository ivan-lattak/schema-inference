package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalEntity.{MutableVersionMap, VersionMap}
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalEntityVersion.PropertiesOrdering

import scala.collection.immutable.{SortedMap, TreeMap}
import scala.collection.{Map, mutable}

sealed case class InternalEntity(name: String,
                                 private val _versions: MutableVersionMap = mutable.TreeMap.empty(PropertiesOrdering)) {

  def versions: VersionMap = TreeMap(_versions.toSeq: _*)(_versions.ordering)

  def getOrAddIdenticalVersion(properties: Map[String, InternalProperty], root: Boolean = false): InternalEntityVersion = {
    val version = InternalEntityVersion(TreeMap(properties.toSeq: _*), root)
    _versions.getOrElseUpdate(version, version)
  }

}

case object InternalEntity {

  type VersionMap = SortedMap[InternalEntityVersion, InternalEntityVersion]
  type MutableVersionMap = mutable.SortedMap[InternalEntityVersion, InternalEntityVersion]

}
