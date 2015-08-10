import scalaz._
import Scalaz._

object ListMonad {
  def main(args: Array[String]): Unit = {
    println(^(List(1,2,3), List(10, 100, 100)) {_ * _})
  }
}
