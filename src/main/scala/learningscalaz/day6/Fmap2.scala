package learningscalaz.day6

import scalaz._
import Scalaz._

object Fmap2 {
  def main(args: Array[String]): Unit = {
    val f = ({(_: Int) * 2} |@| {(_: Int) + 10}) {_ + _}
    println(f(3))
  }
}
