package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalNoSqlSchema

private sealed case class Injector(schemaName: String) extends (TypedDocumentImpl => InternalNoSqlSchema) {

  override def apply(document: TypedDocumentImpl): InternalNoSqlSchema = ???

}
