// see
// https://github.com/scalaz/scalaz/blob/series/7.1.x/core/src/main/scala/scalaz/Functor.scala

object Functor {
  def main(args: Array[String]) = {
    import scalaz._
    import Scalaz._

    println(List(1,2,3) map { _ + 1 })
    println((1,2,3) map { _ + 1 }) // (1,2,4)

    val res1 = ((x: Int) => x + 1) map { _ * 7 }
    println(res1(3))

    val res2 = scalaz.Functor[List].lift {(_: Int) * 2}
    println(res2(List(3)))

    println(List(1,2,3) >| "x")
    println(List(1,2,3) as "x")
    println(List(1,2,3).fpair)
    println(List(1,2,3).strengthL("x"))
    println(List(1,2,3).strengthR("x"))
    println(List(1,2,3).void)
  }
}
