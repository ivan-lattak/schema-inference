package cz.cuni.mff.ksi.nosql.s13e.impl.testUtil

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, ObjectInputStream, ObjectOutputStream}
import scala.util.{Failure, Success, Try}

/**
 * Short for Serialize-Deserialize
 */
trait SeDes {

  def seDes[T <: Serializable](t: T): T = deserialize(serialize(t))

  def serialize[T <: Serializable](t: T): Array[Byte] = {
    val baos = new ByteArrayOutputStream()
    using(new ObjectOutputStream(baos)) {
      _.writeObject(t)
    }
    baos.toByteArray
  }

  def deserialize[T <: Serializable](array: Array[Byte]): T = {
    val bais = new ByteArrayInputStream(array)
    using(new ObjectInputStream(bais)) {
      _.readObject().asInstanceOf[T]
    }
  }

  private def using[A <: AutoCloseable, B](resource: A)(block: A => B): B =
    Try(block(resource)) match {
      case Success(result) =>
        resource.close()
        result
      case Failure(e) =>
        resource.close()
        throw e
    }

}
