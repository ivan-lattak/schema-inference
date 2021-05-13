package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.TypedDocumentImpl.jsObjectToObjectNode
import cz.cuni.mff.ksi.nosql.s13e.impl.{TypedDocument, inference}
import play.api.libs.json._

private sealed case class TypedDocumentImpl(typeName: String, document: JsObject) extends TypedDocument {

  override def getTypeName: String = typeName

  override def getDocument: ObjectNode = jsObjectToObjectNode(document)

  private[inference] def getRawSchema: TypedDocument =
    inference.TypedDocumentImpl(typeName, TypedDocumentImpl.getRawSchema(document).asInstanceOf[JsObject])

}

private object TypedDocumentImpl {

  val objectMapper: ObjectMapper = new ObjectMapper()

  def jsObjectToObjectNode(jsObject: JsObject): ObjectNode =
    objectMapper.readTree(Json.stringify(jsObject)).asInstanceOf[ObjectNode]

  def objectNodeToJsObject(objectNode: ObjectNode): JsObject =
    Json.parse(objectNode.toString).asInstanceOf[JsObject]

  def apply(typedDoc: TypedDocument): TypedDocumentImpl = typedDoc match {
    case typedDoc: TypedDocumentImpl => typedDoc
    case _ => inference.TypedDocumentImpl(typedDoc.getTypeName, objectNodeToJsObject(typedDoc.getDocument))
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
