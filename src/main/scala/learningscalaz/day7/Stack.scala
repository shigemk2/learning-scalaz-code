package learningscalaz.day7

import scalaz._
import Scalaz._

object Stack {
  def main(args: Array[String]): Unit = {
    type Stack = List[Int]

    def pop(stack: Stack): (Int, Stack) = stack match {
      case x :: xs => (x, xs)
    }

    def push(a: Int, stack: Stack): (Unit, Stack) = ((), a :: stack)

    def stackManip(stack: Stack): (Int, Stack) = {
      val (_, newStack1) = push(3, stack)
      val (a, newStack2) = pop(newStack1)
      pop(newStack2)
    }

    println(stackManip(List(5, 8, 2, 1)))
  }
}
