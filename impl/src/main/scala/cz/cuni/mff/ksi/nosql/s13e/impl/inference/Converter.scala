package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.NamedInternalNoSqlSchema

private case object Converter {

  def modelToInternal(schema: NoSQLSchema): NamedInternalNoSqlSchema = ???

  def internalToModel(schema: NamedInternalNoSqlSchema): NoSQLSchema = ???

}
