package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import scala.collection.immutable.{SortedSet, TreeSet}

sealed class InternalNoSqlSchema(val entities: SortedSet[InternalEntity])

sealed case class NamedInternalNoSqlSchema(name: String, override val entities: SortedSet[InternalEntity])
  extends InternalNoSqlSchema(entities)

case object EmptyInternalNoSqlSchema extends InternalNoSqlSchema(TreeSet.empty(Ordering.by(_.name)))
