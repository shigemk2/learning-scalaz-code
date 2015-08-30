package learningscalaz.day18

import scalaz._
import Scalaz._

sealed trait CharToy[+Next]
object CharToy {
  case class CharOutput[Next](a: Char, next: Next) extends CharToy[Next]
  case class CharBell[Next](next: Next) extends CharToy[Next]
  case class CharDone() extends CharToy[Nothing]

  def output[Next](a: Char, next: Next): CharToy[Next] = CharOutput(a, next)
  def bell[Next](next: Next): CharToy[Next] = CharBell(next)
  def done: CharToy[Nothing] = CharDone()
}

object ScalazFreeMonad {
  // Free Monad
  // sealed trait Toy[+A, +Next]
  // case class Output[A, Next](a: A, next: Next) extends Toy[A, Next]
  // case class Bell[Next](next: Next) extends Toy[Nothing, Next]
  // case class Done() extends Toy[Nothing, Nothing]

  def main(args: Array[String]): Unit = {
    // CharToy
    import CharToy._
    println(output('A', done))
    println(bell(output('A', done)))
  }
}
