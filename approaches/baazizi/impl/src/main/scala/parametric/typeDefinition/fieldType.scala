package parametric.typeDefinition

@SerialVersionUID(100L)
class fieldType(label: String, body: countingType) extends Ordered[fieldType] with Serializable {
  /**
   * setters and getters
   */
  def getCardinality: Long = body.getCardinality

  override def toString: String = this.getClass.getName + "(" + this.label + "," + this.body.toString + ")"

  def getLabel: String = this.label

  def getBody: countingType = this.body

  def compare(other: fieldType): Int = this.label.compareTo(other.getLabel)

  def isEqualTo(other: fieldType): Boolean = (this.compare(other) == 0) && body.isEqualTo(body)
}
