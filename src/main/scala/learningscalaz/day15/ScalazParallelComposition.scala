package learningscalaz.day15

import scalaz._
import Scalaz._

object ScalazParallelComposition {
  def main(args: Array[String]): Unit = {
    // 並列合成
    val f = { (x: Int) => x + 1}
    val g = { (x: Int) => List(x, 5) }
    val h = { (x: Int) => (f(x), g(x)) }
    println(List(1, 2, 3) traverseU f)
    println(List(1, 2, 3) traverseU g)
    println(List(1, 2, 3) traverseU h)

    val text = "the cat in the hat\n sat on the mat\n".toList

    def count[A] = (a: A) => 1

    val charCount = count[Char]
    println(text traverseU charCount)

    val lineCount = (c: Char) => test(c === '\n')
    println(text traverseU lineCount)

    val wordCount2 = (c: Char) => for {
      x <- get[Boolean]
      val y = c =/= ' '
      _ <- put(y)
    } yield test(y /\ !x)

    println((text traverseU wordCount2) eval false count(_ > 0))
  }
}
