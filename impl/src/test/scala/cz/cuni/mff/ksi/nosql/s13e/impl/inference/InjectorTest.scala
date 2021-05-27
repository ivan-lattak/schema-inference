package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema._
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.{JsonDocs, SchemaChecking}

class InjectorTest extends UnitTest with JsonDocs with SchemaChecking {

  describe("Injector") {

    it("should inject Picasso object correctly") {
      val schema = Injector(userPicasso)

      schema.entities should have size 3
      val address :: photo :: user :: Nil = schema.entities.toList
      checkEntity("address", root = false, 1, Map(
        "country" -> InternalString,
        "street" -> InternalString,
      ))(address)

      checkEntity("photo", root = false, 2, Map(
        "url" -> InternalString,
      ))(photo)

      checkEntity("user", root = true, 1, Map(
        "address" -> InternalAggregate(address.versions.head._1),
        "age" -> InternalNumber,
        "name" -> InternalString,
        "photos" -> InternalArray(InternalAggregate(photo.versions.head._1))
      ))(user)
    }

    it("should inject article by John Doe correctly") {
      val schema = Injector(articleJohnDoe)

      schema.entities should have size 5
      val article :: attachment :: author :: body :: location :: Nil = schema.entities.toList
      checkEntity("attachment", root = false, 2, Map(
        "url" -> InternalString,
      ))(attachment)

      checkEntity("body", root = false, 1, Map(
        "content" -> InternalString,
        "mime_type" -> InternalString,
      ))(body)

      checkEntity("location", root = false, 1, Map(
        "latitude" -> InternalString,
        "longitude" -> InternalString,
      ))(location)

      checkEntity("author", root = false, 1, Map(
        "first_name" -> InternalString,
        "last_name" -> InternalString,
        "phone_number" -> InternalString,
        "location" -> InternalAggregate(location.versions.head._1),
      ))(author)

      checkEntity("article", root = true, 1, Map(
        "_id" -> InternalNumber,
        "timestamp" -> InternalString,
        "author" -> InternalAggregate(author.versions.head._1),
        "ratings" -> InternalArray(InternalNumber),
        "comments" -> InternalArray(InternalString),
        "attachments" -> InternalArray(InternalAggregate(attachment.versions.head._1)),
        "body" -> InternalAggregate(body.versions.head._1),
        "published" -> InternalBoolean,
      ))(article)
    }

    it("should inject article by Vaclav Novak correctly") {
      val schema = Injector(articleVaclavNovak)

      schema.entities should have size 3
      val article :: author :: location :: Nil = schema.entities.toList
      checkEntity("location", root = false, 1, Map(
        "address" -> InternalString,
      ))(location)

      checkEntity("author", root = false, 1, Map(
        "first_name" -> InternalString,
        "last_name" -> InternalString,
        "phone_number" -> InternalNumber,
        "location" -> InternalAggregate(location.versions.head._1),
      ))(author)

      checkEntity("article", root = true, 1, Map(
        "_id" -> InternalNumber,
        "body" -> InternalString,
        "timestamp" -> InternalString,
        "author" -> InternalAggregate(author.versions.head._1),
        "ratings" -> InternalArray(InternalNumber),
        "comments" -> InternalString,
        "article_id" -> InternalNumber,
        "published" -> InternalBoolean,
      ))(article)
    }

  }

}
