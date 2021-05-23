package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import play.api.libs.json.{JsObject, Json}

class RawSchemaTest extends UnitTest {

  private val json = Json.parse(
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
      |""".stripMargin).asInstanceOf[JsObject]
  private val schema = Json.parse(
    s"""
       |{
       |  "null": "${RawSchema.nullType}",
       |  "boolean": "${RawSchema.booleanType}",
       |  "number": "${RawSchema.numberType}",
       |  "string": "${RawSchema.stringType}",
       |  "array": [ "${RawSchema.nullType}", "${RawSchema.booleanType}", "${RawSchema.numberType}", "${RawSchema.stringType}", [], {} ],
       |  "object": {
       |    "x": "${RawSchema.numberType}",
       |    "y": "${RawSchema.numberType}"
       |  },
       |  "reference": "${RawSchema.ReferenceType("collection")}",
       |  "notReference": {
       |    "$$ref": "${RawSchema.stringType}"
       |  }
       |}
       |""".stripMargin)

  describe("RawSchema") {

    it("should convert correctly") {
      RawSchema(json) shouldEqual schema
    }

  }

  describe("ReferenceType") {

    it("should correctly convert to String") {
      RawSchema.ReferenceType("collection") shouldEqual "reference(collection)"
    }

    it("should correctly extract from correct Strings") {
      "reference(collection)" match {
        case RawSchema.ReferenceType("collection") =>
        case _ => fail("string was not correctly extracted")
      }
    }

  }

}
