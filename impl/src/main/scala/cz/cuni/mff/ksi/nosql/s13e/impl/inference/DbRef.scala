package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import com.typesafe.scalalogging.LazyLogging
import play.api.libs.json.{JsObject, JsString, JsValue}

private case object DbRef extends LazyLogging {

  private def next[T](iter: Iterator[T]): Option[T] = if (iter.hasNext) Some(iter.next()) else None

  def unapply(value: JsValue): Option[String] = {
    if (!value.isInstanceOf[JsObject]) return None

    val iter = value.asInstanceOf[JsObject].fields.iterator
    val ref = next(iter) match {
      case Some(("$ref", JsString(value))) => value
      case _ => return None
    }

    next(iter) match {
      case Some(("$id", _)) => // do nothing
      case _ => return None
    }

    next(iter) match {
      case Some(("$db", JsString(_))) => // do nothing
      case Some(_) => return None
      case None => // do nothing
    }

    if (iter.hasNext) None else Some(ref)
  }

}
