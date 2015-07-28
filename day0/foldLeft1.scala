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

implicit val intMonoid = IntMonoid

implicit val stringMonoid = StringMonoid

implicit val multiMonoid: Monoid[Int] = new Monoid[Int] {
  def mappend(a: Int, b: Int): Int = a * b
  def mzero: Int = 1
}

object FoldLeftList {
  def foldLeft[A, B](xs: List[A], b: B, f: (B, A) => B) = xs.foldLeft(b)(f)
}

def sum[A: Monoid](xs: List[A]): A = {
  val m = implicitly[Monoid[A]]
  FoldLeftList.foldLeft(xs, m.mzero, m.mappend)
}

println(sum(List(1,2,3,4)))
println(sum(List("a", "b", "c"))(stringMonoid))
println(sum(List(1,2,3,4))(multiMonoid))
