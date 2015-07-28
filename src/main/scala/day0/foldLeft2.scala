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

trait FoldLeft[F[_]] {
  def foldLeft[A, B](xs: F[A], b: B, f: (B, A) => B): B
}

object FoldLeft {
  implicit val FoldLeftList: FoldLeft[List] = new FoldLeft[List] {
    def foldLeft[A, B](xs: List[A], b: B, f: (B, A) => B) = xs.foldLeft(b)(f)
  }
}

object FoldLeft2 {
  def sum[M[_]: FoldLeft, A: Monoid](xs: M[A]): A = {
    val m = implicitly[Monoid[A]]
    val fl = implicitly[FoldLeft[M]]
    fl.foldLeft(xs, m.mzero, m.mappend)
  }

  def main(args: Array[String]): Unit = {
    implicit val intMonoid = IntMonoid
    implicit val stringMonoid = StringMonoid
    implicit val multiMonoid: Monoid[Int] = new Monoid[Int] {
      def mappend(a: Int, b: Int): Int = a * b
      def mzero: Int = 1
    }

    println(sum(List(1,2,3,4)))
    println(sum(List("a", "b", "c")))
  }
}
