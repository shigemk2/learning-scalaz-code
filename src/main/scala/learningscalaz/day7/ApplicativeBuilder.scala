package learningscalaz.day7

import scalaz._
import Scalaz._

object ApplicativeBuilder {
  def main(args: Array[String]): Unit = {
    println((3.some |@| 5.some) {_ + _})

    val f = ({(_: Int) * 2} |@| {(_: Int) + 10}) {_ + _}
    println(f(3))
  }
}
