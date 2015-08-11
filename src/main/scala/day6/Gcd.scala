import scalaz._
import Scalaz._

object Gcd {
  def main(args: Array[String]): Unit = {
    def gcd(a: Int, b: Int): Writer[List[String], Int] =
      if (b == 0) for {
        _ <- List("Finished with " + a.shows).tell
      } yield a
      else
        List(a.shows + " mod " + b.shows + " = " + (a % b).shows).tell >>= { _ => gcd(b, a % b) }

    println(gcd(8, 3).run)
  }
}
