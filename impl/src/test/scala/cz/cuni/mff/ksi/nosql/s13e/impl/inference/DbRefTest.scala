package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import org.scalatest.matchers.{BePropertyMatchResult, BePropertyMatcher}
import play.api.libs.json._

class DbRefTest extends UnitTest {

  private val dbRef: BePropertyMatcher[JsValue] =
    (jsValue: JsValue) => BePropertyMatchResult(DbRef.unapply(jsValue).isDefined, "DBRef")

  //noinspection SameParameterValue
  private def dbRefOf(expected: String): BePropertyMatcher[JsValue] =
    (jsValue: JsValue) => BePropertyMatchResult(jsValue match {
      case DbRef(actual) => actual == expected
      case _ => false
    }, s"DBRef of '$expected'")

  describe("DbRef") {

    val validProps = Map(
      "$ref" -> JsString("ref"),
      "$id" -> JsString("id"),
    )

    it("should extract from DBRefs with $ref and $id, and possibly $db fields") {
      JsObject(validProps) should be a dbRefOf("ref")
      JsObject(validProps + ("$db" -> JsString("db"))) should be a dbRefOf("ref")
    }

    it("should not extract from DBRefs where fields are not in the correct order") {
      JsObject(validProps.toSeq.reverse.toMap) shouldNot be a dbRef
    }

    it("should not extract from DBRefs where $ref is not a string") {
      JsObject(validProps + ("$ref" -> JsNumber(0))) shouldNot be a dbRef
    }

    it("should not extract from DBRefs where $db is present and not a string") {
      JsObject(validProps + ("$db" -> JsNumber(0))) shouldNot be a dbRef
    }

    it("should not extract from DBRefs where $ref or $id is missing") {
      JsObject(validProps - "$ref") shouldNot be a dbRef
      JsObject(validProps + ("$db" -> JsString("db")) - "$ref") shouldNot be a dbRef
    }

    it("should not extract from DBRefs with additional fields") {
      JsObject(validProps + ("additional" -> JsString("Hello, there!"))) shouldNot be a dbRef
    }

    it("should not extract from arbitrary objects") {
      Json.parse("""{}""") shouldNot be a dbRef
      Json.parse("""{"a":0}""") shouldNot be a dbRef
      Json.parse("""{"x":"y"}""") shouldNot be a dbRef
      Json.parse("""{"n":null}""") shouldNot be a dbRef
    }

    it("should not extract from non-object JSON values") {
      JsNull shouldNot be a dbRef
      JsFalse shouldNot be a dbRef
      JsTrue shouldNot be a dbRef
      JsNumber(0) shouldNot be a dbRef
      JsNumber(3.14) shouldNot be a dbRef
      JsString("") shouldNot be a dbRef
      JsString("I am inevitable.") shouldNot be a dbRef
      JsArray(Nil) shouldNot be a dbRef
      JsArray(Array(JsNull)) shouldNot be a dbRef
    }

  }

}
