package learningscalaz.day12

import scalaz._
import Scalaz._

object DataListSample {
  def main(args: Array[String]): Unit = {
    println(DList.unfoldr(10, { (x: Int) => if (x == 0) none else (x, x - 1).some }).toList)
  }
}
