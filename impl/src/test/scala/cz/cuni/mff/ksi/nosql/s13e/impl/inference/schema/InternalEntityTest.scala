package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.UnitTest
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.InternalDefaults

class InternalEntityTest extends UnitTest with InternalDefaults {

  describe("InternalEntity's getOrAddIdenticalVersion method") {

    it("should cause version map to grow if the version is new") {
      entity.versions.size shouldBe 0

      entity.getOrAddIdenticalVersion(propertiesWithX)
      entity.versions.size shouldBe 1

      entity.getOrAddIdenticalVersion(propertiesWithX)
      entity.versions.size shouldBe 1

      entity.getOrAddIdenticalVersion(propertiesWithXAndY)
      entity.versions.size shouldBe 2
    }

    it("should return the same version instance every time for equal properties") {
      val versionWithX = entity.getOrAddIdenticalVersion(propertiesWithX)
      entity.getOrAddIdenticalVersion(propertiesWithX) should be theSameInstanceAs versionWithX
      entity.getOrAddIdenticalVersion(propertiesWithX) should be theSameInstanceAs versionWithX

      val versionWithXAndY = entity.getOrAddIdenticalVersion(propertiesWithXAndY)
      versionWithXAndY should not equal versionWithX
      entity.getOrAddIdenticalVersion(propertiesWithXAndY) should be theSameInstanceAs versionWithXAndY
      entity.getOrAddIdenticalVersion(propertiesWithXAndY) should be theSameInstanceAs versionWithXAndY

      val newPropertiesWithX = propertiesWithX.map(identity)
      newPropertiesWithX shouldEqual propertiesWithX
      newPropertiesWithX shouldNot be theSameInstanceAs propertiesWithX
      entity.getOrAddIdenticalVersion(propertiesWithX) should be theSameInstanceAs versionWithX
    }

  }

}
