package learningscalaz.day12

import scalaz._
import Scalaz._

object MonoidalApplicatives {
  def main(args: Array[String]): Unit = {
    println(Monoid[Int].applicative.ap2(1, 1)(0))
    println(Monoid[List[Int]].applicative.ap2(List(1), List(1))(Nil))
  }
}
