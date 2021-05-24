package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.JsonDocs

class RawSchemaTest extends UnitTest with JsonDocs {

  private val expectedAllTypesSchema = doc(
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
      allTypesSchema shouldEqual expectedAllTypesSchema
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
