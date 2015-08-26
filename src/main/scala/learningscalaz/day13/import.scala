package learningscalaz.day13

import scalaz._
import Scalaz._

object Import {
  def main(args: Array[String]): Unit = {
    // import scalaz._
    println(scalaz.Monad[scalaz.Id.Id])
  }
}
