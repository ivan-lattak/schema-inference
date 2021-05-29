package cz.cuni.mff.ksi.nosql.s13e.impl.inference.util

sealed case class IdentityWrapper[T <: AnyRef](t: T) {

  override def equals(that: Any): Boolean = that match {
    case that: IdentityWrapper[T] => t eq that.t
    case _ => false
  }

  override def hashCode(): Int = 31 + System.identityHashCode(t)

}
