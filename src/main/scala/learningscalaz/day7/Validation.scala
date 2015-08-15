package learningscalaz.day7

import scalaz._
import Scalaz._

object Validation {
  def main(args: Array[String]): Unit = {
    println("event 1 ok".success[String])
    println("event 1 failed!".failure[String])
    println(("event 1 ok".success[String] |@| "event 2 failed!".failure[String] |@| "event 3 failed!".failure[String]) {_ + _ + _})

    println(1.wrapNel)

    println("event 1 ok".successNel[String])
    println("event 1 failed!".failureNel[String])
    println(("event 1 ok".successNel[String] |@| "event 2 failed!".failureNel[String] |@| "event 3 failed!".failureNel[String]) {_ + _ + _})

  }
}
