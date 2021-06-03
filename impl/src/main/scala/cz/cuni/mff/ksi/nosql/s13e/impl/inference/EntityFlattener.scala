package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import com.google.common.collect.{Iterators, PeekingIterator}
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema._
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.util.OrderingUtils.{OrderingAndThen, nullsFirst}
import org.eclipse.emf.common.util.EList

import java.util.Collections
import scala.annotation.tailrec
import scala.collection.JavaConverters.collectionAsScalaIterableConverter
import scala.collection.mutable
import scala.math.Ordering.by

object EntityFlattener {

  private type JList[E] = java.util.List[E]

  private val factory = NoSQLSchemaFactory.eINSTANCE

  def flatten(schema: NoSQLSchema, entity: Entity): NoSQLSchema = {
    if (entity.isFlattened || entity.getVersions.isEmpty) return schema

    val cycleFinder = new CycleFinder()
    if (cycleFinder.containsPathFromOneVersionToAnother(entity)) {
      throw new IllegalArgumentException("Cannot flatten this entity: Flattening would create a cycle in the version graph")
    }

    val mergedVersion = entity.getVersions.asScala.reduceLeft(mergeVersions)
    entity.getVersions.clear()
    entity.getVersions.add(mergedVersion)

    val visited = cycleFinder.visited + mergedVersion
    new AfterFlattenGraphFixer(visited).fixGraph(schema)

    entity.setFlattened(true)
    schema
  }

  private def mergeVersions(left: EntityVersion, right: EntityVersion): EntityVersion = {
    left.setAdditionalCount(left.getAdditionalCount + right.getAdditionalCount)
    left.getAggregates.addAll(right.getAggregates) // this correctly resets the aggregates' targets

    val combinedProperties = mergePropertyLists(left.getProperties, right.getProperties)
    left.getProperties.clear()
    left.getProperties.addAll(combinedProperties)
    left
  }

  private def mergePropertyLists(leftList: JList[Property], rightList: JList[Property]): JList[Property] =
    new SortedListMerger(leftList, rightList) withConflictResolver { (left, right) =>
      SchemaOrderings.Property.byName.compare(left.peek(), right.peek()) match {
        case c if c < 0 =>
          val leftProp = left.next
          leftProp.setOptional(true)
          leftProp
        case c if c > 0 =>
          val rightProp = right.next
          rightProp.setOptional(true)
          rightProp
        case _ => mergeProperties(left.next, right.next)
      }
    } withTailModifier { p =>
      p.setOptional(true)
      p
    } merge()

  private def mergeProperties(left: Property, right: Property): Property = {
    left.setOptional(left.isOptional || right.isOptional)
    left.setType(mergeTypes(left.getType, right.getType))
    left
  }

  private def mergeTypes(left: Type, right: Type): Type = (left, right) match {
    case (_, _: UnknownType) => left
    case (_: UnknownType, _) => right
    case _ => fromList(mergeTypeLists(toList(left), toList(right)))
  }

  private def toList(`type`: Type): JList[SingleType] = `type` match {
    case unionType: UnionType => unionType.getTypes
    case singleType: SingleType => Collections.singletonList(singleType)
    case _ => throw new IllegalArgumentException("Unexpected unknown type")
  }

  private def fromList(types: JList[SingleType]): Type = types.size() match {
    case 0 => throw new IllegalArgumentException("Merged list should not be empty")
    case 1 => types.get(0)
    case _ =>
      val union = factory.createUnionType()
      union.getTypes.addAll(types)
      union
  }

  private def mergeTypeLists(leftList: JList[SingleType], rightList: JList[SingleType]): JList[SingleType] =
    new SortedListMerger(leftList, rightList) withConflictResolver { (left, right) =>
      (left.peek(), right.peek()) match {
        case (leftArray: Array, rightArray: Array) =>
          left.next()
          right.next()
          leftArray.setElementType(mergeTypes(leftArray.getElementType, rightArray.getElementType))
          leftArray
        case (leftType, rightType) => SchemaOrderings.Type.default.compare(leftType, rightType) match {
          case c if c < 0 => left.next()
          case c if c > 0 => right.next()
          case _ =>
            left.next()
            right.next()
            rightType match {
              case aggregate: Aggregate => unregister(aggregate)
              case _ => // do nothing
            }
            leftType
        }
      }
    } merge()

