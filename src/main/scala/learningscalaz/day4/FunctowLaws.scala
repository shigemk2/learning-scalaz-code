package learningscalaz.day4

import scalaz._
import Scalaz._

object FunctorLaws {
  def main(args: Array[String]): Unit = {
    println(List(1,2,3) map {identity} assert_=== List(1,2,3))
    println((List(1, 2, 3) map {{(_: Int) * 3} map {(_: Int) + 1}}) assert_=== (List(1, 2, 3) map {(_: Int) * 3} map {(_: Int) + 1}))
  }
}
