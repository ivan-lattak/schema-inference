package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

sealed case class InternalEntityVersion(count: Long, properties: Map[String, InternalProperty])
