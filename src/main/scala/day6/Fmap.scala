import scalaz._
import Scalaz._

object Fmap {
  def main(args: Array[String]): Unit = {
    val f = (_: Int) * 5
    val g = (_: Int) + 3
    println((g map f)(8))
  }
}
