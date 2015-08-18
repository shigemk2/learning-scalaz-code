package learningscalaz.day9

import scalaz._
import Scalaz._

object IdZ {
  def main(args: Array[String]): Unit = {
    println(1 + 2 + 3 |> {_.point[List]})
    println(1 + 2 + 3 |> {_ * 6})
  }
}
