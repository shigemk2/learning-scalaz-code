package learningscalaz.day18

import scalaz._
import Scalaz._
import typelevel._
import Typelevel._

object ScalazFunc {
  def main(args: Array[String]): Unit = {
    val f = AppFuncU { (x: Int) => x + 1 }
    val g = AppFuncU { (x: Int) => List(x, 5) }
    println((f @&&& g) traverse List(1, 2, 3))
  }
}
