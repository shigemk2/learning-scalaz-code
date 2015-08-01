import scalaz._
import Scalaz._

object Ordering3 {
  def main(args: Array[String]): Unit = {
    // println(Ordering.LT |+| Ordering.GT)
    println((Ordering.LT: Ordering) |+| (Ordering.GT: Ordering))
    println((Ordering.GT: Ordering) |+| (Ordering.LT: Ordering))
    println(Monoid[Ordering].zero |+| (Ordering.LT: Ordering))
    println(Monoid[Ordering].zero |+| (Ordering.GT: Ordering))

    def lengthCompare(lhs: String, rhs: String): Ordering =
      (lhs.length ?|? rhs.length) |+| (lhs ?|? rhs)

    println(lengthCompare("zen", "ants"))
    println(lengthCompare("zen", "ant"))
    println(lengthCompare("aen", "zen"))
    println(lengthCompare("zen", "zen"))
  }
}
