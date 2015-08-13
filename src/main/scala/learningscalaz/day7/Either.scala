package learningscalaz.day7

import scalaz._
import Scalaz._

object Either {
  def main(args: Array[String]): Unit = {
    println(1.right[String])
    println("error".left[Int])

    // Scala 標準ライブラリの Either 型はそれ単体ではモナドではないため、Scalaz を使っても使わなくても flatMap メソッドを実装しない
    // println(Left[String, Int]("boom") flatMap { x => Right[String, Int](x + 1) })
  }
}
