package learningscalaz.day8

import scalaz._
import Scalaz._

sealed trait Coin
case object Heads extends Coin
case object Tails extends Coin

case class Prob[A](list: List[(A, Double)])
case object Prob extends ProbInstances

trait ProbInstances {
  def flatten[B](xs: Prob[Prob[B]]): Prob[B] = {
    def multall(innerxs: Prob[B], p: Double) =
      innerxs.list map { case (x, r) => (x, p * r) }
    Prob((xs.list map { case (innerxs, p) => multall(innerxs, p) }).flatten)
  }

  implicit val probInstance = new Functor[Prob] {
    def map[A, B](fa: Prob[A])(f: A => B): Prob[B] =
      Prob(fa.list map { case (x, p) => (f(x), p) })
  }
  implicit def probShow[A]: Show[Prob[A]] = Show.showA

  implicit val coinEqual: Equal[Coin] = Equal.equalA

  def coin: Prob[Coin] = Prob(Heads -> 0.5 :: Tails -> 0.5 :: Nil)
  def loadedCoin: Prob[Coin] = Prob(Heads -> 0.1 :: Tails -> 0.9 :: Nil)

  def flipThree: Prob[Boolean] = for {
    a <- coin
    b <- coin
    c <- loadedCoin
  } yield { List(a, b, c) all {_ === Tails} }

}


object MakingMonad {
  def main(args: Array[String]): Unit = {
    println(Prob((3, 0.5) :: (5, 0.25) :: (9, 0.25) :: Nil) map {-_})
    // println(flipThree)
  }
}
