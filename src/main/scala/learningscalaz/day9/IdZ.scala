package learningscalaz.day9

import scalaz._
import Scalaz._

object IdZ {
  def main(args: Array[String]): Unit = {
    println(1 + 2 + 3 |> {_.point[List]})
    println(1 + 2 + 3 |> {_ * 6})

    println(1 visit { case x@(2|3) => List(x * 2) })
    println(2 visit { case x@(2|3) => List(x * 2) })
    println(1 visit { case x@(1|3) => List(x * 2) })
    println(3 visit { case x@(1|3) => List(x * 2) })
    println(9 visit { case x@(1|3) => List(x * 2) })
  }
}
