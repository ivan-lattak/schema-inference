package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.{Entity, EntityReference, Property}
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.Converter.{internalToModel, modelToInternal}
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.JsonDocs

import scala.collection.JavaConverters.collectionAsScalaIterableConverter
import scala.reflect.ClassTag

class ConverterTest extends UnitTest with JsonDocs {

  describe("Converter") {

    it("should convert Picasso to model correctly") {
      val model = internalToModel(Injector(userPicasso).named("Test schema"))
      model.getName shouldBe "Test schema"

      val entities = model.getEntities
      entities should have size 3

      val address :: photo :: user :: Nil = entities.asScala.toList
      checkEntityAndVersion("address", root = false, 1, 0, 2)(address)
      checkEntityAndVersion("photo", root = false, 1, 1, 1)(photo)
      checkEntityAndVersion("user", root = true, 0, 1, 4)(user)
    }

    it("should convert John Doe to model correctly") {
      val model = internalToModel(Injector(articleJohnDoe).named("Test schema"))
      model.getName shouldBe "Test schema"

      val entities = model.getEntities
      entities should have size 5

      val article :: attachment :: author :: body :: location :: Nil = entities.asScala.toList
      checkEntityAndVersion("article", root = true, 0, 1, 8)(article)
      checkEntityAndVersion("attachment", root = false, 1, 1, 1)(attachment)
      checkEntityAndVersion("author", root = false, 1, 0, 4)(author)
      checkEntityAndVersion("body", root = false, 1, 0, 2)(body)
      checkEntityAndVersion("location", root = false, 1, 0, 2)(location)
    }

    it("should detect references by name when converting") {
      val model = internalToModel(Injector(objectNameReference).named("Test schema"))
      model.getName shouldBe "Test schema"

      val entities = model.getEntities
      entities should have size 1

      val user = entities.asScala.head
      checkEntityAndVersion("user", root = true, 0, 1, 4)(user)

      val properties = user.getVersions.get(0).getProperties
      properties should have size 4
      checkEntityRef[NoSQLSchema.String]("userId", user)(properties.get(0))
      checkEntityRefArray[NoSQLSchema.String]("userIds", user)(properties.get(1))
      checkEntityRef[NoSQLSchema.Number]("user_id", user)(properties.get(2))
      checkEntityRefArray[NoSQLSchema.Number]("user_ids", user)(properties.get(3))
    }

    ignore("should convert to and from model correctly") {
      val picassoBefore = Injector(userPicasso).named("Test schema")
      val picassoAfter = modelToInternal(internalToModel(picassoBefore))
      picassoAfter shouldEqual picassoBefore

      val johnDoeBefore = Injector(articleJohnDoe).named("Test schema")
      val johnDoeAfter = modelToInternal(internalToModel(johnDoeBefore))
      johnDoeAfter shouldEqual johnDoeBefore

      val vaclavNovakBefore = Injector(articleVaclavNovak).named("Test schema")
      val vaclavNovakAfter = modelToInternal(internalToModel(vaclavNovakBefore))
      vaclavNovakAfter shouldEqual vaclavNovakBefore

      val foldedBefore = SchemaFolder(johnDoeBefore, vaclavNovakBefore).named("Test schema")
      val foldedAfter = modelToInternal(internalToModel(foldedBefore))
      foldedAfter shouldEqual foldedBefore
    }

  }

  private def checkEntityAndVersion(name: String,
                                    root: Boolean,
                                    aggregates: Int,
                                    additionalCount: Int,
                                    properties: Int)(entity: Entity): Unit = {
    entity.getName shouldEqual name
    entity.isRoot shouldBe root
    entity.getVersions should have size 1
    val version = entity.getVersions.get(0)
    version.getId shouldBe 0
    version.getAggregates should have size aggregates
    version.getAdditionalCount shouldBe additionalCount
    version.getProperties should have size properties
  }


  private def checkEntityRef[T: ClassTag](name: String,
                                          target: Entity)(property: Property) = {
    property.getName shouldBe name
    property.isOptional shouldBe false
    val ref = property.getType
    ref shouldBe an[EntityReference]
    ref.asInstanceOf[EntityReference].getTarget should be theSameInstanceAs target
    ref.asInstanceOf[EntityReference].getOriginalType shouldBe a[T]
  }

  private def checkEntityRefArray[T: ClassTag](name: String,
                                               target: Entity)(property: Property) = {
    property.getName shouldBe name
    property.isOptional shouldBe false
    val array = property.getType
    array shouldBe a[NoSQLSchema.Array]
    val ref = array.asInstanceOf[NoSQLSchema.Array].getElementType
    ref shouldBe an[EntityReference]
    ref.asInstanceOf[EntityReference].getTarget should be theSameInstanceAs target
    ref.asInstanceOf[EntityReference].getOriginalType shouldBe a[T]
  }

}
