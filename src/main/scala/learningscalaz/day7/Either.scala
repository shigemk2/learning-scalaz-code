package learningscalaz.day7

import scalaz._
import Scalaz._

object Either {
  def main(args: Array[String]): Unit = {
    println(1.right[String])
    println("error".left[Int])

    // Scala 標準ライブラリの Either 型はそれ単体ではモナドではないため、Scalaz を使っても使わなくても flatMap メソッドを実装しない
    // println(Left[String, Int]("boom") flatMap { x => Right[String, Int](x + 1) })
    println(Left[String, Int]("boom").right flatMap { x => Right[String, Int](x + 1) })

    println("boom".left[Int] >>= { x => (x + 1).right })

    println(for {
      e1 <- "event 1 ok".right
      e2 <- "event 2 failed!".left[String]
      e3 <- "event 3 failed!".left[String]
    } yield (e1 |+| e2 |+| e3)
    )

    println("event 1 ok".right.isRight)
    println("event 1 ok".right.isLeft)
  }
}
