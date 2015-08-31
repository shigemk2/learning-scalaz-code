package learningscalaz.day18

import scalaz._
import Scalaz._

// error: object Suspend in object Free cannot be accessed in object scalaz.Free
// ってなるから一旦保留

// sealed trait CharToy[+Next]
// object CharToy {
//   case class CharOutput[Next](a: Char, next: Next) extends CharToy[Next]
//   case class CharBell[Next](next: Next) extends CharToy[Next]
//   case class CharDone() extends CharToy[Nothing]

//   implicit val charToyFunctor: Functor[CharToy] = new Functor[CharToy] {
//     def map[A, B](fa: CharToy[A])(f: A => B): CharToy[B] = fa match {
//         case o: CharOutput[A] => CharOutput(o.a, f(o.next))
//         case b: CharBell[A]   => CharBell(f(b.next))
//         case CharDone()       => CharDone()
//       }
//     }

//   def output(a: Char): Free[CharToy, Unit] =
//     Free.Suspend(CharOutput(a, Free.Return[CharToy, Unit](())))
//   def bell: Free[CharToy, Unit] =
//     Free.Suspend(CharBell(Free.Return[CharToy, Unit](())))
//   def done: Free[CharToy, Unit] = Free.Suspend(CharDone())
// }

object ScalazCharToy {
  def main(args: Array[String]): Unit = {
  }
}
