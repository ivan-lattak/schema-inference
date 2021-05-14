package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema

object SchemaConverter {

  def modelToInternal(schema: NoSQLSchema): InternalNoSqlSchema = ???

  def internalToModel(schema: InternalNoSqlSchema): NoSQLSchema = ???

}
