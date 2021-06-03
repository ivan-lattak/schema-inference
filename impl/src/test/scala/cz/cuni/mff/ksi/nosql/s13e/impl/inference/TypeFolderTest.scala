package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.{InternalAggregate, InternalArray, InternalType, InternalUnionType}
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.InternalDefaults

class TypeFolderTest extends UnitTest with InternalDefaults {

  describe("TypeFolder") {

    it("should be a noop on identical types") {
      for (t <- types) {
        TypeFolder(t, t) shouldBe t
      }
    }

    it("should have an identity element: the unknown type") {
      for (t <- types) {
        TypeFolder(t, unknown) shouldBe t
        TypeFolder(unknown, t) shouldBe t
      }
    }

    it("should be commutative") {
      for (t1 <- types) {
        for (t2 <- types) {
          TypeFolder(t1, t2) shouldEqual TypeFolder(t2, t1)
        }
      }
    }

    it("should correctly fold different known types into the correct order") {
      TypeFolder(boolean, string) shouldBe InternalUnionType(List(boolean, string))
      TypeFolder(string, boolean) shouldBe InternalUnionType(List(boolean, string))
      TypeFolder(boolean, array) shouldBe InternalUnionType(List(boolean, array))
      TypeFolder(array, aggregate) shouldBe InternalUnionType(List(array, aggregate))
      TypeFolder(union, array) shouldBe InternalUnionType(List(boolean, number, array))

      List[InternalType](unknown, array, array, string, boolean, array, aggregate)
        .fold(unknown)(TypeFolder) shouldBe InternalUnionType(List(boolean, string, array, aggregate))
    }

    describe("when unions are involved") {

      val unionBoolNumStr = InternalUnionType(List(boolean, number, string))
      val unionBoolAgg = InternalUnionType(List(boolean, aggregate))
      val unionStrArrayRef = InternalUnionType(List(string, array, reference))
      val arrayNum = InternalArray(number)
      val aggX = InternalAggregate(versionWithX)
      val aggXY = InternalAggregate(versionWithXAndY)

      it("should correctly fold different unions") {
        val unionAggXAggXY = InternalUnionType(List(aggX, aggXY))
        val unionAggXYRef = InternalUnionType(List(aggXY, reference))
        TypeFolder(unionAggXAggXY, unionAggXAggXY) shouldBe unionAggXAggXY
        TypeFolder(unionAggXYRef, unionAggXYRef) shouldBe unionAggXYRef

        TypeFolder(unionBoolNumStr, unionBoolAgg) shouldBe InternalUnionType(List(boolean, number, string, aggregate))
        TypeFolder(unionBoolNumStr, unionStrArrayRef) shouldBe InternalUnionType(List(boolean, number, string, array, reference))
        TypeFolder(unionBoolNumStr, unionAggXAggXY) shouldBe InternalUnionType(List(boolean, number, string, aggX, aggXY))
        TypeFolder(unionBoolNumStr, unionAggXYRef) shouldBe InternalUnionType(List(boolean, number, string, aggXY, reference))

        TypeFolder(unionBoolAgg, unionStrArrayRef) shouldBe InternalUnionType(List(boolean, string, array, aggregate, reference))
        TypeFolder(unionBoolAgg, unionAggXAggXY) shouldBe InternalUnionType(List(boolean, aggregate, aggX, aggXY))
        TypeFolder(unionBoolAgg, unionAggXYRef) shouldBe InternalUnionType(List(boolean, aggregate, aggXY, reference))

        TypeFolder(unionStrArrayRef, unionAggXAggXY) shouldBe InternalUnionType(List(string, array, aggX, aggXY, reference))
        TypeFolder(unionStrArrayRef, unionAggXYRef) shouldBe InternalUnionType(List(string, array, aggXY, reference))

        TypeFolder(unionAggXAggXY, unionAggXYRef) shouldBe InternalUnionType(List(aggX, aggXY, reference))
      }

      it("should correctly fold different arrays") {
        val arrayStr = InternalArray(string)
        val arrayAgg = InternalArray(aggregate)
        val arrayBoolNumStr = InternalArray(unionBoolNumStr)
        val arrayBoolAgg = InternalArray(unionBoolAgg)
        val arrayStrArrayRef = InternalArray(unionStrArrayRef)

        TypeFolder(array, arrayAgg) shouldBe arrayAgg
        TypeFolder(arrayNum, arrayBoolNumStr) shouldBe arrayBoolNumStr
        TypeFolder(arrayStr, arrayBoolAgg) shouldBe InternalArray(InternalUnionType(List(boolean, string, aggregate)))
        TypeFolder(arrayBoolNumStr, arrayStrArrayRef) shouldBe InternalArray(
          InternalUnionType(List(boolean, number, string, array, reference)))

        List[InternalType](arrayNum, arrayStr, arrayAgg, arrayBoolNumStr, arrayBoolAgg, arrayStrArrayRef)
          .fold(unknown)(TypeFolder) shouldBe InternalArray(InternalUnionType(List(boolean, number, string, array, aggregate, reference)))
      }

      it("should correctly fold different unions with nested arrays") {
        val unionNumArrayNum = InternalUnionType(List(number, arrayNum))
        val unionBoolStrArrayArrayNum = InternalUnionType(List(boolean, string, InternalArray(arrayNum)))
        val unionArrayAggXYAggX = InternalUnionType(List(InternalArray(aggXY), aggX))

        TypeFolder(unionNumArrayNum, unionBoolStrArrayArrayNum) shouldBe InternalUnionType(List(boolean, number, string,
          InternalArray(InternalUnionType(List(number, arrayNum)))))
        TypeFolder(unionNumArrayNum, unionArrayAggXYAggX) shouldBe InternalUnionType(List(number,
          InternalArray(InternalUnionType(List(number, aggXY))), aggX))
        TypeFolder(unionBoolStrArrayArrayNum, unionArrayAggXYAggX) shouldBe InternalUnionType(List(boolean, string,
          InternalArray(InternalUnionType(List(arrayNum, aggXY))), aggX))
      }

    }

    it("should unregister aggregates from their targets when they are folded") {
      val thisAggregate = InternalAggregate(version)
      val thatAggregate = InternalAggregate(version)
      version.count shouldBe 2

      TypeFolder(thisAggregate, thatAggregate) shouldEqual thisAggregate
      version.count shouldBe 2
      thisAggregate.isUnregistered shouldBe !thatAggregate.isUnregistered
    }

    it("should not unregister folded aggregate if it is the same instance") {
      val aggregate = InternalAggregate(version)
      version.count shouldBe 1

      TypeFolder(aggregate, aggregate) shouldEqual aggregate
      version.count shouldBe 1
      aggregate.isUnregistered shouldBe false
    }

  }

}
