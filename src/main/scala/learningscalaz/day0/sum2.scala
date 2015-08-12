package learningscalaz.day0

object Sum2 {
  def sum(xs: List[Int]): Int = xs.foldLeft(IntMonoid.mzero)(IntMonoid.mappend)

  def main(args: Array[String]): Unit = {
    println(sum(List(1,2,3,4)))
  }
}
