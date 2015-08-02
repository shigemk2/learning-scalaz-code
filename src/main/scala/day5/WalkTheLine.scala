import scalaz._
import Scalaz._

object WalkTheLine {
  def main(args: Array[String]): Unit = {
    type Birds = Int

    case class Pole(left: Birds, right: Birds) {
      def landLeft(n: Birds): Pole = copy(left = left + n)
      def landRight(n: Birds): Pole = copy(right = right + n)
    }

    println(Pole(0,0).landLeft(2))
    println(Pole(1,2).landLeft(1))
    println(Pole(1,2).landLeft(-1))

    // chain
    println(Pole(0,0).landLeft(1).landRight(1).landLeft(2))
    println(Pole(0,0).landLeft(1).landRight(4).landLeft(-1).landRight(-2))
  }
}
