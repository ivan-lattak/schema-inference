package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import scala.collection.immutable.SortedSet

sealed case class InternalNoSqlSchema(nameOpt: Option[String], entities: SortedSet[InternalEntity])

sealed case class NamedInternalNoSqlSchema(name: String, override val entities: SortedSet[InternalEntity])
  extends InternalNoSqlSchema(Some(name), entities)

case object EmptyInternalNoSqlSchema extends InternalNoSqlSchema(None, SortedSet()(Ordering.by(_.name)))
