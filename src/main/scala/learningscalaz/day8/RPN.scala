package learningscalaz.day8

import scalaz._
import Scalaz._

object solveRPN {
  def main(args: Array[String]): Unit = {
    def foldingFunction(list: List[Double], next: String): List[Double] = (list, next) match {
      case (x :: y :: ys, "*") => (y * x) :: ys
      case (x :: y :: ys, "+") => (y + x) :: ys
      case (x :: y :: ys, "-") => (y - x) :: ys
      case (xs, numString) => numString.toInt :: xs
    }

    println(foldingFunction(List(3, 2), "*"))
    // println(foldingFunction(Nil, "*"))
    // println(foldingFunction(Nil, "wawa"))
    // println(foldingFunction(List(3, 2), "wawa"))

    def solveRPN(s: String): Double =
      (s.split(' ').toList.foldLeft(Nil: List[Double]) {foldingFunction}).head

    println(solveRPN("10 4 3 + 2 * -"))

    println("1".parseInt.toOption)
    println("foo".parseInt.toOption)
  }
}
