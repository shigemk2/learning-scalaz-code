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

case class Fix[F[_]](f: F[Fix[F]])
object Fix {
  def fix(toy: CharToy[Fix[CharToy]]) = Fix[CharToy](toy)
}

sealed trait FixE[F[_], E]
object FixE {
  case class Fix[F[_], E](f: F[FixE[F, E]]) extends FixE[F, E]
  case class Throwy[F[_], E](e: E) extends FixE[F, E]

  def fix[E](toy: CharToy[FixE[CharToy, E]]): FixE[CharToy, E] =
    Fix[CharToy, E](toy)
  def throwy[F[_], E](e: E): FixE[F, E] = Throwy(e)
  def catchy[F[_]: Functor, E1, E2](ex: => FixE[F, E1])
    (f: E1 => FixE[F, E2]): FixE[F, E2] = ex match {
    case Fix(x)    => Fix[F, E2](Functor[F].map(x) {catchy(_)(f)})
    case Throwy(e) => f(e)
  }
}

object ScalazFreeMonad {
  // Free Monad
  sealed trait Toy[+A, +Next]
  case class Output[A, Next](a: A, next: Next) extends Toy[A, Next]
  case class Bell[Next](next: Next) extends Toy[Nothing, Next]
  case class Done() extends Toy[Nothing, Nothing]

  def main(args: Array[String]): Unit = {
    // CharToy
    import CharToy._
    println(output('A', done))
    println(bell(output('A', done)))

    // Fix
    import Fix._
    println(fix(output('A', fix(done))))
    println(fix(bell(fix(output('A', fix(done))))))

    // FixE
    implicit val charToyFunctor: Functor[CharToy] = new Functor[CharToy] {
      def map[A, B](fa: CharToy[A])(f: A => B): CharToy[B] = fa match {
        case o: CharOutput[A] => CharOutput(o.a, f(o.next))
        case b: CharBell[A]   => CharBell(f(b.next))
        case CharDone()       => CharDone()
      }
    }

    import FixE._
    case class IncompleteException()
    def subroutine = FixE.fix[IncompleteException](
      output('A',
        throwy[CharToy, IncompleteException](IncompleteException())))

    def program = catchy[CharToy, IncompleteException, Nothing](subroutine) { _ =>
      FixE.fix[Nothing](bell(FixE.fix[Nothing](done)))
    }
  }
}
