// see
// https://github.com/scalaz/scalaz/blob/series/7.1.x/core/src/main/scala/scalaz/Functor.scala

object Functor {
  def main(args: Array[String]) = {
    import scalaz._
    import Scalaz._

    println(List(1,2,3) map { _ + 1 })

    println((1,2,3) map { _ + 1 }) // (1,2,4)
  }
}
