package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.UnitTest
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.{Defaults, SeDes}

class InternalNoSqlSchemaTest extends UnitTest with SeDes with Defaults {

  describe("InternalNoSqlSchema") {

    it("should be serializable") {
      seDes(schema).entities shouldEqual schema.entities
      seDes(namedSchema) shouldEqual namedSchema
      seDes(emptySchema) shouldEqual emptySchema
    }

  }

}
