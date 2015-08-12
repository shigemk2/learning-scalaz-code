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

    def gcdReverse(a: Int, b: Int): Writer[Vector[String], Int] =
      if (b == 0) for {
        _ <- Vector("Finished with " + a.shows).tell
      } yield a
      else for {
        result <- gcdReverse(b, a % b)
        _ <- Vector(a.shows + " mod " + b.shows + " = " + (a % b).shows).tell
      } yield result

    println(gcdReverse(8, 3).run)
  }
}
