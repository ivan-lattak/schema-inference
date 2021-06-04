package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.UnitTest
import cz.cuni.mff.ksi.nosql.s13e.impl.testUtil.InternalDefaults

class InternalPropertyTest extends UnitTest with InternalDefaults {

  describe("InternalProperty's natural ordering") {

    val propertyAStrOpt = InternalProperty("a", string, optional = true)
    val propertyCBool = InternalProperty("c", boolean)

    it("should order by name first") {
      val propertyBNumOpt = InternalProperty("b", number, optional = true)

      propertyAStrOpt should be < propertyBNumOpt
      propertyBNumOpt should be < propertyCBool
    }

    it("should order by optionality, when name is the same") {
      val propertyAStr = propertyAStrOpt.copy(optional = false)
      val propertyCBoolOpt = propertyCBool.copy(optional = true)

      propertyAStr should be < propertyAStrOpt
      propertyCBool should be < propertyCBoolOpt
    }

    it("should order by type, when name and optionality are the same") {
      val propertyCNum = propertyCBool.copy(`type` = number)
      val propertyCStr = propertyCBool.copy(`type` = string)

      propertyCBool should be < propertyCNum
      propertyCNum should be < propertyCStr
    }

  }

}
