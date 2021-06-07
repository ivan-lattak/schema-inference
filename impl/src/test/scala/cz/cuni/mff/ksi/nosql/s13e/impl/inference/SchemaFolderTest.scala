package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema._
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.testUtil.JsonDocs
import cz.cuni.mff.ksi.nosql.s13e.impl.testUtil.SchemaChecking

class SchemaFolderTest extends UnitTest with JsonDocs with SchemaChecking {

  describe("SchemaFolder") {

    it("should fold John Doe and Vaclav Novak correctly") {
      val schema = SchemaFolder(Injector(articleJohnDoe), Injector(articleVaclavNovak))

      schema.entities should have size 5
      val article :: attachment :: author :: body :: location :: Nil = schema.entities.toList
      checkEntity("attachment", root = false, 2, Map(
        "url" -> InternalString,
      ))(attachment)

      checkEntity("body", root = false, 1, Map(
        "content" -> InternalString,
        "mime_type" -> InternalString,
      ))(body)

      checkEntity("location",
        (false, 1, Map(
          "address" -> InternalString,
        )), (false, 1, Map(
          "latitude" -> InternalString,
          "longitude" -> InternalString,
        ))
      )(location)

      checkEntity("author",
        (false, 1, Map(
          "first_name" -> InternalString,
          "last_name" -> InternalString,
          "phone_number" -> InternalNumber,
          "location" -> InternalAggregate(location.versions.head._1),
        )), (false, 1, Map(
          "first_name" -> InternalString,
          "last_name" -> InternalString,
          "phone_number" -> InternalString,
          "location" -> InternalAggregate(location.versions.toList(1)._1),
        ))
      )(author)

      checkEntity("article",
        (true, 1, Map(
          "_id" -> InternalNumber,
          "body" -> InternalString,
          "timestamp" -> InternalString,
          "author" -> InternalAggregate(author.versions.head._1),
          "ratings" -> InternalArray(InternalNumber),
          "comments" -> InternalString,
          "article_id" -> InternalNumber,
          "published" -> InternalBoolean,
        )), (true, 1, Map(
          "_id" -> InternalNumber,
          "timestamp" -> InternalString,
          "author" -> InternalAggregate(author.versions.toList(1)._1),
          "ratings" -> InternalArray(InternalNumber),
          "comments" -> InternalArray(InternalString),
          "attachments" -> InternalArray(InternalAggregate(attachment.versions.head._1)),
          "body" -> InternalAggregate(body.versions.head._1),
          "published" -> InternalBoolean,
        ))
      )(article)
    }

    it("should merge entities with root and non-root versions correctly") {
      val schema = SchemaFolder(Injector(articleJohnDoe), Injector(authorPicasso))

      schema.entities should have size 7
      val address :: article :: attachment :: author :: body :: location :: photo :: Nil = schema.entities.toList
      checkEntity("address", root = false, 1, Map(
        "street" -> InternalString,
        "country" -> InternalString,
      ))(address)

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

      checkEntity("photo", root = false, 2, Map(
        "url" -> InternalString,
      ))(photo)

      checkEntity("author",
        (true, 1, Map(
          "name" -> InternalString,
          "age" -> InternalNumber,
          "address" -> InternalAggregate(address.versions.head._1),
          "photos" -> InternalArray(InternalAggregate(photo.versions.head._1)),
        )), (false, 1, Map(
          "first_name" -> InternalString,
          "last_name" -> InternalString,
          "phone_number" -> InternalString,
          "location" -> InternalAggregate(location.versions.head._1),
        ))
      )(author)

      checkEntity("article", root = true, 1, Map(
        "_id" -> InternalNumber,
        "timestamp" -> InternalString,
        "author" -> InternalAggregate(author.versions.toList(1)._1),
        "ratings" -> InternalArray(InternalNumber),
        "comments" -> InternalArray(InternalString),
        "attachments" -> InternalArray(InternalAggregate(attachment.versions.head._1)),
        "body" -> InternalAggregate(body.versions.head._1),
        "published" -> InternalBoolean,
      ))(article)
    }

    it("should be commutative") {
      val article1 = SchemaFolder(Injector(articleJohnDoe), Injector(articleVaclavNovak))
      val article2 = SchemaFolder(Injector(articleVaclavNovak), Injector(articleJohnDoe))
      article1 shouldEqual article2

      val rootNonRoot1 = SchemaFolder(Injector(articleJohnDoe), Injector(authorPicasso))
      val rootNonRoot2 = SchemaFolder(Injector(authorPicasso), Injector(articleJohnDoe))
      rootNonRoot1 shouldEqual rootNonRoot2
    }

    it("should be associative") {
      val schema1 = SchemaFolder(SchemaFolder(Injector(articleJohnDoe), Injector(articleVaclavNovak)), Injector(authorPicasso))
      val schema2 = SchemaFolder(Injector(articleJohnDoe), SchemaFolder(Injector(articleVaclavNovak), Injector(authorPicasso)))
      schema1 shouldEqual schema2
    }

  }

}
