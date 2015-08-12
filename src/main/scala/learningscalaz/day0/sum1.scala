package learningscalaz.day0

object Sum1 {
  def sum(xs: List[Int]): Int = xs.foldLeft(0) { _ + _ }

  def main(args: Array[String]): Unit = {
    println(sum(List(1,2,3,4)))
  }
}
