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
  }
}
