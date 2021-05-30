package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import play.api.libs.json._

private case object RawSchema {

  val nullType = "null"
  val booleanType = "boolean"
  val numberType = "number"
  val stringType = "string"

  case object ReferenceType {

    private val pattern = "reference\\((.*)\\)".r

    def apply(collectionName: String): String = s"reference($collectionName)"

    def unapply(string: String): Option[String] = string match {
      case pattern(collectionName) => Some(collectionName)
      case _ => None
    }

  }

  def apply(document: JsObject): JsObject = getRawSchema(document).asInstanceOf[JsObject]

  private def getRawSchema(value: JsValue): JsValue = value match {
    case JsNull => JsString(nullType)
    case _: JsBoolean => JsString(booleanType)
    case JsNumber(_) => JsString(numberType)
    case JsString(_) => JsString(stringType)
    case DbRef(collectionName) => JsString(ReferenceType(collectionName))
    case JsArray(value) => JsArray(value.map(getRawSchema))
    case JsObject(underlying) => JsObject(underlying.mapValues(getRawSchema).map(identity)) // we have to map(identity) because mapValues result is not serializable
  }

}
