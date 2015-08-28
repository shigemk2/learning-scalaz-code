package learningscalaz.day15

import scalaz._
import Scalaz._

object ScalazArrow {
  def main(args: Array[String]): Unit = {
    // Category と Compose
    val f = (_: Int) + 1
    val g = (_: Int) * 100
    println((f >>> g)(2))
    println((f <<< g)(2))
    // Arrow、再び
    println((f *** g)(1, 2))
    println((f &&& g)(2))
  }
}
