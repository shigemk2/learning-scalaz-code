import scalaz._
import Scalaz._

object MonadPlus {
  def main(args: Array[String]): Unit = {
    // Scalaのfor構文はフィルタリングができる
    println(for {
      x <- 1 |-> 50 if x.shows contains '7'
    } yield x)
  }
}
