object Applicative {
  def main(args: Array[String]): Unit = {
    import scalaz._

    // これはエラー
    // println(List(1,2,3,4) map {(_: Int) * (_: Int)})
    val res1 = List(1,2,3,4) map {(_: Int) * (_: Int)}.curried
    println(res1 map {_(9)})
  }
}
