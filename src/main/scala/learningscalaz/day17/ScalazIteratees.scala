package learningscalaz.day17

import scalaz._
import Scalaz._
import iteratee._
import Iteratee._

object ScalazIteratees {
  def main(args: Array[String]): Unit = {
    def counter[E]: Iteratee[E, Int] = {
      def step(acc: Int)(s: Input[E]): Iteratee[E, Int] =
        s(el = e => cont(step(acc + 1)),
          empty = cont(step(acc)),
          eof = done(acc, eofInput[E])
        )
      cont(step(0))
    }

    // println((counter[Int] &= enumerate(Stream(1, 2, 3))).run)
  }
}
