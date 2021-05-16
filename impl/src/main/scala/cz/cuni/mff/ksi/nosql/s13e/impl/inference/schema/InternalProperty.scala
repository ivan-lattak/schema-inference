package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

sealed case class InternalProperty(name: String, `type`: InternalType, optional: Boolean = false)
