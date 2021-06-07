package cz.cuni.mff.ksi.nosql.s13e.impl.testUtil

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.{InternalEntity, InternalEntityVersion, InternalProperty, InternalType}
import org.scalatest.matchers.should.Matchers

import scala.Function.tupled

trait SchemaChecking extends Matchers {

  def checkEntity(name: String, root: Boolean, count: Int,
                  properties: Map[String, InternalType])(entity: InternalEntity): Unit = checkEntity(name, (root, count, properties))(entity)

  def checkEntity(name: String,
                  versionAttrs: (Boolean, Int, Map[String, InternalType])*)(entity: InternalEntity): Unit = {
    entity.name shouldBe name

    entity.versions should have size versionAttrs.size
    var i = 0
    for ((k, v) <- entity.versions) {
      k should be theSameInstanceAs v
      val (root, count, properties) = versionAttrs(i)
      checkVersion(v, root, count, properties)
      i += 1
    }
  }

  def checkVersion(version: InternalEntityVersion, root: Boolean, count: Int, properties: Map[String, InternalType]): Unit = {
    version.root shouldBe root
    version.count shouldBe count
    version.properties shouldEqual properties.map(tupled((k, v) => k -> InternalProperty(k, v)))
  }

}
