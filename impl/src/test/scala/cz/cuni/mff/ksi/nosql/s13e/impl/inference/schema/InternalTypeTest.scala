package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.UnitTest
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.InternalDefaults

class InternalTypeTest extends UnitTest with InternalDefaults {

  describe("InternalType's natural ordering") {

    val ord = implicitly[Ordering[InternalType]]

    it("should correctly order same subtypes") {
      ord.compare(unknown, unknown) shouldBe 0
      ord.compare(boolean, boolean) shouldBe 0
      ord.compare(number, number) shouldBe 0
      ord.compare(string, string) shouldBe 0
      ord.compare(array, array) shouldBe 0
      ord.compare(aggregate, aggregate) shouldBe 0
      ord.compare(reference, reference) shouldBe 0
      ord.compare(union, union) shouldBe 0
    }

    it("should correctly order different subtypes") {
      ord.compare(unknown, boolean) should be < 0
      ord.compare(boolean, number) should be < 0
      ord.compare(number, string) should be < 0
      ord.compare(string, array) should be < 0
      ord.compare(array, aggregate) should be < 0
      ord.compare(aggregate, reference) should be < 0
      ord.compare(reference, union) should be < 0
    }

    it("should correctly order arrays with different element types") {
      ord.compare(InternalArray(unknown), InternalArray(boolean)) should be < 0
      ord.compare(InternalArray(boolean), InternalArray(boolean)) shouldBe 0
      ord.compare(InternalArray(number), InternalArray(boolean)) should be > 0
    }

    it("should correctly order aggregates of different versions") {
      ord.compare(InternalAggregate(version), InternalAggregate(versionWithX)) should be < 0
      ord.compare(InternalAggregate(versionWithX), InternalAggregate(versionWithX)) shouldBe 0
      ord.compare(InternalAggregate(versionWithXAndY), InternalAggregate(versionWithX)) should be > 0
    }

    describe("when ordering references") {

      val refA = InternalEntityReference("A")
      val refAA = InternalEntityReference("AA")

      val refBool = InternalEntityReference("", Some(boolean))
      val refNum = InternalEntityReference("", Some(number))
      val refStr = InternalEntityReference("", Some(string))

      it("should consider entity names") {
        ord.compare(reference, refA) should be < 0
        ord.compare(refA, refA) shouldBe 0
        ord.compare(refAA, refA) should be > 0
      }

      it("should consider original types") {
        ord.compare(refBool, refNum) should be < 0
        ord.compare(refNum, refNum) shouldBe 0
        ord.compare(refStr, refNum) should be > 0
      }

      it("should consider entity name first, then original type") {
        ord.compare(refAA, refBool) should be > 0
      }

    }

    it("should correctly order different union types") {
      val boolNum = InternalUnionType(List(boolean, number))
      val boolStr = InternalUnionType(List(boolean, string))
      val strNum = InternalUnionType(List(number, string))
      val boolNumStr = InternalUnionType(List(boolean, number, string))

      ord.compare(boolNum, boolStr) should be < 0
      ord.compare(boolNum, strNum) should be < 0
      ord.compare(boolStr, strNum) should be < 0

      ord.compare(boolNum, boolNumStr) should be < 0
      ord.compare(boolStr, boolNumStr) should be > 0
      ord.compare(strNum, boolNumStr) should be > 0
    }

  }

  describe("InternalAggregate") {

    it("should notify the target upon construction") {
      version.count shouldBe 0

      val aggregate = InternalAggregate(version)
      version.count shouldBe 1
      version.liveAggregates shouldEqual List(aggregate)
    }

    it("should be moved to additional count when unregister is called") {
      version.count shouldBe 0

      val aggregate = InternalAggregate(version)
      version.count shouldBe 1
      version.liveAggregates shouldEqual List(aggregate)
      version.additionalCount shouldBe 0

      aggregate.unregister()
      version.count shouldBe 1
      version.liveAggregates shouldBe empty
      version.additionalCount shouldBe 1
    }

  }

}
