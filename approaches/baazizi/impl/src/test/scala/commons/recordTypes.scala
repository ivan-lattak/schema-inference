package commons

import parametric.typeDefinition.RecordType

trait recordTypes extends fieldTypes {
  val in_abc: RecordType = RecordType(List(a1, b1, c1).sorted, 1)
  val in_abc2: RecordType = RecordType(List(a1, b1, c1).sorted, 2)

  val in_abd: RecordType = RecordType(List(a1, b1, d1).sorted, 1)
  val in_def: RecordType = RecordType(List(d1, e1, f1).sorted, 1)

  val res_abc2: RecordType = RecordType(List(a2, b2, c2).sorted, 2)
  val res_abcd: RecordType = RecordType(List(a2, b2, c1, d1).sorted, 2)
  val res_abcdef: RecordType = RecordType(List(a1, b1, c1, d1, e1, f1).sorted, 2)


}
