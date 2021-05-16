package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

/**
 * @param entities ordered by natural ordering
 */
sealed case class InternalNoSqlSchema(nameOpt: Option[String], entities: List[InternalEntity])

sealed case class NamedInternalNoSqlSchema(name: String, override val entities: List[InternalEntity])
  extends InternalNoSqlSchema(Some(name), entities)

case object EmptyInternalNoSqlSchema extends InternalNoSqlSchema(None, Nil)
