package learningscalaz.day9

import scalaz._
import Scalaz._

object ZipperZ {
  def main(args: Array[String]): Unit = {
    println(Stream(1, 2, 3, 4))
    println(Stream(1, 2, 3, 4).toZipper)

    println(Stream(1, 2, 3, 4).toZipper >>= {_.next})
    println(Stream(1, 2, 3, 4).toZipper >>= {_.next} >>= {_.next})
    println(Stream(1, 2, 3, 4).toZipper >>= {_.next} >>= {_.next} >>= {_.previous})

    val a = Stream(1, 2, 3, 4).toZipper >>= {_.next} >>= {_.next} >>= {_.modify {_ => 7 }.some}
    // val a = Stream(1, 2, 3, 4).toZipper >>= {_.next} >>= {_.next} >>= {_.modify {_ >= 7 }.some}
    println(a)
    println(a.get.toStream.toList)

    println(for {
      z <- Stream(1, 2, 3, 4).toZipper
      n1 <- z.next
      n2 <- n1.next
    } yield { n2.modify {_ => 7} })
  }
}
