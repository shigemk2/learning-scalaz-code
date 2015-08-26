package learningscalaz.day13

import scalaz._
import Scalaz._

object Import {
  def main(args: Array[String]): Unit = {
    // import scalaz._
    println(scalaz.Monad[scalaz.Id.Id])
    println(1.node(2.leaf))
    // syntax.ToTypeClassOps
    println(1.set("log1"))
    println("log2".tell)
    println(1.success[String])
    println("boom".failureNel[Int])
  }
}
