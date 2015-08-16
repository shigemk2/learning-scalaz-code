package learningscalaz.day8

import scalaz._
import Scalaz._

object KleisliZ {
  def main(args: Array[String]): Unit = {
    val f = Kleisli { (x: Int) => (x + 1).some }
    val g = Kleisli { (x: Int) => (x * 100).some }
    println(f)
    println(g)

    println(4.some >>= (f <=< g))
    println(4.some >>= (f >=> g))
  }
}
