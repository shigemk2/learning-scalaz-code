package learningscalaz.day12

import scalaz._
import Scalaz._

object DataListSample {
  def main(args: Array[String]): Unit = {
    val res35 = DList.unfoldr(10, { (x: Int) => if (x == 0) none else (x, x - 1).some })
    println(res35.toList)

    val res36 = unfold(10) { (x) => if (x == 0) none else (x, x - 1).some }
    println(res36.toList)

    def minimumS[A: Order](stream: Stream[A]) = stream match {
      case x #:: xs => xs.foldLeft(x) {_ min _}
    }

    def deleteS[A: Equal](y: A, stream: Stream[A]): Stream[A] = (y, stream) match {
      case (_, Stream()) => Stream()
      case (y, x #:: xs) =>
        if (y === x) xs
        else x #:: deleteS(y, xs)
    }

    def delmin[A: Order](stream: Stream[A]): Option[(A, Stream[A])] = stream match {
      case Stream() => none
      case xs =>
        val y = minimumS(xs)
        (y, deleteS(y, xs)).some
    }

    def ssort[A: Order](stream: Stream[A]): Stream[A] = unfold(stream){delmin[A]}

    println(ssort(Stream(1, 3, 4, 2)).toList)
  }
}
