package learningscalaz.day18

import scalaz._
import Scalaz._
import Free._

object ScalazStackless {
  def main(args: Array[String]): Unit = {
    // トランポリンを使う
    // どんなプログラムでもスタックを使わないものに変換することができる
    def even[A](ns: List[A]): Trampoline[Boolean] =
      ns match {
        case Nil => return_(true)
        case x :: xs => suspend(odd(xs))
      }
    def odd[A](ns: List[A]): Trampoline[Boolean] =
      ns match {
        case Nil => return_(false)
        case x :: xs => suspend(even(xs))
      }
    println(even(List(1,2,3)).run)
    println(even(0 |-> 3000).run)
    println(even(Nil).run)
    println(odd(List(1,2,3)).run)
    println(odd(List(2,2,2)).run)
    println(odd(Nil).run)
    println(odd(0 |-> 3000).run)
    // Free を用いたリスト
    // error: object Suspend in object Free cannot be accessed in object scalaz.Free
    // ってなるから一旦保留
    type FreeMonoid[A] = Free[({type λ[+α] = (A,α)})#λ, Unit]
    // def cons[A](a: A): FreeMonoid[A] = Free.Suspend[({type λ[+α] = (A,α)})#λ, Unit]((a, Free.Return[({type λ[+α] = (A,α)})#λ, Unit](())))
    // println(cons(1))
    // println(cons(1) >>= {_ => cons(2)})

    def toList[A](list: FreeMonoid[A]): List[A] =
      list.resume.fold(
        { case (x: A, xs: FreeMonoid[A]) => x :: toList(xs) },
        { _ => Nil })

  }
}
