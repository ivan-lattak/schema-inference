package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalNoSqlSchema

private case object Combiner extends ((InternalNoSqlSchema, InternalNoSqlSchema) => InternalNoSqlSchema) {

  override def apply(left: InternalNoSqlSchema, right: InternalNoSqlSchema): InternalNoSqlSchema = ???

}
