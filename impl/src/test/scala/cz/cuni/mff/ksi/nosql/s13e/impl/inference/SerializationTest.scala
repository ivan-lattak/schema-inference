package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.testUtil.JsonDocs
import cz.cuni.mff.ksi.nosql.s13e.impl.testUtil.{InternalDefaults, SeDes}

class SerializationTest extends UnitTest with InternalDefaults with JsonDocs with SeDes {

  describe("Schema objects") {

    they("should be serializable") {
      for (obj <- schemaObjects) {
        seDes(obj) shouldEqual obj
      }
    }

  }

  describe("Raw schemas") {

    they("should be serializable") {
      for (obj <- objectsWithRawSchemas) {
        seDes(obj) shouldEqual obj
      }
    }

  }

}
