package parametric.typeDefinition

@SerialVersionUID(100L)
class FieldType(label: String, body: CountingType) extends Ordered[FieldType] with Serializable {
  /**
   * setters and getters
   */
  def getCardinality: Long = body.getCardinality

  override def toString: String = this.getClass.getName + "(" + this.label + "," + this.body.toString + ")"

  def getLabel: String = this.label

  def getBody: CountingType = this.body

  def compare(other: FieldType): Int = this.label.compareTo(other.getLabel)

  def isEqualTo(other: FieldType): Boolean = (this.compare(other) == 0) && body.isEqualTo(body)
}
