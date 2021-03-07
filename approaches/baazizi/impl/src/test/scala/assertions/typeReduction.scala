package assertions

import commons.{arrayTypes, recordTypes, unionTypes}
import org.scalatest.FunSuite
import parametric.typeDefinition._
import parametric.typeReduction.Reduction


class typeReduction extends FunSuite with recordTypes with arrayTypes with unionTypes {

  val red = new Reduction()
  val help = new Helper()
  val (k, l) = ("k", "l")
  val (ke, le) = (help.whichOrdering(k), help.whichOrdering(l))

  /*same kind types*/

  test("Reduce: same kind, basic types") {
    assert(red.Reduce(num1, num1, ke).isInstanceOf[Numb])
  }

  test("Reduce: same kind, record types") {
    assert(red.Reduce(in_abc, in_abc, ke).isInstanceOf[RecordType])
  }

  test("Reduce: same kind, array types") {
    assert(red.Reduce(arr_null, arr_bool, ke).isInstanceOf[ArrayType])
  }


  /*different kind types*/
  test("Reduce: different kind, basic and basic") {
    assert(red.Reduce(num1, bool1, ke).isEqualTo(unionType(List(num1, bool1).sortWith(ke(_, _) < 0))))
  }
  test("Reduce: different kind,  basic and basic") {
    assert(red.Reduce(bool1, num1, ke).isEqualTo(unionType(List(num1, bool1).sortWith(ke(_, _) < 0))))
  }


  test("Reduce: different kind, basic and record") {
    assert(red.Reduce(num1, in_abc, ke).isEqualTo(unionType(List(num1, in_abc))))
  }
  test("Reduce: different kind, record and basic") {
    assert(red.Reduce(in_abc, num1, ke).isEqualTo(unionType(List(num1, in_abc))))
  }

  test("Reduce: different kind, basic and array") {
    assert(red.Reduce(num1, arr_null, ke).isEqualTo(unionType(List(num1, arr_null))))
  }
  test("Reduce: different kind, array and basic ") {
    assert(red.Reduce(arr_null, num1, ke).isEqualTo(unionType(List(num1, arr_null))))
  }

  test("Reduce: different kind, record and array") {
    assert(red.Reduce(in_abc, arr_null, ke).isEqualTo(unionType(List(in_abc, arr_null))))
  }
  test("Reduce: different kind, array and record") {
    assert(red.Reduce(arr_null, in_abc, ke).isEqualTo(unionType(List(in_abc, arr_null))))
  }

  test("Reduce: union and structural") {
    assert(red.Reduce(unionType(List(in_abc, in_abd)), in_abc, ke).isEqualTo(unionType(List(in_abc2, in_abd))))
  }

  test("Reduce: structural and union") {
    assert(red.Reduce(in_abc, unionType(List(in_abc, in_abd)), ke).isEqualTo(unionType(List(in_abc2, in_abd))))
  }

  test("Reduce: union and empty") {
    assert(red.Reduce(unionType(List(in_abc, in_abd)), Empty(), ke).isEqualTo(unionType(List(in_abc, in_abd))))
  }

  test("Reduce: empty and union") {
    assert(red.Reduce(Empty(), unionType(List(in_abc, in_abd)), ke).isEqualTo(unionType(List(in_abc, in_abd))))
  }


  //  test("L-Reducing record types: non-empty intersection") {
  //    assert(red.Reduce(in_abc,in_abd,le).isEqualTo(res_abcd_union))
  //  }
  //
  //  test("L-Reducing record types: empty intersection") {
  //    assert(red.Reduce(in_abc,in_def,le).isEqualTo(res_abcdef_union))
  //  }


}

