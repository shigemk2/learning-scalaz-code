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

    // これも試してみよう
    def lengthOfTwoFiles(f1: File, f2: File) = {
      val l1 = length[IoExceptionOr[Char], IO] &= enumReader[IO](new BufferedReader(new FileReader(f1)))
      val l2 = l1 &= enumReader[IO](new BufferedReader(new FileReader(f2)))
      l2.run
    }

    println(lengthOfTwoFiles(new File("./README.md"), new File("./TODO.txt")).unsafePerformIO)

    // sequenceI メソッドは readLn を EnumerateeT に変換して、%= はそれを Iteratee にチェイン
    val readLn = takeWhile[Char, List](_ != '\n') flatMap (ln => drop[Char, Id](1).map(_ => ln))
    println((readLn &= enumStream("Iteratees\nare\ncomposable".toStream)).run)
    println((collect[List[Char], List] %= readLn.sequenceI &= enumStream("Iteratees\nare\ncomposable".toStream)).run)
  }
}
