package learningscalaz.day21

import scalaz._
import Scalaz._
import UnionTypes._

object ScalazCoproducts {
  def main(args: Array[String]): Unit = {
    type StringOrInt = t[String]#t[Int]
    implicitly[Int ∈ StringOrInt]
    // implicitly[Byte ∈ StringOrInt]
    def size[A](a: A)(implicit ev: A ∈ StringOrInt): Int = a match {
      case i: Int => i
      case s: String => s.length
    }

    println(size(23))
    println(size("foo"))
  }
}
