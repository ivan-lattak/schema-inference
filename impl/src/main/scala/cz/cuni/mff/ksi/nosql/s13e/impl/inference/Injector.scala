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
        value.map(construct(typeName, _, root = false)).fold(InternalUnknownType)(TypeFolder))
      case JsObject(underlying) =>
        val singularTypeName = singularize(typeName)
        val entity = entities.getOrElseUpdate(singularTypeName, InternalEntity(singularTypeName, root))
        val properties = underlying map { case (k, v) => (k, InternalProperty(k, construct(k, v, root = false))) }
        InternalAggregate(entity.getOrAddIdenticalVersion(properties))
      case _ => throw new RuntimeException(s"Unexpected JSON type in raw schema: $jsValue") // null, boolean and number are unexpected
    }

    def finish: InternalNoSqlSchema = new InternalNoSqlSchema(TreeSet(entities.values.toSeq: _*)(Ordering.by(_.name)))

    private def singularize(typeName: String): String = typeName.stripSuffix("s") // TODO better singularization

  }

  override def apply(document: TypedDocumentImpl): InternalNoSqlSchema = {
    val builder = InternalSchemaBuilder()
    builder.construct(document.typeName, document.document, root = true)
    builder.finish
  }

}
