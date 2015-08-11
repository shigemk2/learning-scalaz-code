import scalaz._
import Scalaz._

object For {
  def main(args: Array[String]): Unit = {
    def foo = for {
      x <- 3.some
      y <- "!".some
    } yield x.shows + y

    println(foo)
  }
}
