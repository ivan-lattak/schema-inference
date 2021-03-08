package assertions

import commons.{ArrayTypes, RecordTypes}
import org.scalatest.FunSuite
import parametric.typeDefinition.{Helper, StructuralType}
import parametric.typeReduction.Reduction


class TypeFusion extends FunSuite with RecordTypes with ArrayTypes {

  val red = new Reduction()
  val help = new Helper()
  val k = "k"
  val ke: (StructuralType, StructuralType) => Int = help.whichOrdering(k)
  //  val l = "l"
  //  val le = help.whichOrdering(l)

  test("Fuse: basic types, identical") {
    assert(red.fuse(num1, num1, ke).isEqualTo(num2))
  }


  test("Fuse: record types, identical field set") {
    assert(red.fuse(in_abc, in_abc, ke).isEqualTo(res_abc2))
  }

  test("Fuse: record types, different field sets with non-empty intersection") {
    assert(red.fuse(in_abc, in_abd, ke).isEqualTo(res_abcd))
  }

  test("Fuse: record types, different field sets with empty intersection") {
    assert(red.fuse(in_abc, in_def, ke).isEqualTo(res_abcdef))
  }

  test("Fuse: array types") {
    assert(red.fuse(arr_null, arr_bool, ke).isEqualTo(arr_null_bool))
  }


}

