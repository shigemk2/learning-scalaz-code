package learningscalaz.day3

// scala> :k Int
// scala.Int's kind is A

// scala> :k -v Option
// scala.Option's kind is F[+A]
// * -(+)-> *
// This is a type constructor: a 1st-order-kinded type.

// scala> :k -v Either
// scala.util.Either's kind is F[+A1,+A2]
// * -(+)-> * -(+)-> *
// This is a type constructor: a 1st-order-kinded type.

// scala> :k -v Equal
// scalaz.Equal's kind is F[A]
// * -> *
// This is a type constructor: a 1st-order-kinded type.

// scala> :k -v Functor
// scalaz.Functor's kind is X[F[A]]
// (* -> *) -> *
// This is a type constructor that takes type constructor(s): a higher-kinded type.
object Kind {
  import scalaz._
  import Scalaz._

  def main(args: Array[String]): Unit = {
    println (List(1,2,3).shows)
    // println (Functor[List[Int]].lift((_: Int) + 2))
    println (Functor[List].lift((_: Int) + 2))
  }
}
