package learningscalaz.day7

import scalaz._
import Scalaz._

object Validation {
  def main(args: Array[String]): Unit = {
    println("event 1 ok".success[String])
    println("event 1 failed!".failure[String])
  }
}
