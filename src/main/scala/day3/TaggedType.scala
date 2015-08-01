sealed trait KiloGram

object TaggedType {
  import scalaz._
  import Scalaz._

  def KiloGram[A](a: A): A @@ KiloGram = Tag[A, KiloGram](a)

  def main(args: Array[String]): Unit = {
    val mass = KiloGram(20.0)
    println(2 * Tag.unwrap(mass))
    println(2 * Tag.unwrap(mass))
    println(2 * scalaz.Tag.unsubst[Double, Id, KiloGram](mass))
  }
}
