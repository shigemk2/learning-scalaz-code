package learningscalaz.day0

object FoldLeftList {
  def foldLeft[A, B](xs: List[A], b: B, f: (B, A) => B) = xs.foldLeft(b)(f)
}

object FoldLeft1 {
  def sum[A: Monoid](xs: List[A]): A = {
    val m = implicitly[Monoid[A]]
    FoldLeftList.foldLeft(xs, m.mzero, m.mappend)
  }

  def main(args: Array[String]): Unit = {
    implicit val intMonoid = IntMonoid
    implicit val stringMonoid = StringMonoid
    implicit val multiMonoid: Monoid[Int] = new Monoid[Int] {
      def mappend(a: Int, b: Int): Int = a * b
      def mzero: Int = 1
    }

    println(sum(List(1,2,3,4)))
    println(sum(List("a", "b", "c"))(stringMonoid))
    println(sum(List(1,2,3,4))(multiMonoid))
  }
}
