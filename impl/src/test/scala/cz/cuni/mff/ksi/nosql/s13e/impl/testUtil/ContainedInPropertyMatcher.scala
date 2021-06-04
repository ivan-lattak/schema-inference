package cz.cuni.mff.ksi.nosql.s13e.impl.testUtil

import org.scalatest.matchers.{BePropertyMatchResult, BePropertyMatcher}

object ContainedInPropertyMatcher {

  def containedIn(iterable: Traversable[String]): BePropertyMatcher[String] =
    (item: String) => new BePropertyMatchResult(iterable.exists(_ == item), s"contained in $iterable")

}
