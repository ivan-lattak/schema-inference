package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalEntityVersion.PropertiesOrdering

import scala.collection.immutable.TreeMap
import scala.collection.{Map, mutable}

sealed case class InternalEntity(name: String, root: Boolean,
                                 private val _versions: mutable.SortedMap[InternalEntityVersion, InternalEntityVersion] = mutable.TreeMap()(PropertiesOrdering)) {

  def getOrAddIdenticalVersion(properties: Map[String, InternalProperty]): InternalEntityVersion = {
    val version = InternalEntityVersion(0, TreeMap(properties.toSeq: _*))
    _versions.getOrElseUpdate(version, version)
  }

}
