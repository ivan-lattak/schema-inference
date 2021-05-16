package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import com.typesafe.scalalogging.LazyLogging
import play.api.libs.json.{JsObject, JsString, JsValue}

private case object DbRef extends LazyLogging {

  def unapply(value: JsValue): Option[String] = {
    if (!value.isInstanceOf[JsObject]) {
      return None
    }

    var ref: Option[String] = None
    var id = false
    var db = false

    for ((k, v) <- value.asInstanceOf[JsObject].fields) {
      k match {
        case "$ref" => v match {
          case JsString(value) => ref = Some(value)
          case _ => return None
        }
        case "$id" => id = true
        case "$db" => db = true
        case _ => return None
      }
    }

    if (!id || ref.isEmpty) {
      return None
    }
    if (db) {
      logger.error(s"Cross-database DBRefs are not supported! $$db property ignored: $value")
    }
    ref
  }

}
