package learningscalaz.day8

import scalaz._
import Scalaz._

object solveRPN {
  def main(args: Array[String]): Unit = {
    def foldingFunction(list: List[Double], next: String): Option[List[Double]] = (list, next) match {
      case (x :: y :: ys, "*") => ((y * x) :: ys).point[Option]
      case (x :: y :: ys, "+") => ((y + x) :: ys).point[Option]
      case (x :: y :: ys, "-") => ((y - x) :: ys).point[Option]
      case (xs, numString) => numString.parseInt.toOption map {_ :: xs}
    }

    println(foldingFunction(List(3, 2), "*"))
    println(foldingFunction(Nil, "*"))
    println(foldingFunction(Nil, "wawa"))
    println(foldingFunction(List(3, 2), "wawa"))

    def solveRPN(s: String): Option[Double] = for {
      List(x) <- s.split(' ').toList.foldLeftM(Nil: List[Double]) {foldingFunction}
    } yield x
    println(solveRPN("10 4 3 + 2 * -"))

    println("1".parseInt.toOption)
    println("foo".parseInt.toOption)

    println(solveRPN("1 2 * 4 +"))
    println(solveRPN("1 2 * 4"))
    println(solveRPN("1 8 garbage"))
  }
}
