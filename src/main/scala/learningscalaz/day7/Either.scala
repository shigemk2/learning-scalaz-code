package learningscalaz.day7

import scalaz._
import Scalaz._

object Either {
  def main(args: Array[String]): Unit = {
    println(1.right[String])
    println("error".left[Int])
  }
}
