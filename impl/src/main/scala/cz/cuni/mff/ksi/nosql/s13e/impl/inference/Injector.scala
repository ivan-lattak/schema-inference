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
      case JsString(actualType) => actualType match { // these are raw schemas, the actual type is encoded in the string
        case RawSchema.nullType => InternalUnknownType
        case RawSchema.booleanType => InternalBoolean
        case RawSchema.numberType => InternalNumber
        case RawSchema.stringType => InternalString
        case RawSchema.ReferenceType(collectionName) => InternalEntityReference(singularize(collectionName))
      }
      case JsArray(value) => InternalArray(
        value.map(construct(singularize(typeName), _, root = false)).fold(InternalUnknownType)(TypeFolder))
      case JsObject(underlying) =>
        val entity = entities.getOrElseUpdate(typeName, InternalEntity(typeName))
        val properties = underlying map { case (k, v) => (k, InternalProperty(k, construct(k, v, root = false))) }
        val res = InternalAggregate(entity.getOrAddIdenticalVersion(properties, root))
        if (root) res.unregister() else res
      case _ => throw new IllegalArgumentException(s"Unexpected JSON type in raw schema: $jsValue") // null, boolean and number are unexpected
    }

    def finish: InternalNoSqlSchema = new InternalNoSqlSchema(TreeSet(entities.values.toSeq: _*)(Ordering.by(_.name)))

  }

  override def apply(document: TypedDocumentImpl): InternalNoSqlSchema = {
    val builder = InternalSchemaBuilder()
    builder.construct(singularize(document.typeName), document.document, root = true)
    builder.finish
  }

  private def singularize(typeName: String): String = typeName.stripSuffix("s") // TODO better singularization

}
