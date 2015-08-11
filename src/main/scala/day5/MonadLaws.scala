import scalaz._
import Scalaz._

object MonadLaws {
  def main(args: Array[String]): Unit = {
    // 左単位元
    println((Monad[Option].point(3) >>= { x => (x + 100000).some }) assert_=== 3 |> { x => (x + 100000).some })
    // 右単位元
    println(("move on up".some flatMap {Monad[Option].point(_)}) assert_=== "move on up".some)
    // 結合律
    type Birds = Int

    case class Pole(left: Birds, right: Birds) {
      def landLeft(n: Birds): Option[Pole] =
        if (math.abs((left + n) - right) < 4) copy(left = left + n).some
        else none
      def landRight(n: Birds): Option[Pole] =
        if (math.abs(left - (right + n)) < 4) copy(right = right + n).some
        else none
    }

    println(Monad[Option].point(Pole(0, 0)) >>= {_.landRight(2)} >>= {_.landLeft(2)} >>= {_.landRight(2)})
    println(Monad[Option].point(Pole(0, 0)) >>= { x =>
      x.landRight(2) >>= { y =>
        y.landLeft(2) >>= { z =>
          z.landRight(2)
    }}})
  }
}
