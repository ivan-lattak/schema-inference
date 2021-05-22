package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.UnitTest
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.Defaults

import scala.collection.immutable.TreeMap

class InternalEntityVersionTest extends UnitTest with Defaults {

  val THIS_SIZE = 31
  val THAT_SIZE = 47

  describe("InternalEntityVersion's mergeAggregatesFrom method") {

    val theseAggregates = (0 until THIS_SIZE).map(_ => InternalAggregate(version)).toList

    val thatVersion = InternalEntityVersion(TreeMap.empty)
    val thoseAggregates = (0 until THAT_SIZE).map(_ => InternalAggregate(thatVersion)).toList

    it("should change the aggregates' target") {
      theseAggregates.foreach(_.target should be theSameInstanceAs version)
      thoseAggregates.foreach(_.target should be theSameInstanceAs thatVersion)

      version.mergeAggregatesFrom(thatVersion)
      theseAggregates.foreach(_.target should be theSameInstanceAs version)
      thoseAggregates.foreach(_.target should be theSameInstanceAs version)
    }

    it("should transfer occurrence count") {
      version.count shouldBe THIS_SIZE
      thatVersion.count shouldBe THAT_SIZE

      version.mergeAggregatesFrom(thatVersion)
      version.count shouldBe THIS_SIZE + THAT_SIZE
      thatVersion.count shouldBe 0
    }

  }

}
