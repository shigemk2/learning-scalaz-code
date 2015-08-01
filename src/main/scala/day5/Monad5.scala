import scalaz._
import Scalaz._

object Monad5 {
  def main(args: Array[String]): Unit = {
    // bind
    println(3.some flatMap { x => (x + 1).some })
    println((none: Option[Int]) flatMap { x => (x + 1).some })

    println(3.some flatMap { x => (x + 1).some })
    println((none: Option[Int]) flatMap { x => (x + 1).some })

    // monad
    println(Monad[Option].point("WHAT"))
    println(9.some flatMap { x => Monad[Option].point(x * 10) })
    println((none: Option[Int]) flatMap { x => Monad[Option].point(x * 10) })
  }
}
