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

trait MonoidOp[A] {
  val F: Monoid[A]
  val value: A
  def |+|(a2: A) = F.mappend(value, a2)
}

object Enrich2 {
  implicit def toMonoidOp[A: Monoid](a: A): MonoidOp[A] = new MonoidOp[A] {
    val F = implicitly[Monoid[A]]
    val value = a
  }

  def main(args: Array[String]): Unit = {
    println(3 |+| 4)
    println("a" |+| "b")
  }
}

