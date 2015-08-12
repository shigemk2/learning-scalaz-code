package learningscalaz.day6

import scalaz._
import Scalaz._

object Reader {
  // Reader モナドは値が既にあるかのようなフリをさせてくれる
  def main(args: Array[String]): Unit = {
    val addStuff: Int => Int = for {
      a <- (_: Int) * 2
      b <- (_: Int) + 10
    } yield a + b

    println(addStuff(3))
  }
}
