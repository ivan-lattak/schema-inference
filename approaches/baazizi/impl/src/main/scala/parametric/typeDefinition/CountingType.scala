package parametric.typeDefinition


@SerialVersionUID(100L)
class CountingType() extends Serializable {
  def getCardinality: Long = this match {
    case t: UnionType => t.getCardinality
    case t: Empty => 0
  }

  def isEqualTo(other: CountingType): Boolean = (this, other) match {
    case (l: UnionType, r: UnionType) => l.isEqualTo(r)
    case (l: StructuralType, r: StructuralType) => l.isEqualTo(r)
    case (l: Empty, r: Empty) => true
    case (_, _) => false
  }
}

case class UnionType(body: List[StructuralType]) extends CountingType {
  override def toString: String = body.mkString("+")

  override def getCardinality: Long = body.map(_.getCardinality).sum

  /*l and r sorted*/
  def deepEqual(l: List[StructuralType], r: List[StructuralType]): Boolean = (l, r) match {
    case (Nil, Nil) => true
    case (h1 :: t1, h2 :: t2) => h1.isEqualTo(h2) && deepEqual(t1, t2)
    case _ => false
  }

  def isEqualTo(other: UnionType): Boolean = other.getCardinality == this.getCardinality && other.body.size == this.body.size &&
    deepEqual(this.body, other.body)

  //  override def equals(other: countingType): Boolean =
}

case class Empty() extends CountingType {
  override def getCardinality: Long = 0


}
