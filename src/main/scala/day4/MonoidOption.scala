import scalaz._
import Scalaz._

object MonoidOption {
  def main(args: Array[String]): Unit = {
    println((none: Option[String]) |+| "andy".some)
    println((Ordering.LT: Ordering).some |+| none)

    println(Tags.First('a'.some) |+| Tags.First('b'.some))
    println(Tags.First(none: Option[Char]) |+| Tags.First('b'.some))
    println(Tags.First('a'.some) |+| Tags.First(none: Option[Char]))
  }
}
