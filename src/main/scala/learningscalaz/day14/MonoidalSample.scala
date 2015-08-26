package learningscalaz.day14

import scalaz._
import Scalaz._

object Monoidal {
  def apply[A: Monoid](f: A => A): Kleisli[({type λ[+α]=A})#λ, A, A] =
    Kleisli[({type λ[+α]=A})#λ, A, A](f)
}

object MonoidalSample {
  def main(args: Array[String]): Unit = {
    // applicative 関数
    println(Monoidal { x: Int => x + 1 })
    println(List(1, 2, 3) traverseU {_ + 1})
    val f = { (x: Int) => x + 1 }
    val g = { (x: Int) => List(x, 5) }
    val h = f &&& g
    println(List(1, 2, 3) traverseU f)
    println(List(1, 2, 3) traverseU g)
    println(List(1, 2, 3) traverseU h)
  }
}

