package parametric.typeDefinition

@SerialVersionUID(100L)
class Helper extends Serializable {

  def _KindEquiv(S1: structuralType, S2: structuralType): Int = S1.kindOrdering(S2)

  def _LabelEquiv(S1: structuralType, S2: structuralType): Int = S1.labelOrdering(S2)


  def whichOrdering(variant: String): (structuralType, structuralType) => Int = variant match {
    case "k" | "K" => _KindEquiv // K-equivalence
    case "l" | "L" => _LabelEquiv //L-equivalence
  }


  def formatOutputFile(inputPath: String, equivLabel: String): String =
    inputPath.split("/").last.split("\\.")(0) + "_" + equivLabel.toUpperCase + "-Schema.json"

  def strListCompare(l1: List[String], l2: List[String]): Int = {
    if (l1.length == l2.length && l1.nonEmpty) l1.head.compareTo(l2.head) + strListCompare(l1.tail, l2.tail)
    else l1.length - l2.length
  }
}
