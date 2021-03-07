package assertions

import commons.{arrayTypes, recordTypes}
import org.scalatest.FunSuite
import parametric.typeDefinition.{Helper, structuralType}
import parametric.typeReduction.Reduction


class typeFusion extends FunSuite with recordTypes with arrayTypes {

  val red = new Reduction()
  val help = new Helper()
  val k = "k"
  val ke: (structuralType, structuralType) => Int = help.whichOrdering(k)
  //  val l = "l"
  //  val le = help.whichOrdering(l)

  test("Fuse: basic types, identical") {
    assert(red.Fuse(num1, num1, ke).isEqualTo(num2))
  }


  test("Fuse: record types, identical field set") {
    assert(red.Fuse(in_abc, in_abc, ke).isEqualTo(res_abc2))
  }

  test("Fuse: record types, different field sets with non-empty intersection") {
    assert(red.Fuse(in_abc, in_abd, ke).isEqualTo(res_abcd))
  }

  test("Fuse: record types, different field sets with empty intersection") {
    assert(red.Fuse(in_abc, in_def, ke).isEqualTo(res_abcdef))
  }

  test("Fuse: array types") {
    assert(red.Fuse(arr_null, arr_bool, ke).isEqualTo(arr_null_bool))
  }


}

