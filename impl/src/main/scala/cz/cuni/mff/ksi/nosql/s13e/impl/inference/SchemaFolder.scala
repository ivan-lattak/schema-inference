package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalEntity.{MutableVersionMap, VersionMap}
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.InternalEntityVersion.PropertiesOrdering
import cz.cuni.mff.ksi.nosql.s13e.impl.inference.schema.{EmptyInternalNoSqlSchema, InternalEntity, InternalEntityVersion, InternalNoSqlSchema}

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

  private def mergeEntityLists(left: List[InternalEntity], right: List[InternalEntity]): List[InternalEntity] =
    (left, right) match {
      case (_, Nil) => left
      case (Nil, _) => right
      case (lh :: lt, rh :: rt) => lh.name.compare(rh.name) match {
        case c if c < 0 => lh :: mergeEntityLists(lt, right)
        case c if c > 0 => rh :: mergeEntityLists(left, rt)
        case _ => mergeEntities(lh, rh) :: mergeEntityLists(lt, rt)
      }
    }

  private def mergeEntities(left: InternalEntity, right: InternalEntity): InternalEntity =
    if (left.name != right.name) throw new RuntimeException("Merging entities with different names") else
      InternalEntity(left.name, left.root || right.root, mergeVersionMaps(left.versions, right.versions))

  private def mergeVersionMaps(left: VersionMap, right: VersionMap): MutableVersionMap =
    mutable.TreeMap(mergeVersionLists(left.keys.toList, right.keys.toList).map(v => (v, v)): _*)(PropertiesOrdering)

  private def mergeVersionLists(left: List[InternalEntityVersion],
                                right: List[InternalEntityVersion]): List[InternalEntityVersion] =
    (left, right) match {
      case (_, Nil) => left
      case (Nil, _) => right
      case (lh :: lt, rh :: rt) => PropertiesOrdering.compare(lh, rh) match {
        case c if c < 0 => lh :: mergeVersionLists(lt, right)
        case c if c > 0 => rh :: mergeVersionLists(left, rt)
        case _ => lh.mergeAggregatesFrom(rh) :: mergeVersionLists(lt, rt)
      }
    }

}
