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
  }
}
