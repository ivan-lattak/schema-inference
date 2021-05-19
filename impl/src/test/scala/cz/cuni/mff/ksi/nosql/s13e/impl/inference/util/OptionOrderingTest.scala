package cz.cuni.mff.ksi.nosql.s13e.impl.inference.util

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.UnitTest

class OptionOrderingTest extends UnitTest {

  describe("OptionOrdering") {
    it("should correctly compare Options when at least one is None") {
      OptionOrdering.compareOptions[Unit](None, None) should be(0)
      OptionOrdering.compareOptions(None, Some(5)) should be < 0
      OptionOrdering.compareOptions(Some(42), None) should be > 0
    }

    it("should compare Options by contents when both are Some") {
      OptionOrdering.compareOptions(Some(5), Some(42)) should be < 0
      OptionOrdering.compareOptions(Some(42), Some(5)) should be > 0
      OptionOrdering.compareOptions(Some(15), Some(15)) should be(0)
    }

    describe("when given custom content ordering") {
      def ord[T]: Ordering[List[T]] = (x: List[T], y: List[T]) => x.size - y.size

      it("should still give the outer-most Option the highest priority") {
        OptionOrdering.compareOptions(None, Some(List("item here")))(ord) should be < 0
        OptionOrdering.compareOptions(Some(List()), None)(ord) should be > 0
      }

      it("should compare contents using that ordering") {
        OptionOrdering.compareOptions(Some(List()), Some(Nil))(ord) should be(0)
        OptionOrdering.compareOptions(Some(List("Hello")), Some(List("there")))(ord) should be(0)
        OptionOrdering.compareOptions(Some(Nil), Some(List("item")))(ord) should be < 0
        OptionOrdering.compareOptions(Some(List("bigger")), Some(Nil))(ord) should be > 0
      }
    }

  }

}
