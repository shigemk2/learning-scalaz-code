package learningscalaz.day8

import scalaz._
import Scalaz._

object ReaderKleisli {
  def main(args: Array[String]): Unit = {
    val addStuff: Reader[Int, Int] = for {
      a <- Reader { (_: Int) * 2 }
      b <- Reader { (_: Int) + 10 }
    } yield a + b

    println(addStuff(3))
  }
}
