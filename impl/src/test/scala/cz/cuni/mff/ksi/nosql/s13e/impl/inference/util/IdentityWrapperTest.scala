package cz.cuni.mff.ksi.nosql.s13e.impl.inference.util

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.UnitTest

class IdentityWrapperTest extends UnitTest {

  describe("IdentityWrappers") {

    they("should equal when their wrapped objects are the same instance") {
      val string = "Hello"
      IdentityWrapper(string) shouldEqual IdentityWrapper(string)
    }

    they("should not equal when their wrapped objects are different instances") {
      val string1 = "Hello"
      val string2 = new String(string1)
      IdentityWrapper(string1) should not equal IdentityWrapper(string2)
    }

  }

}
