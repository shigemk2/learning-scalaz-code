import scalaz._
import Scalaz._

object Banana {
  def main(args: Array[String]): Unit = {
    type Birds = Int

    case class Pole(left: Birds, right: Birds) {
      def landLeft(n: Birds): Option[Pole] =
        if (math.abs((left + n) - right) < 4) copy(left = left + n).some
        else none
      def landRight(n: Birds): Option[Pole] =
        if (math.abs(left - (right + n)) < 4) copy(right = right + n).some
        else none
      def banana: Option[Pole] = none
    }

    println(Monad[Option].point(Pole(0, 0)) >>= {_.landLeft(1)} >>= {_.banana} >>= {_.landRight(1)})

    println((none: Option[Int]) >> 3.some)

    println(3.some >> 4.some)
    println(3.some >> (none: Option[Int]))

    println(Monad[Option].point(Pole(0, 0)).>>=({_.landLeft(1)}).>>(none: Option[Pole]).>>=({_.landRight(1)}))
    println(Monad[Option].point(Pole(0, 0)).>>=({_.landLeft(1)}).>>(none: Option[Pole]).>>=({_.landRight(1)}))
    println((Monad[Option].point(Pole(0, 0)) >>= {_.landLeft(1)}) >> (none: Option[Pole]) >>= {_.landRight(1)})

    println(3.some >>= { x => "!".some >>= { y => (x.shows + y).some } })
    println(3.some >>= { x => (none: Option[String]) >>= { y => (x.shows + y).some } })
    println((none: Option[Int]) >>= { x => "!".some >>= { y => (x.shows + y).some } })
    println(3.some >>= { x => "!".some >>= { y => (none: Option[String]) } })
    println(for {
         x <- 3.some
         y <- "!".some
       } yield (x.shows + y))
  }
}
