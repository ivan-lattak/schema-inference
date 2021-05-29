package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.{Defaults, SeDes}

class SerializationTest extends UnitTest with Defaults with SeDes {

  describe("Schema objects") {

    they("should be serializable") {
      for (obj <- schemaObjects) {
        seDes(obj) shouldEqual obj
      }
    }

  }

}
