package commons

import parametric.typeDefinition.unionType

trait unionTypes extends recordTypes {

  val res_abcd_union: unionType = unionType(List(in_abc, in_abd))
  val res_abcdef_union: unionType = unionType(List(in_abc, in_def))


}
