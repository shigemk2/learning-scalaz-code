// パラメータ多相 (parametric polymorphism) とは、ある値の型が 1つもしくは複数の (制限の無い) 型変数を含むこと
def head[A](xs: List[A]): A = xs(0)
println(head(1 :: 2 :: Nil))
case class Car(make: String)
println(head(Car("Civic") :: Car("CR-V") :: Nil))

