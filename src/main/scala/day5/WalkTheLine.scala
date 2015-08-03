import scalaz._
import Scalaz._

object WalkTheLine {
  def main(args: Array[String]): Unit = {
    type Birds = Int

    case class Pole(left: Birds, right: Birds) {
      def landLeft(n: Birds): Option[Pole] =
        if (math.abs((left + n) - right) < 4) copy(left = left + n).some
        else none
      def landRight(n: Birds): Option[Pole] =
        if (math.abs(left - (right + n)) < 4) copy(right = right + n).some
        else none
    }

    println(Pole(0,0).landLeft(2))
    println(Pole(0,3).landLeft(10))

    // chain
    println(Pole(0, 0).landRight(1) flatMap {_.landLeft(2)})
    println((none: Option[Pole]) flatMap {_.landLeft(2)})
    println(Monad[Option].point(Pole(0, 0)) flatMap {_.landRight(2)} flatMap {_.landLeft(2)} flatMap {_.landRight(2)})

    println(Monad[Option].point(Pole(0, 0)) >>= {_.landRight(2)} >>= {_.landLeft(2)} >>= {_.landRight(2)})
    println(Monad[Option].point(Pole(0, 0)) >>= {_.landLeft(1)} >>= {_.landRight(4)} >>= {_.landLeft(-1)} >>= {_.landRight(-2)})
  }
}
