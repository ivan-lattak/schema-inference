package cz.cuni.mff.ksi.nosql.s13e.impl

import cz.cuni.mff.ksi.nosql.s13e.api.TypedDocument
import play.api.libs.json._

private sealed case class TypedDocumentImpl(typeName: String, document: JsValue) extends TypedDocument {

  override def getTypeName: String = typeName

  override def getDocument: JsValue = document

  private[impl] def getRawSchema: TypedDocument = TypedDocumentImpl(typeName, TypedDocumentImpl.getRawSchema(document))

}

private object TypedDocumentImpl {

  def apply(typedDoc: TypedDocument): TypedDocumentImpl = typedDoc match {
    case typedDoc: TypedDocumentImpl => typedDoc
    case _ => TypedDocumentImpl(typedDoc.getTypeName, typedDoc.getDocument)
  }

  def getRawSchema(value: JsValue): JsValue = value match {
    case JsNull => JsString("null")
    case _: JsBoolean => JsString("boolean")
    case JsNumber(_) => JsString("number")
    case JsString(_) => JsString("string")
    case JsArray(value) => JsArray(value.map(getRawSchema))
    case JsObject(underlying) => JsObject(underlying.mapValues(getRawSchema))
  }

}
