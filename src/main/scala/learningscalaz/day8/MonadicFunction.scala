package learningscalaz.day8

import scalaz._
import Scalaz._

object MonadicFunction {
  def main(args: Array[String]): Unit = {
    println((Some(9.some): Option[Option[Int]]).join)
    println((Some(none): Option[Option[Int]]).join)
    println(List(List(1, 2, 3), List(4, 5, 6)).join)
    println(9.right[String].right[String].join)
    println("boom".left[Int].right[String].join)

    println(List(1, 2, 3) filterM { x => List(true, false) })
    println(Vector(1, 2, 3) filterM { x => Vector(true, false) })

    def binSmalls(acc: Int, x: Int): Option[Int] = {
      if (x > 9) (none: Option[Int])
      else (acc + x).some
    }

    println(List(2, 8, 3, 1).foldLeftM(0) { binSmalls })
    println(List(2, 11, 3, 1).foldLeftM(0) { binSmalls })
  }
}
