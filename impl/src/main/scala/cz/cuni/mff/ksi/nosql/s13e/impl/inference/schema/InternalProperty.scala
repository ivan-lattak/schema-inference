package cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema

sealed case class InternalProperty(name: String, `type`: InternalType, optional: Boolean = false)
  extends Ordered[InternalProperty] {

  override def compare(that: InternalProperty): Int =
    name.compare(that.name) match {
      case c if c != 0 => c
      case _ => Ordering.Boolean.compare(optional, that.optional) match {
        case c if c != 0 => c
        case _ => `type`.compare(that.`type`)
      }
    }

}
