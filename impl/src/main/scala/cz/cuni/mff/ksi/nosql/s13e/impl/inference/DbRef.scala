package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import com.typesafe.scalalogging.LazyLogging
import play.api.libs.json.{JsObject, JsString, JsValue}

private case object DbRef extends LazyLogging {

  def unapply(value: JsValue): Option[String] = {
    if (!value.isInstanceOf[JsObject]) return None

    val iter = value.asInstanceOf[JsObject].fields.iterator
    if (!iter.hasNext) return None
    val ref = iter.next() match {
      case ("$ref", JsString(value)) => value
      case _ => return None
    }

    if (!iter.hasNext) return None
    if (iter.next()._1 != "$id") return None

    if (iter.hasNext) {
      iter.next() match {
        case ("$db", JsString(_)) =>
        case _ => return None
      }
    }

    if (iter.hasNext) return None

    Some(ref)
  }

}
