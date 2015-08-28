package learningscalaz.day15

import scalaz._
import Scalaz._

object ScalazUnapply {
  def main(args: Array[String]): Unit = {
    // Unapply
    // println(Applicative[Function1[Int, Int]])
    println(Applicative[({type l[A]=Function1[Int, A]})#l])
    println(implicitly[Unapply[Applicative, Function1[Int, Int]]])
    println(implicitly[Unapply[Applicative, Int]])
    // println(implicitly[Unapply[Applicative, Any]]) // Unable to unapply type `Any` into a type constructor of kind `M[_]`
    val failedTree: Tree[Validation[String, Int]] = 1.success[String].node(
      2.success[String].leaf, "boom".failure[Int].leaf)

    println(failedTree.sequence[({type l[X]=Validation[String, X]})#l, Int])
    println(failedTree.sequenceU)
  }
}
