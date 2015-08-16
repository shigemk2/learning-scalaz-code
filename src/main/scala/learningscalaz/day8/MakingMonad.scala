package learningscalaz.day8

import scalaz._
import Scalaz._

case class Prob[A](list: List[(A, Double)])
case object Prob extends ProbInstances

trait ProbInstances {
  implicit val probInstance = new Functor[Prob] {
    def map[A, B](fa: Prob[A])(f: A => B): Prob[B] =
      Prob(fa.list map { case (x, p) => (f(x), p) })
  }
  implicit def probShow[A]: Show[Prob[A]] = Show.showA
}

object MakingMonad {
  def main(args: Array[String]): Unit = {
    println(Prob((3, 0.5) :: (5, 0.25) :: (9, 0.25) :: Nil) map {-_})
  }
}
