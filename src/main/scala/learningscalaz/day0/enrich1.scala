package learningscalaz.day0

object Enrich1 {
  def plus[A: Monoid](a: A, b: A): A = implicitly[Monoid[A]].mappend(a, b)

  def main(args: Array[String]): Unit = {
    println(plus(3, 4)(IntMonoid))
  }
}
