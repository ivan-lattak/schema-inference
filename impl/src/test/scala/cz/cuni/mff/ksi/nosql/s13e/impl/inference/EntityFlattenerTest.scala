package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.{Aggregate, UnionType}
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.ModelDefaults

import scala.collection.JavaConverters.seqAsJavaListConverter

class EntityFlattenerTest extends UnitTest with ModelDefaults {

  describe("EntityFlattener") {

    it("should return an empty entity unchanged") {
      schema.getEntities.add(entity)
      EntityFlattener.flatten(schema, entity) should be theSameInstanceAs schema
    }

    it("should correctly flatten entity with two versions") {
      schema.getEntities.add(entity)
      entity.getVersions.addAll(List(versionWithX, versionWithXAndY).asJava)
      EntityFlattener.flatten(schema, entity) should be theSameInstanceAs schema
      entity.isFlattened shouldBe true

      entity.getVersions should have size 1
      val v = entity.getVersions.get(0)
      v.getId shouldBe 0
      v.getProperties should have size 2

      val p1 = v.getProperties.get(0)
      p1.getName shouldBe "x"
      p1.isOptional shouldBe false
      p1.getType shouldBe a[UnionType]
      val types = p1.getType.asInstanceOf[UnionType].getTypes
      types should have size 2
      types.get(0) shouldBe a[NoSQLSchema.Number]
      types.get(1) shouldBe a[NoSQLSchema.String]

      val p2 = v.getProperties.get(1)
      p2.getName shouldBe "y"
      p2.isOptional shouldBe true
      p2.getType shouldBe a[NoSQLSchema.Number]
    }

    it("should leave an already flattened entity unchanged") {
      schema.getEntities.add(entity)
      entity.getVersions.addAll(List(versionWithX, versionWithXAndY).asJava)
      entity.setFlattened(true)

      EntityFlattener.flatten(schema, entity) should be theSameInstanceAs schema
      entity.getVersions should have size 2
    }

    it("should throw exception on an entity which contains path from one version to another") {
      schema.getEntities.add(entity)
      entity.getVersions.add(versionWithX)
      entity.getVersions.add(versionWith(
        "nested" -> aggregateOf(versionWithX)
      ))

      an[IllegalArgumentException] should be thrownBy {
        EntityFlattener.flatten(schema, entity)
      }
    }

    it("should fix aggregates targeting merged versions") {
      schema.getEntities.add(entity)
      entity.getVersions.add(versionWithX)
      entity.getVersions.add(versionWithXAndY)

      val another = factory.createEntity()
      another.setName("another")
      val versionWithY = versionWith(
        "y" -> number
      )
      another.getVersions.add(versionWithY)
      schema.getEntities.add(another)

      val parent = factory.createEntity()
      parent.setName("parent")
      parent.getVersions.add(versionWith("union" -> unionOf(
        aggregateOf(versionWithX),
        aggregateOf(versionWithY),
        aggregateOf(versionWithXAndY),
      )))
      schema.getEntities.add(parent)

      EntityFlattener.flatten(schema, entity) should be theSameInstanceAs schema

      schema.getEntities should have size 3
      schema.getEntities should contain(parent)
      parent.getVersions should have size 1
      parent.getVersions.get(0).getProperties should have size 1

      val loneType = parent.getVersions.get(0).getProperties.get(0).getType
      loneType shouldBe a[UnionType]
      val types = loneType.asInstanceOf[UnionType].getTypes
      types should have size 2
      types.get(0).asInstanceOf[Aggregate].getTarget shouldBe versionWithY
      types.get(1).asInstanceOf[Aggregate].getTarget shouldBe versionWithX // this actually contains X and optionally Y
    }

    it("should unwrap a merged aggregate from a union, if there is nothing else") {
      schema.getEntities.add(entity)
      entity.getVersions.add(versionWithX)
      entity.getVersions.add(versionWithXAndY)

      val parent = factory.createEntity()
      parent.setName("parent")
      parent.getVersions.add(versionWith(
        "x" -> unionOf(aggregateOf(versionWithX), aggregateOf(versionWithXAndY))
      ))
      schema.getEntities.add(parent)

      EntityFlattener.flatten(schema, entity) should be theSameInstanceAs schema

      schema.getEntities should have size 2
      schema.getEntities should contain(parent)
      parent.getVersions should have size 1
      parent.getVersions.get(0).getProperties should have size 1

      val loneType = parent.getVersions.get(0).getProperties.get(0).getType
      loneType shouldBe an[Aggregate]
      loneType.asInstanceOf[Aggregate].getTarget shouldBe versionWithX
    }

  }

}
