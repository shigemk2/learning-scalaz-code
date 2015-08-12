package learningscalaz.day6

import scalaz._
import Scalaz._

object Gcd {
  def main(args: Array[String]): Unit = {
    def gcd(a: Int, b: Int): Writer[List[String], Int] =
      if (b == 0) for {
        _ <- List("Finished with " + a.shows).tell
      } yield a
      else
        List(a.shows + " mod " + b.shows + " = " + (a % b).shows).tell >>= { _ => gcd(b, a % b) }

    println(gcd(8, 3).run)

    def gcdReverse(a: Int, b: Int): Writer[Vector[String], Int] =
      if (b == 0) for {
        _ <- Vector("Finished with " + a.shows).tell
      } yield a
      else for {
        result <- gcdReverse(b, a % b)
        _ <- Vector(a.shows + " mod " + b.shows + " = " + (a % b).shows).tell
      } yield result

    println(gcdReverse(8, 3).run)

    def vectorFinalCountDown(x: Int): Writer[Vector[String], Unit] = {
      import annotation.tailrec
      @tailrec def doFinalCountDown(x: Int, w: Writer[Vector[String], Unit]): Writer[Vector[String], Unit] = x match {
        case 0 => w >>= { _ => Vector("0").tell }
        case x => doFinalCountDown(x - 1, w >>= { _ =>
          Vector(x.shows).tell
        })
      }
      val t0 = System.currentTimeMillis
      val r = doFinalCountDown(x, Vector[String]().tell)
      val t1 = System.currentTimeMillis
      r >>= { _ => Vector((t1 - t0).shows + " msec").tell }
    }

    def listFinalCountDown(x: Int): Writer[List[String], Unit] = {
      import annotation.tailrec
      @tailrec def doFinalCountDown(x: Int, w: Writer[List[String], Unit]): Writer[List[String], Unit] = x match {
        case 0 => w >>= { _ => List("0").tell }
        case x => doFinalCountDown(x - 1, w >>= { _ =>
          List(x.shows).tell
        })
      }
      val t0 = System.currentTimeMillis
      val r = doFinalCountDown(x, List[String]().tell)
      val t1 = System.currentTimeMillis
      r >>= { _ => List((t1 - t0).shows + " msec").tell }
    }

    val a = vectorFinalCountDown(10000).run
    println(a._1.last)
    val b = listFinalCountDown(10000).run
    println(b._1.last)
  }
}
