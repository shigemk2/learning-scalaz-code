import scalaz._
import Scalaz._

object Monad5 {
  def main(args: Array[String]): Unit = {
    println(3.some flatMap { x => (x + 1).some })
    println((none: Option[Int]) flatMap { x => (x + 1).some })

    println(3.some flatMap { x => (x + 1).some })
    println((none: Option[Int]) flatMap { x => (x + 1).some })
  }
}