  private def unregister(aggregate: Aggregate): Unit = {
    val target = aggregate.getTarget
    target.getAggregates.remove(aggregate)
    target.setAdditionalCount(target.getAdditionalCount + 1)
  }

  private final class SortedListMerger[T](leftList: JList[T], rightList: JList[T]) {

    private type ConflictResolver = (PeekingIterator[T], PeekingIterator[T]) => T

    private var _conflictResolver: Option[ConflictResolver] = None
    private var _tailModifier: T => T = identity

    def withConflictResolver(conflictResolver: ConflictResolver): this.type = {
      this._conflictResolver = Some(conflictResolver)
      this
    }

    def withTailModifier(tailModifier: T => T): this.type = {
      this._tailModifier = tailModifier
      this
    }

    def merge(): JList[T] = {
      val conflictResolver = _conflictResolver.getOrElse(throw new IllegalStateException("No conflict resolver"))

      val left = Iterators.peekingIterator(leftList.iterator)
      val right = Iterators.peekingIterator(rightList.iterator)
      val result = new java.util.ArrayList[T]

      while (left.hasNext || right.hasNext) {
        (left.hasNext, right.hasNext) match {
          case (true, false) => left.forEachRemaining(e => result.add(_tailModifier(e)))
          case (false, true) => right.forEachRemaining(e => result.add(_tailModifier(e)))
          case _ => result.add(conflictResolver(left, right))
        }
      }

      result
    }

  }

  private object SchemaOrderings {

    private type JIterator[E] = java.util.Iterator[E]

    private val entity: Ordering[Entity] = by(_.getName)

    object Version {
      private val bySize: Ordering[EntityVersion] = by(_.getProperties.size())
      val default: Ordering[EntityVersion] = bySize.andThenBy(_.getProperties)(Property.propertyList.compare) // reference compare method to create new Ordering, propertyList is not initialized yet
    }

    object Property {
      val byName: Ordering[Property] = by(_.getName)
      private val byOptional: Ordering[Property] = by(_.isOptional)
      private val byType: Ordering[Property] = by((_: Property).getType)(Type.default)
      val default: Ordering[Property] = byName.andThen(byOptional).andThen(byType)
      val propertyList: Ordering[JList[Property]] = (x, y) => {
        @tailrec
        def compareLists(left: JIterator[Property], right: JIterator[Property]): Int =
          (left.hasNext, right.hasNext) match {
            case (false, false) => 0
            case (true, true) => default.compare(left.next(), right.next()) match {
              case c if c != 0 => c
              case _ => compareLists(left, right)
            }
            case _ => throw new IllegalArgumentException("The lists are not equally long")
          }

        compareLists(x.iterator(), y.iterator())
      }
    }

    object Type {
      private val singleTypeEList: Ordering[EList[SingleType]] = (x, y) => {
        @tailrec
        def compareLists(left: JIterator[SingleType], right: JIterator[SingleType]): Int =
          (left.hasNext, right.hasNext) match {
            case (false, false) => 0
            case (false, true) => -1
            case (true, false) => 1
            case _ => default.compare(left.next(), right.next()) match {
              case c if c != 0 => c
              case _ => compareLists(left, right)
            }
          }

        compareLists(x.iterator(), y.iterator())
      }

      private def bySubtype[T <: Type]: Ordering[T] = (x, y) => {
        def order(t: Type): Int = t match {
          case _: UnknownType => 0
          case _: Boolean => 1
          case _: Number => 2
          case _: String => 3
          case _: Array => 4
          case _: Aggregate => 5
          case _: EntityReference => 6
          case _: UnionType => 7
          case _ => throw new RuntimeException("Not all cases covered")
        }

        order(x) - order(y)
      }

