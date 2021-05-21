package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import scala.collection.immutable.{SortedSet, TreeSet}

sealed class InternalNoSqlSchema(val entities: SortedSet[InternalEntity]) extends Serializable with Equals {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[InternalNoSqlSchema]

  override def equals(obj: Any): Boolean = obj match {
    case that: InternalNoSqlSchema => (this eq that) || that.canEqual(this) && entities == that.entities
    case _ => false
  }

}

sealed case class NamedInternalNoSqlSchema(name: String, override val entities: SortedSet[InternalEntity])
  extends InternalNoSqlSchema(entities) {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[NamedInternalNoSqlSchema]

  override def equals(obj: Any): Boolean = obj match {
    case that: NamedInternalNoSqlSchema => (this eq that) || super.equals(that) && name.equals(that.name)
    case _ => false
  }

}

case object EmptyInternalNoSqlSchema extends InternalNoSqlSchema(TreeSet.empty(Ordering.by(_.name)))
