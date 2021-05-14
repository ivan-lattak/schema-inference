package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

sealed case class InternalNoSqlSchema(name: String, entities: Seq[InternalEntity])

sealed case class EmptyInternalNoSqlSchema(override val name: String) extends InternalNoSqlSchema(name, Nil)
