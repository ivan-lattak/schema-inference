package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema._
import play.api.libs.json._

import scala.collection.immutable.TreeSet
import scala.collection.mutable

private case object Injector extends (TypedDocumentImpl => InternalNoSqlSchema) {

  private case class InternalSchemaBuilder() {

    private val entities: mutable.SortedMap[String, InternalEntity] = mutable.TreeMap.empty

    def construct(typeName: String,
                  jsValue: JsValue,
                  root: Boolean): InternalType = jsValue match {
      case JsNull => InternalUnknownType // TODO these are raw schemas => there are no primitives except strings!
      case _: JsBoolean => InternalBoolean
      case JsNumber(_) => InternalNumber
      case JsString(_) => InternalString // TODO handle Entity references encoded as strings
      case JsArray(value) => InternalArray(
        value.map(construct(typeName, _, root = false)).fold(InternalUnknownType)(TypeFolder))
      case DbRef(collectionName) => InternalEntityReference(singularize(collectionName))
      case JsObject(underlying) =>
        val singularTypeName = singularize(typeName)
        val entity = entities.getOrElseUpdate(singularTypeName, InternalEntity(singularTypeName, root))
        val properties = underlying map { case (k, v) => (k, InternalProperty(k, construct(k, v, root = false))) }
        InternalAggregate(entity.getOrAddIdenticalVersion(properties).increment)
    }

    def finish: InternalNoSqlSchema = InternalNoSqlSchema(None, TreeSet(entities.values.toSeq: _*)(Ordering.by(_.name)))

    private def singularize(typeName: String): String = typeName.stripSuffix("s") // TODO better singularization

  }

  override def apply(document: TypedDocumentImpl): InternalNoSqlSchema = {
    val builder = InternalSchemaBuilder()
    builder.construct(document.typeName, document.document, root = true)
    builder.finish
  }

}
