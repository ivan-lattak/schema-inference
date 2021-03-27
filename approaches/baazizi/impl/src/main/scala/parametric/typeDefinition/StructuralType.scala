package parametric.typeDefinition

@SerialVersionUID(100L)
sealed class StructuralType(val card: Long) extends CountingType with Serializable {
  def isEqualTo(other: StructuralType): Boolean = (this, other) match {
    case (l: Null, r: Null) => this.card == other.card
    case (l: Numb, r: Numb) => this.card == other.card
    case (l: Bool, r: Bool) => this.card == other.card
    case (l: Str, r: Str) => this.card == other.card
    case (l: RecordType, r: RecordType) => l.isEqualTo(r)
    case (l: ArrayType, r: ArrayType) => l.isEqualTo(r)
    case (_, _) => false
  } //useful for tests

  val _fieldSep = ", "
  val _kindSep = 1
  val helper = new Helper()

  val rEmpty = 1
  val rNull: Int = rEmpty + _kindSep
  val rBool: Int = rNull + _kindSep
  val rNumb: Int = rBool + _kindSep
  val rStr: Int = rNumb + _kindSep
  val maxBase: Int = rStr
  val rRecord: Int = maxBase + _kindSep
  val rArray: Int = rRecord + _kindSep

  def kind(): Int = this match {

    case Null(_) => rNull
    case Bool(_) => rBool
    case Numb(_) => rNumb
    case Str(_) => rStr
    case RecordType(_, _) => rRecord
    case ArrayType(_, _) => rArray
  }


  def kindOrdering(other: StructuralType): Int = this.kind() - other.kind()

  /** assumes records with sorted keys */
  def labelOrdering(other: StructuralType): Int = (this, other) match {
    case (r1: RecordType, r2: RecordType) => helper.strListCompare(r1.labels(), r2.labels())
    case (_, _) => this.kindOrdering(other)
  }

  /*TODO deep-value ordering*/

  override def getCardinality: Long = card

}

/*Basic types*/
//case class Empty(override val card: Long) extends structuralType(card)
case class Null(override val card: Long) extends StructuralType(card) {
  override def toString: String = "Null"
}

case class Bool(override val card: Long) extends StructuralType(card) {
  override def toString: String = "Bool"
}

case class Numb(override val card: Long) extends StructuralType(card) {
  override def toString: String = "Num"
}

case class Str(override val card: Long) extends StructuralType(card) {
  override def toString: String = "Str"
}

case class Strbis(override val card: Long, minLengthL: Long, maxLength: Long) extends StructuralType(card) {
  //  override def toString: String = tStr
}

case class StrEnum(override val card: Long, values: Map[String, Long]) extends StructuralType(card) {
  //  override def toString: String = ""
}

/*Record types*/
case class RecordType(body: List[FieldType], override val card: Long) extends StructuralType(card) {
  def labels(): List[String] = body.map(_.getLabel)

  //  override def toString: String = tRec

  /*l and r sorted*/
  def deepEqual(l: List[FieldType], r: List[FieldType]): Boolean = (l, r) match {
    case (Nil, Nil) => true
    case (h1 :: t1, h2 :: t2) => h1.isEqualTo(h2) && deepEqual(t1, t2)
    case _ => false
  }

  def isEqualTo(other: RecordType): Boolean =
    other.card == this.card && other.body.size == this.body.size &&
      other.labels() == this.labels() && deepEqual(other.body, this.body)

  override def toString: String = body.mkString("{", ",", "}")
}

/*Array types*/
case class ArrayType(body: CountingType, override val card: Long) extends StructuralType(card) {
  //  override def toString: String = tArr

  def isEqualTo(other: ArrayType): Boolean = (other.card == this.card) && this.body.isEqualTo(other.body)

  override def toString: String = "[" + body + "]"

}