      private def byContents[T <: Type]: Ordering[T] = (x, y) => (x, y) match {
        case (x: Aggregate, y: Aggregate) => aggregate.compare(x, y)
        case (x: EntityReference, y: EntityReference) => entityReference.compare(x, y)
        case (x: UnionType, y: UnionType) => union.compare(x, y)
        case _ => 0 // other subtypes do not have contents
      }

      private val aggregate: Ordering[Aggregate] = by((_: Aggregate).getTarget)(Version.default)
      private val nullablePrimitive: Ordering[PrimitiveType] = nullsFirst(bySubtype)
      private val entityReference: Ordering[EntityReference] =
        by((_: EntityReference).getTarget)(entity)
          .andThenBy(_.getOriginalType)(nullablePrimitive)
      private val union: Ordering[UnionType] = by((_: UnionType).getTypes)(singleTypeEList)

      def default[T <: Type]: Ordering[T] = bySubtype[T].andThen(byContents[T])
    }
  }

  private trait VersionTraversal {

    protected val getDirectDescendants: EntityVersion => Set[EntityVersion] = memoize { version =>
      version.getProperties.asScala
        .map(_.getType)
        .flatMap(getAggregatedVersions)
        .toSet
    }

    private def memoize[I, O](f: I => O): I => O = new mutable.HashMap[I, O]() {
      override def apply(key: I): O = getOrElseUpdate(key, f(key))
    }

    private def getAggregatedVersions(`type`: Type): Set[EntityVersion] = `type` match {
      case array: Array => getAggregatedVersions(array.getElementType)
      case aggregate: Aggregate => Set(aggregate.getTarget)
      case union: UnionType => union.getTypes.asScala.flatMap(getAggregatedVersions).toSet
      case _ => Set.empty
    }

  }

  private final class CycleFinder extends VersionTraversal {

    private val _visited: mutable.Set[EntityVersion] = mutable.Set.empty

    def visited: Set[EntityVersion] = _visited.toSet

    def containsPathFromOneVersionToAnother(entity: Entity): scala.Boolean = {
      val versions = entity.getVersions.asScala.toSet
      var descendants = versions.flatMap(getDirectDescendants)

      while (descendants.nonEmpty) {
        if (descendants.exists(versions.contains)) {
          return true
        }
        _visited ++= descendants
        descendants = descendants.flatMap(getDirectDescendants)
      }

      false
    }

  }

  private final class AfterFlattenGraphFixer private(private val _visited: mutable.Set[EntityVersion])
    extends VersionTraversal {

    def this(visited: Set[EntityVersion]) = {
      this(visited.to[mutable.Set])
    }

    def fixGraph(schema: NoSQLSchema): Unit = {
      schema.getEntities.stream()
        .flatMap(_.getVersions.stream())
        .forEach(sortVersionProperties)
    }

    private def sortVersionProperties(version: EntityVersion): Unit = {
      if (_visited(version)) {
        return
      }

      getDirectDescendants(version).foreach(sortVersionProperties)
      version.getProperties.forEach(p => sortType(p.getType))
      sortEList(version.getProperties)(SchemaOrderings.Property.default)

      _visited.add(version)
    }

    private def sortType(`type`: Type): Unit = `type` match {
      case array: Array => sortType(array)
      case union: UnionType =>
        union.getTypes.forEach(sortType)
        val ord = SchemaOrderings.Type.default[SingleType]
        sortEList(union.getTypes)(ord)
        removeConsecutiveDuplicates(union.getTypes)(ord)
      case _ =>
    }

    private def sortEList[E](eList: EList[E])(implicit ord: Ordering[E]): Unit = {
      val sorted = new java.util.ArrayList(eList)
      sorted.sort(ord)
      eList.clear()
      eList.addAll(sorted)
    }

    private def removeConsecutiveDuplicates(list: JList[SingleType])(implicit ord: Ordering[SingleType]): Unit = {
      var last: Option[SingleType] = None
      val iterator = list.iterator()

      while (iterator.hasNext) {
        val current = iterator.next()
        if (last.isDefined && ord.compare(last.get, current) == 0) {
          current match {
            case a: Aggregate => unregister(a)
            case _ => // do nothing
          }
          iterator.remove()
        } else {
          last = Some(current)
        }
      }
    }

  }

}
