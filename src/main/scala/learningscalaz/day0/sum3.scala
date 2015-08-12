package learningscalaz.day0

object Sum3 {
  def sum[A](xs: List[A])(implicit m: Monoid[A]): A = xs.foldLeft(m.mzero)(m.mappend)

  def main(args: Array[String]): Unit = {
    implicit val intMonoid = IntMonoid

    println(sum(List(1,2,3,4))(IntMonoid))
    println(sum(List(1,2,3,4)))
  }
}
