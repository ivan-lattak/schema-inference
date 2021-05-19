package cz.cuni.mff.ksi.nosql.s13e.impl.inference.util

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.UnitTest

class OptionOrderingTest extends UnitTest {

  describe("OptionOrdering") {
    it("should correctly compare different options") {
      OptionOrdering.compareOptions(None, Some(1)) should be < 0
    }
  }

}
