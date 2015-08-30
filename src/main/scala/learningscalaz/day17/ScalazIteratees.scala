package learningscalaz.day17

import scalaz._
import Scalaz._
import iteratee._
import Iteratee._
import effect._
import java.io._

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

    println((counter[Int] &= enumerate(Stream(1, 2, 3))).run)
    println((length[Int, Id] &= enumerate(Stream(1, 2, 3))).run)

    // Iteratee の合成
    def dropKeep1[E]: Iteratee[E, Option[E]] = for {
      _ <- drop[E, Id](1)
      x <- head[E, Id]
    } yield x

    def alternates[E]: Iteratee[E, Stream[E]] =
      repeatBuild[E, Option[E], Stream](dropKeep1) map {_.flatten}

    println((alternates[Int] &= enumerate(Stream.range(1, 15))).run.force)

    // Iteratees を用いたファイル入力
    println(enumReader[IO](new BufferedReader(new FileReader("./README.md"))))
  }
}
