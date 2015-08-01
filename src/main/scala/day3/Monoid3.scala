object Monoid3 {
  import scalaz._
  import Scalaz._

  def main(args: Array[String]): Unit = {
    println(4 * 1)
    println(1 * 9)
    println(List(1,2,3) ++ Nil)
    println(Nil ++ List(0.5, 1.5))

    println((3 * 2) * (8 * 5) assert_=== 3 * (2 * (8 * 5)))
    println(List("la") ++ (List("di") ++ List("da")) assert_=== (List("la") ++ List("di")) ++ List("da"))

    println(Monoid[List[Int]].zero)
    println(Monoid[String].zero)
  }
}

object Semigroup3 {
  import scalaz._
  import Scalaz._

  def main(args: Array[String]): Unit = {
    println(List(1,2,3) mappend List(4,5,6))
    println("one" mappend "two")

    println(List(1,2,3) |+| List(4,5,6))
    println("one" |+| "two")
  }
}
