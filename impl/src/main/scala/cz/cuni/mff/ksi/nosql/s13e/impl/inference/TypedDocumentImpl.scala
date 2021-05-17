package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.TypedDocument
import play.api.libs.json._

private sealed case class TypedDocumentImpl(typeName: String, document: JsObject) extends TypedDocument {

  override def getTypeName: String = typeName

  override def getDocument: JsObject = document

  private[inference] def getRawSchema: TypedDocumentImpl = TypedDocumentImpl(typeName, RawSchema(document))

}

private case object TypedDocumentImpl {

  def apply(typedDoc: TypedDocument): TypedDocumentImpl = typedDoc match {
    case typedDoc: TypedDocumentImpl => typedDoc
    case _ => TypedDocumentImpl(typedDoc.getTypeName, typedDoc.getDocument)
  }

}
