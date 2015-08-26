package learningscalaz.day12

import scalaz._
import Scalaz._

object MonoidalApplicatives {
  def main(args: Array[String]): Unit = {
    // Monoidal applicatives
    println(Monoid[Int].applicative.ap2(1, 1)(0))
    println(Monoid[List[Int]].applicative.ap2(List(1), List(1))(Nil))
    // Applicative functor の組み合わせ
    println(Applicative[List].product[Option])
    println(Applicative[List].product[Option].point(1))
    println(Applicative[List].product[Option].point(2))

    println(((List(1), 1.some) |@| (List(1), 1.some)) {_ |+| _})
    println(((List(3), 4.some) |@| (List(9), 1.some)) {_ |+| _})
    println(((List(1), 1.success[String]) |@| (List(1), "boom".failure[Int])) {_ |+| _})

    println(Applicative[List].compose[Option])
    println(Applicative[List].compose[Option].point(1))
    println(Applicative[List].compose[Option].point(Some(1)))
    println(Applicative[List].compose[Option].point(List(1, 2, 3)))
    // Idiomatic traversal
    println(List(1, 2, 3) traverse { x => (x > 0) option (x + 1) })
    println(List(1, 2, 0) traverse { x => (x > 0) option (x + 1) })
    println(Monoid[Int].applicative.traverse(List(1, 2, 3)) {_ + 1})
    // 形と内容
    def contents[F[_]: Traverse, A](f: F[A]): List[A] =
      f.traverse[({type l[X]=List[A]})#l, A] {List(_)}

    println(contents(List(1, 2, 3)))
    println(contents(NonEmptyList(1, 2, 3)))
    val tree: Tree[Char] = 'P'.node('O'.leaf, 'L'.leaf)
    println(contents(tree))
    // 形と内容 2
    def shape[F[_]: Traverse, A](f: F[A]): F[Unit] =
      f traverse {_ => ((): Id[Unit])}
    println(shape(List(1, 2, 3)))
    println(shape(tree).drawTree)
    // 形と内容 3 decompose
    def decompose[F[_]: Traverse, A](f: F[A]) = (shape(f), contents(f))
    println(decompose(tree))
  }
}
