trait Monoid[A] {
  def mappend(a1: A, a2: A): A
  def mzero: A
}

object IntMonoid extends Monoid[Int] {
  def mappend(a: Int, b: Int): Int = a + b
  def mzero: Int = 0
}

object StringMonoid extends Monoid[String] {
  def mappend(a: String, b: String): String = a + b
  def mzero: String = ""
}

def plus[A: Monoid](a: A, b: A): A = implicitly[Monoid[A]].mappend(a, b)

println(plus(3, 4)(IntMonoid))