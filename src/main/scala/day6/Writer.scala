import scalaz._
import Scalaz._

object Writer {
  def main(args: Array[String]): Unit = {
    def isBigBang(x: Int): (Boolean, String) =
      (x > 9, "Compared gang size to 9.")
    implicit class PairOps[A](pair: (A, String)) {
      def applyLog[B](f: A => (B, String)): (B, String) = {
        val (x, log) = pair
        val (y, newlog) = f(x)
        (y, log ++ newlog)
      }
    }

    println((3, "Smallish gang.") applyLog isBigBang)
  }
}
