package learningscalaz.day16

import scalaz._
import Scalaz._
import effect._
import ST._

object ScalazEffect {
  def main(args: Array[String]): Unit = {
    def e1[S] = for {
      x <- newVar[S](0)
      r <- x mod {_ + 99}
    } yield x

    def e2[S]: ST[S, Int] = for {
      x <- e1[S]
      r <- x.read
    } yield r

    type ForallST[A] = Forall[({type λ[S] = ST[S, A]})#λ]
    println(runST(new ForallST[Int] { def apply[S] = e2[S] }))

    // エラトステネスのふるい
    def mapM[A, S, B](xs: List[A])(f: A => ST[S, B]): ST[S, List[B]] =
      Monad[({type λ[α] = ST[S, α]})#λ].sequence(xs map f)

    def sieve[S](n: Int) = for {
      arr <- newArr[S, Boolean](n + 1, true)
      _ <- arr.write(0, false)
      _ <- arr.write(1, false)
      val nsq = (math.sqrt(n.toDouble).toInt + 1)
      _ <- mapM (1 |-> nsq) { i =>
        for {
          x <- arr.read(i)
          _ <-
          if (x) mapM (i * i |--> (i, n)) { j => arr.write(j, false) }
          else returnST[S, List[Boolean]] {Nil}
        } yield ()
      }
      r <- arr.freeze
    } yield r

    // type ForallST[A] = Forall[({type λ[S] = ST[S, A]})#λ]

    def prime(n: Int) =
      runST(new ForallST[ImmutableArray[Boolean]] { def apply[S] = sieve[S](n) }).toArray.
        zipWithIndex collect { case (true, x) => x }

    println(prime(50).toList)
    // Fedora20 Thinkpad X201環境だとjava.lang.ArrayIndexOutOfBoundsException
    // println(prime(1000).toList)
  }
}
