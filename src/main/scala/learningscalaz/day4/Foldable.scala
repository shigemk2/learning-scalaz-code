package learningscalaz.day4

import scalaz._
import Scalaz._

object Foldable {
  def main(args: Array[String]): Unit = {
    println(List(1,2,3).foldRight(1){_ * _})
    println(9.some.foldLeft(2) {_ + _})

    println(List(1,2,3) foldMap {identity})
    println(List(true, false, true, true) foldMap {Tags.Disjunction.apply})
  }
}
