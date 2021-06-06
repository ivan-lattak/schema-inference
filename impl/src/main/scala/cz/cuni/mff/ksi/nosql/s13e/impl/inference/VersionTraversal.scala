package cz.cuni.mff.ksi.nosql.s13e.impl.inference

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.{Aggregate, Array, EntityVersion, Type, UnionType}

import scala.collection.JavaConverters.collectionAsScalaIterableConverter
import scala.collection.mutable

trait VersionTraversal {

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
