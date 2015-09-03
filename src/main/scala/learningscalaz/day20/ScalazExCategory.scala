package learningscalaz.day20

import scalaz._
import Scalaz._

object ScalazExCategory {
  def main(args: Array[String]): Unit = {
    // Intとの加算
    println(10 |+| Monoid[Int].zero)
    // Intの乗算と1
    println(Tags.Multiplication(10) |+| Monoid[Int @@ Tags.Multiplication].zero)
  }
}
