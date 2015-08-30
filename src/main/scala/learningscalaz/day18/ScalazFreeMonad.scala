package learningscalaz.day18

import scalaz._
import Scalaz._

object ScalazFreeMonad {
  // Free Monad
  sealed trait Toy[+A, +Next]
  case class Output[A, Next](a: A, next: Next) extends Toy[A, Next]
  case class Bell[Next](next: Next) extends Toy[Nothing, Next]
  case class Done() extends Toy[Nothing, Nothing]

  def main(args: Array[String]): Unit = {
    println(Output('A', Done()))
    println(Bell(Output('A', Done())))
  }
}
