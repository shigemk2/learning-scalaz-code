package learningscalaz.day7

import scalaz._
import Scalaz._

object StateT {
  def main(args: Array[String]): Unit = {
    type Stack = List[Int]

    val pop: State[Stack, Int] = for {
      s <- get[Stack]
      val (x :: xs) = s
      _ <- put(xs)
    } yield x

    def push(x: Int): State[Stack, Unit] = for {
      xs <- get[Stack]
      r <- put(x :: xs)
    } yield r

    def stackManip: State[Stack, Int] = for {
      _ <- push(3)
      a <- pop
      b <- pop
    } yield(b)

    println(stackManip(List(5, 8, 2, 1)))

    def stackyStack: State[Stack, Unit] = for {
      stackNow <- get
      r <- if (stackNow === List(1, 2, 3)) put(List(8, 3, 1))
      else put(List(9, 2, 1))
    } yield r

    println(stackyStack(List(1, 2, 3)))
  }
}
