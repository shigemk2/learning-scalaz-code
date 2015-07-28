object Sum4 {
  def sum[A](xs: List[A])(implicit m: Monoid[A]): A = xs.foldLeft(m.mzero)(m.mappend)

  implicit val intMonoid = IntMonoid

  implicit val multiMonoid: Monoid[Int] = new Monoid[Int] {
    def mappend(a: Int, b: Int): Int = a * b
    def mzero: Int = 1
  }

  def main(args: Array[String]): Unit = {
    println(sum(List(1,2,3,4))(IntMonoid))
    println(sum(List(1,2,3,4))(multiMonoid))
    println(sum(List(1,2,3,4)))
  }
}
