package learningscalaz.day12

import scalaz._
import Scalaz._

object MonoidalApplicatives {
  def main(args: Array[String]): Unit = {
    println(Monoid[Int].applicative.ap2(1, 1)(0))
    println(Monoid[List[Int]].applicative.ap2(List(1), List(1))(Nil))

    println(Applicative[List].product[Option])
    println(Applicative[List].product[Option].point(1))
    println(Applicative[List].product[Option].point(2))

    println(((List(1), 1.some) |@| (List(1), 1.some)) {_ |+| _})
    println(((List(3), 4.some) |@| (List(9), 1.some)) {_ |+| _})
    println(((List(1), 1.success[String]) |@| (List(1), "boom".failure[Int])) {_ |+| _})

    println(Applicative[List].compose[Option])
    println(Applicative[List].compose[Option].point(1))
    println(Applicative[List].compose[Option].point(Some(1)))
    println(Applicative[List].compose[Option].point(List(1, 2, 3)))
  }
}
