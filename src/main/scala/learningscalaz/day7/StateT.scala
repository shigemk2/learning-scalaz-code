package learningscalaz.day7

import scalaz._
import Scalaz._

object StateT {
  def main(args: Array[String]): Unit = {
    type Stack = List[Int]

    val pop = State[Stack, Int] {
      case x :: xs => (xs, x)
    }

    def push(a: Int) = State[Stack, Unit] {
      case xs => (a :: xs, ())
    }

    def stackManip: State[Stack, Int] = for {
      _ <- push(3)
      a <- pop
      b <- pop
    } yield(b)

    println(stackManip(List(5, 8, 2, 1)))
  }
}
