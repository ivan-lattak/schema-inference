package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalEntity.{MutableVersionMap, VersionMap}
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalEntityVersion.PropertiesOrdering
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.{EmptyInternalNoSqlSchema, InternalEntity, InternalEntityVersion, InternalNoSqlSchema}

import scala.annotation.tailrec
import scala.collection.immutable.{SortedSet, TreeSet}
import scala.collection.mutable

private case object SchemaFolder extends ((InternalNoSqlSchema, InternalNoSqlSchema) => InternalNoSqlSchema) {

  override def apply(left: InternalNoSqlSchema, right: InternalNoSqlSchema): InternalNoSqlSchema =
    (left, right) match {
      case (_, EmptyInternalNoSqlSchema) => left
      case (EmptyInternalNoSqlSchema, _) => right
      case _ => InternalNoSqlSchema(None, mergeEntitySets(left.entities, right.entities))
    }


  private def mergeEntitySets(left: SortedSet[InternalEntity],
                              right: SortedSet[InternalEntity]): SortedSet[InternalEntity] =
    TreeSet(mergeEntityLists(left.toList, right.toList): _*)(Ordering.by(_.name))

  /**
   * @param left  sorted
   * @param right sorted
   * @param acc   reverse-sorted accumulator, each element smaller than elements of left or right
   * @return merged sorted list
   */
  @tailrec
  private def mergeEntityLists(left: List[InternalEntity],
                               right: List[InternalEntity],
                               acc: List[InternalEntity] = Nil): List[InternalEntity] =
    (left, right) match {
      case (_, Nil) => acc reverse_::: left
      case (Nil, _) => acc reverse_::: right
      case (lh :: lt, rh :: rt) => lh.name.compare(rh.name) match {
        case c if c < 0 => mergeEntityLists(lt, right, lh :: acc)
        case c if c > 0 => mergeEntityLists(left, rt, rh :: acc)
        case _ => mergeEntityLists(lt, rt, mergeEntities(lh, rh) :: acc)
      }
    }

  private def mergeEntities(left: InternalEntity, right: InternalEntity): InternalEntity =
    if (left.name != right.name) throw new RuntimeException("Merging entities with different names") else
      InternalEntity(left.name, left.root || right.root, mergeVersionMaps(left.versions, right.versions))

  private def mergeVersionMaps(left: VersionMap, right: VersionMap): MutableVersionMap =
    mutable.TreeMap(mergeVersionLists(left.keys.toList, right.keys.toList).map(v => (v, v)): _*)(PropertiesOrdering)

  /**
   * @param left  sorted
   * @param right sorted
   * @param acc   reverse-sorted accumulator, each element smaller than elements of left or right
   * @return merged sorted list
   */
  @tailrec
  private def mergeVersionLists(left: List[InternalEntityVersion],
                                right: List[InternalEntityVersion],
                                acc: List[InternalEntityVersion] = Nil): List[InternalEntityVersion] =
    (left, right) match {
      case (_, Nil) => acc reverse_::: left
      case (Nil, _) => acc reverse_::: right
      case (lh :: lt, rh :: rt) => PropertiesOrdering.compare(lh, rh) match {
        case c if c < 0 => mergeVersionLists(lt, right, lh :: acc)
        case c if c > 0 => mergeVersionLists(left, rt, rh :: acc)
        case _ => mergeVersionLists(lt, rt, lh.mergeAggregatesFrom(rh) :: acc)
      }
    }

}
