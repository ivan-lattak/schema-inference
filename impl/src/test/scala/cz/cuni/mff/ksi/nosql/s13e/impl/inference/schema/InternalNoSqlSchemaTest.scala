package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.UnitTest
import cz.cuni.mff.ksi.nosql.s13e.impl.testUtil.InternalDefaults

class InternalNoSqlSchemaTest extends UnitTest with InternalDefaults {

  describe("Equals methods within InternalNoSqlSchema hierarchy") {

    it("should be commutative") {
      schema should not equal namedSchema
      namedSchema should not equal schema

      schema shouldEqual emptySchema
      emptySchema shouldEqual schema

      emptySchema should not equal namedSchema
      namedSchema should not equal emptySchema
    }

  }

}
