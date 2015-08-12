package learningscalaz.day2

object Applicative {
  def main(args: Array[String]): Unit = {
    import scalaz._
    import Scalaz._

    // これはエラー
    // println(List(1,2,3,4) map {(_: Int) * (_: Int)})
    val res1 = List(1,2,3,4) map {(_: Int) * (_: Int)}.curried
    println(res1 map {_(9)})

    // おまじない import Scalaz._ がないと死ぬ
    println(1.point[List])
    println(1.point[Option])
    println(1.point[Option] map { _ + 2 })
    println(1.point[List] map { _ + 2 })
  }
}
