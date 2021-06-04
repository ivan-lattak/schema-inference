package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.testUtil.{ModelChecking, ModelDefaults}

import scala.collection.JavaConverters.seqAsJavaListConverter

class EntityFlattenerTest extends UnitTest with ModelDefaults with ModelChecking {

  describe("EntityFlattener") {

    it("should return an empty entity unchanged") {
      schema.getEntities.add(entity)
      EntityFlattener.flatten(schema, entity) should be theSameInstanceAs schema
    }

    it("should correctly flatten entity with two versions") {
      schema.getEntities.add(entity)
      entity.getVersions.addAll(List(versionWithX, versionWithXAndY).asJava)
      EntityFlattener.flatten(schema, entity) should be theSameInstanceAs schema
      checkEntity(entity, "entity*", false, (0, 0)) { versions =>
        checkProperties(versions.get(0).getProperties,
          "x" -> aUnionOf(aNumber, aString),
          "y?" -> aNumber,
        )
      }
    }

    it("should leave an already flattened entity unchanged") {
      schema.getEntities.add(entity)
      versionWithXAndY.setId(1)
      entity.getVersions.addAll(List(versionWithX, versionWithXAndY).asJava)
      entity.setFlattened(true)

      EntityFlattener.flatten(schema, entity) should be theSameInstanceAs schema
      checkEntity(entity, "entity*", false, (0, 0), (0, 0)) { versions =>
        checkProperties(versions.get(0).getProperties,
          "x" -> aString,
        )
        checkProperties(versions.get(1).getProperties,
          "x" -> aNumber,
          "y" -> aNumber,
        )
      }
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
      entity.getVersions.add(versionWithX)
      entity.getVersions.add(versionWithXAndY)

      val another = factory.createEntity()
      another.setName("another")
      val versionWithY = versionWith(
        "y" -> number
      )
      another.getVersions.add(versionWithY)
      schema.getEntities.add(another)
      schema.getEntities.add(entity)

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
      checkEntity(schema.getEntities.get(2), "parent", false, (0, 0)) { versions =>
        checkProperties(versions.get(0).getProperties,
          "union" -> aUnionOf(anAggregateOf(versionWithY), anAggregateOf(versionWithX)) // versionWithX actually contains X and optionally Y
        )
      }
    }

    it("should unwrap a merged aggregate from a union, if there is nothing else") {
      schema.getEntities.add(entity)
      entity.getVersions.add(versionWithX)
      entity.getVersions.add(versionWithXAndY)

      val parent = factory.createEntity()
      parent.setName("parent")
      parent.getVersions.add(versionWith(
        "union" -> unionOf(aggregateOf(versionWithX), aggregateOf(versionWithXAndY))
      ))
      schema.getEntities.add(parent)

      EntityFlattener.flatten(schema, entity) should be theSameInstanceAs schema

      schema.getEntities should have size 2
      checkEntity(schema.getEntities.get(1), "parent", false, (0, 0)) { versions =>
        checkProperties(versions.get(0).getProperties,
          "union" -> anAggregateOf(versionWithX),
        )
      }
    }

  }

}
