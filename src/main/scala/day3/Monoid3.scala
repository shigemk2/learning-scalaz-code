object Monoid3 {
  import scalaz._
  import Scalaz._

  def main(args: Array[String]): Unit = {
    println(4 * 1)
    println(1 * 9)
    println(List(1,2,3) ++ Nil)
    println(Nil ++ List(0.5, 1.5))
  }
}
