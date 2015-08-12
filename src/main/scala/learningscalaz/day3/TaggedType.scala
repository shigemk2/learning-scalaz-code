package learningscalaz.day3

sealed trait KiloGram
sealed trait JoulePerKiloGram

object TaggedType {
  import scalaz._
  import Scalaz._

  def KiloGram[A](a: A): A @@ KiloGram = Tag[A, KiloGram](a)

  def JoulePerKiloGram[A](a: A): A @@ JoulePerKiloGram = Tag[A, JoulePerKiloGram](a)

  def energyR(m: Double @@ KiloGram): Double @@ JoulePerKiloGram =
    JoulePerKiloGram(299792458.0 * 299792458.0 * Tag.unsubst[Double, Id, KiloGram](m))

  def main(args: Array[String]): Unit = {
    val mass = KiloGram(20.0)
    println(2 * Tag.unwrap(mass))
    println(2 * Tag.unwrap(mass))
    println(2 * scalaz.Tag.unsubst[Double, Id, KiloGram](mass))

    println(energyR(mass))
    // println(energyR(10.0))
  }
}
