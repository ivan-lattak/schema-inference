package parametric.typeInference

import org.slf4j.{Logger, LoggerFactory}
import parametric.typeDefinition._
import play.api.libs.json._

@SerialVersionUID(100L)
class Inference extends Serializable {
  val logger: Logger = LoggerFactory.getLogger(classOf[Inference])


  def inferStructType(parsed: JsValue,
                      f: (CountingType, CountingType, (StructuralType, StructuralType) => Int) => CountingType,
                      order: (StructuralType, StructuralType) => Int): StructuralType = parsed match {
    case JsNull => Null(1)
    case boolean: JsBoolean => Bool(1)
    case JsNumber(_) => Numb(1)
    case JsString(s) => Str(1) // Strbis(1,s.size(),s.size())
    case JsArray(value) => ArrayType(value.map(inferStructType(_, f, order)).fold(Empty())((T1, T2) => f(T1, T2, order)), 1)
    case JsObject(underlying) => RecordType(underlying.map { case (k, v) => new FieldType(k, inferStructType(v, f, order)) }.toList.sorted, 1)
  }
}
