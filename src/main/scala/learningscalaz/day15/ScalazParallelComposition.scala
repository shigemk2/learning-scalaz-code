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
  }
}
