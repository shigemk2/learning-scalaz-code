// // パラメータ多相 (parametric polymorphism) とは、ある値の型が 1つもしくは複数の (制限の無い) 型変数を含むこと
// def head[A](xs: List[A]): A = xs(0)
// println(head(1 :: 2 :: Nil))
// case class Car(make: String)
// println(head(Car("Civic") :: Car("CR-V") :: Nil))

// // 派生型多態
// // def plus[A](a1: A, a2: A): A = ???
// trait Plus[A] {
//   def plus(a2: A): A
// }
// def plus[A <: Plus[A]](a1: A, a2: A): A = a1.plus(a2)

// // アドホック多相
// trait Plus[A] {
//   def plus(a1: A, a2: A): A
// }
// def plus[A: Plus](a1: A, a2: A): A = implicitly[Plus[A]].plus(a1, a2)
