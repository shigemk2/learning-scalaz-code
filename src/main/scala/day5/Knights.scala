import scalaz._
import Scalaz._

object Knights {
  def main(args: Array[String]): Unit = {
    case class KnightPos(c: Int, r: Int) {
      def move: List[KnightPos] =
        for {
          KnightPos(c2, r2) <- List(KnightPos(c + 2, r - 1), KnightPos(c + 2, r + 1),
            KnightPos(c - 2, r - 1), KnightPos(c - 2, r + 1),
            KnightPos(c + 1, r - 2), KnightPos(c + 1, r + 2),
            KnightPos(c - 1, r - 2), KnightPos(c - 1, r + 2)) if (
            ((1 |-> 8) contains c2) && ((1 |-> 8) contains r2))
        } yield KnightPos(c2, r2)
    }

    println(KnightPos(6, 2).move)
    println(KnightPos(8, 1).move)
    println(KnightPos(1, 2).move)
  }
}
