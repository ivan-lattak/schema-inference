package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

sealed case class InternalEntity(name: String, root: Boolean, versions: Seq[InternalEntityVersion])
