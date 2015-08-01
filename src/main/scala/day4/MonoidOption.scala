import scalaz._
import Scalaz._

object MonoidOption {
  def main(args: Array[String]): Unit = {
    println((none: Option[String]) |+| "andy".some)
    println((Ordering.LT: Ordering).some |+| none)
  }
}
