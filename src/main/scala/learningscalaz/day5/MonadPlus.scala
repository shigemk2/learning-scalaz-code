package learningscalaz.day5

import scalaz._
import Scalaz._

object MonadPlus {
  def main(args: Array[String]): Unit = {
    // Scalaのfor構文はフィルタリングができる
    println(for {
      x <- 1 |-> 50 if x.shows contains '7'
    } yield x)
    println(List(1, 2, 3) <+> List(4, 5, 6))
    println((1 |-> 50) filter { x => x.shows contains '7' })
    println((1 |-> 50) filter { x => x.shows contains '8' })
    // println((1 |-> 50) filter { x => x.shows contains '13' })
    println((1 |-> 50) filter { x => x.shows contains "13" })
    println((1 |-> 50) filter { x => x.shows contains "51" })
  }
}
