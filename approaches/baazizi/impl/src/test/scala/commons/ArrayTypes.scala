package commons

import parametric.typeDefinition.{ArrayType, Helper, StructuralType, UnionType}

trait ArrayTypes extends FieldTypes with BasicTypes with RecordTypes {

  val arr_null: ArrayType = ArrayType(null1, 1)
  val arr_bool: ArrayType = ArrayType(bool1, 1)
  val arr_num: ArrayType = ArrayType(num1, 1)
  val arr_str: ArrayType = ArrayType(str1, 1)

  val arr_rec_abc: ArrayType = ArrayType(in_abc, 1)
  val arr_rec_abd: ArrayType = ArrayType(in_abd, 1)

  val h = new Helper()
  val order: (StructuralType, StructuralType) => Int = h.whichOrdering("k")

  val arr_null_bool: ArrayType = ArrayType(UnionType(List(null1, bool1).sortWith(order(_, _) < 0)), 2)

}
