package learningscalaz.day10

import scalaz._
import Scalaz._

object StateReader {
  def main(args: Array[String]): Unit = {
    def myName(step: String): Reader[String, String] = Reader { step + ", I am " + _}

    def localExample: Reader[String, (String, String, String)] = for {
      a <- myName("First")
      b <- myName("Second") >=> Reader { _ + "dy" }
      c <- myName("Third")
    } yield (a, b, c)

    println(localExample("Fred"))
  }
}
