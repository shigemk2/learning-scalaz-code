package learningscalaz.day12

import scalaz._
import Scalaz._

object DataListSample {
  def main(args: Array[String]): Unit = {
    println(DList.unfoldr(10, { (x: Int) => if (x == 0) none else (x, x - 1).some }).toList)

    val res36 = unfold(10) { (x) => if (x == 0) none else (x, x - 1).some }
    println(res36.toList)
  }
}
