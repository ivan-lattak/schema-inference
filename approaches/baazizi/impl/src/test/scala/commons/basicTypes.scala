package commons

import parametric.typeDefinition.{Bool, Null, Numb, Str}

trait basicTypes {
  val null1: Null = Null(1)
  val bool1: Bool = Bool(1)
  val num1: Numb = Numb(1)
  val str1: Str = Str(1)

  val num2: Numb = Numb(2)
}
