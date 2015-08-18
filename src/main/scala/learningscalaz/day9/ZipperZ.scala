package learningscalaz.day9

import scalaz._
import Scalaz._

object ZipperZ {
  def main(args: Array[String]): Unit = {
    println(Stream(1, 2, 3, 4))
    println(Stream(1, 2, 3, 4).toZipper)

    println(Stream(1, 2, 3, 4).toZipper >>= {_.next})
    println(Stream(1, 2, 3, 4).toZipper >>= {_.next} >>= {_.next})
    println(Stream(1, 2, 3, 4).toZipper >>= {_.next} >>= {_.next} >>= {_.previous})
  }
}
