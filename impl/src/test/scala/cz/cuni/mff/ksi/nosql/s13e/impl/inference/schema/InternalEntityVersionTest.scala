package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.UnitTest
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.InternalDefaults

import scala.collection.immutable.TreeMap

class InternalEntityVersionTest extends UnitTest with InternalDefaults {

  val THIS_SIZE = 31
  val THAT_SIZE = 47

  describe("InternalEntityVersion") {

    val theseAggregates = (0 until THIS_SIZE).map(_ => InternalAggregate(version)).toList

    val thatVersion = InternalEntityVersion(TreeMap.empty)
    val thoseAggregates = (0 until THAT_SIZE).map(_ => InternalAggregate(thatVersion)).toList

    describe("when mergeFrom is called") {

      it("should change its aggregates' target") {
        theseAggregates.foreach(_.target should be theSameInstanceAs version)
        thoseAggregates.foreach(_.target should be theSameInstanceAs thatVersion)

        version.mergeFrom(thatVersion)
        theseAggregates.foreach(_.target should be theSameInstanceAs version)
        thoseAggregates.foreach(_.target should be theSameInstanceAs version)
      }

      it("should transfer occurrence count") {
        version.count shouldBe THIS_SIZE
        thatVersion.count shouldBe THAT_SIZE

        version.mergeFrom(thatVersion)
        version.count shouldBe THIS_SIZE + THAT_SIZE
        thatVersion.count shouldBe 0
      }

    }

    describe("when unregister is called") {

      val unregistered = THAT_SIZE / 2
      thoseAggregates.take(unregistered).foreach(_.unregister())

      it("should transfer the count of unregistered aggregates to additional") {
        thatVersion.count shouldBe THAT_SIZE
        thatVersion.liveAggregates.size shouldBe THAT_SIZE - unregistered
        thatVersion.additionalCount shouldBe unregistered
      }

      describe("and then mergeFrom is called") {

        version.mergeFrom(thatVersion)

        it("should correctly transfer the count and change targets") {
          version.count shouldBe THIS_SIZE + THAT_SIZE
          thatVersion.count shouldBe 0

          version.liveAggregates.size shouldBe THIS_SIZE + (THAT_SIZE - unregistered)
          version.additionalCount shouldBe unregistered

          thoseAggregates.drop(unregistered).foreach(_.target should be theSameInstanceAs version)
        }

      }

    }

  }

}
