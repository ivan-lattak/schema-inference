package cz.cuni.mff.ksi.nosql.s13e.impl.inference.util

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.{RawSchema, TypedDocumentImpl}
import play.api.libs.json.{JsObject, Json}

trait JsonDocs {

  def doc(json: String): JsObject = Json.parse(json).asInstanceOf[JsObject]

  def schema(doc: JsObject): JsObject = RawSchema(doc)

  val allTypes: JsObject = doc(
    """
      |{
      |  "null": null,
      |  "boolean": false,
      |  "number": 0,
      |  "string": "",
      |  "array": [ null, false, 0, "", [], {} ],
      |  "object": {
      |    "x": 0,
      |    "y": 0
      |  },
      |  "reference": {
      |    "$ref": "collection",
      |    "$id": 0
      |  },
      |  "notReference": {
      |    "$ref": "collection"
      |  }
      |}
      |""".stripMargin)
  val allTypesSchema: JsObject = schema(allTypes)

  val picasso: JsObject = doc(
    """
      |{
      |  "name": "Pablo Picasso",
      |  "age": 33,
      |  "address": {
      |    "street": "I don't know, honestly",
      |    "country": "Spain"
      |  },
      |  "photos": [
      |    {
      |      "url": "http://www.example.com/picasso1.jpg"
      |    },
      |    {
      |      "url": "http://www.example.com/picasso2.jpg"
      |    }
      |  ]
      |}
      |""".stripMargin)
  private[inference] val userPicasso: TypedDocumentImpl = TypedDocumentImpl("users", schema(picasso))

  // The following two JSON documents form the running example
  val johnDoe: JsObject = doc(
    """
      |{ "_id": 1, "timestamp": "2021-02-06T16:31:32.029Z",
      |  "author": {
      |    "first_name": "John",
      |    "last_name": "Doe",
      |    "phone_number": "518-555-0168",
      |    "location": {
      |      "latitude": "-48.875000",
      |      "longitude": "-123.393333" } },
      |  "ratings": [ 5, 4, 5, 5, 4 ],
      |  "comments": [ "I like this", ":)" ],
      |  "attachments": [
      |    { "url": "/image.png" },
      |    { "url": "/document.pdf" } ],
      |  "body": {
      |    "content": "<p>Article body with HTML tags &amp; entities<p>",
      |    "mime_type": "text/html" },
      |  "published": true }
      |""".stripMargin)
  private[inference] val articleJohnDoe = TypedDocumentImpl("articles", schema(johnDoe))

  val vaclavNovak: JsObject = doc(
    """
      |{ "_id": 2, "body": "Plain text article body",
      |  "timestamp": "2021-02-10T18:02:29.706Z",
      |  "author": {
      |    "first_name": "Václav",
      |    "last_name": "Novák",
      |    "phone_number": 321654987,
      |    "location": {
      |      "address": "Malostranské nám. 25, 118 00 Praha 1" } },
      |  "ratings": [ 3, 1, 2 ],
      |  "comments": "Too plain",
      |  "article_id": 1,
      |  "published": false }
      |""".stripMargin)
  private[inference] val articleVaclavNovak = TypedDocumentImpl("articles", schema(vaclavNovak))

}
