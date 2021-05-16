package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalType

private case object TypeFolder extends ((InternalType, InternalType) => InternalType) {

  override def apply(left: InternalType, right: InternalType): InternalType = ???

}
