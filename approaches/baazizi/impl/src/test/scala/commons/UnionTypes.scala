package commons

import parametric.typeDefinition.UnionType

trait UnionTypes extends RecordTypes {

  val res_abcd_union: UnionType = UnionType(List(in_abc, in_abd))
  val res_abcdef_union: UnionType = UnionType(List(in_abc, in_def))


}
