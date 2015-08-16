package learningscalaz.day8

import scalaz._
import Scalaz._

object MakingMonad {
  def main(args: Array[String]): Unit = {
    case class Prob[A](list: List[A, Double])

    trait ProbInstance {
      implicit def probShow[A]: Show[Prob[A]] = Show.showA
    }

    case object Prob extends ProbInstance
  }
}
