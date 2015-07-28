object IntMonoid {
  def mappend(a: Int, b: Int): Int = a + b
  def mzero: Int = 0
}

object Sum2 {
  def sum(xs: List[Int]): Int = xs.foldLeft(IntMonoid.mzero)(IntMonoid.mappend)

  def main(args: Array[String]): Unit = {
    println(sum(List(1,2,3,4)))
  }
}
