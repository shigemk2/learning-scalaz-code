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
    // syntax.std.ToAllStdOps
    // BooleanOps
    println(false /\ true)
    println(false \/ true)
    println(true option "foo")
    println((1 > 10)? "foo" | "bar")
    println((1 > 10)? "hoge" | "fuga")
    println((1 > 10)?? {List("foo")})
    println((1 < 10)?? {List("foo")})
    println((1 < 10)!? {List("foo")})
    println((1 > 10)!? {List("foo")})
    // ListOps
    println(1.some? "foo" | "bar")
    println(1.some | 2)
    println(none | 3)
    println("hoge".some ? "fuga" | "bar")
    println("".some ? "fuga" | "bar")
    println(none ? "fuga" | "bar")
  }
}
