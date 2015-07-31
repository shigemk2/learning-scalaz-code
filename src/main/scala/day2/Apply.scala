object Apply {
  import scalaz._
  import Scalaz._

  def main(args: Array[String]): Unit = {
    println(9.some <*> {(_: Int) + 3 }.some)
    println(1.some <* 2.some)
    println(none <* 2.some)
    println(1.some *> 2.some)
    println(none *> 2.some)

    println(9.some <*> {(_: Int) + 3}.some)
    println(3.some <*> { 9.some <*> {(_: Int) + (_: Int)}.curried.some })

    println(^(3.some, 5.some) {_ + _})
    println(^(3.some, none[Int]) {_ + _})

    println((3.some |@| 5.some) {_ + _})

    println(List(1,2,3) <*> List((_: Int) * 0, (_: Int) + 100, (x: Int) => x * x))
    println(List(3,4) <*> {List(1,2) <*> List({(_: Int) + (_: Int)}.curried, {(_: Int) * (_: Int)}.curried)})
    println((List("ha", "heh", "hmm") |@| List("?", "!", ".")) {_ + _})

    println(streamZipApplicative.ap(Tags.Zip(Stream(1, 2))) (Tags.Zip(Stream({(_: Int) + 3}, {(_: Int) * 2}))))
    // println(streamZipApplicative.ap(Tags.Zip(Stream(1, 2))) (Tags.Zip(Stream({(_: Int) + 3}, {(_: Int) * 2}))).toList)
  }
}
