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

    println(scalaz.Apply[Option].lift2((_: Int) :: (_: List[Int]))(3.some, List(4).some))

    def sequenceA[F[_]: Applicative, A](list: List[F[A]]): F[List[A]] = list match {
      case Nil => (Nil: List[A]).point[F]
      case x :: xs => (x |@| sequenceA(xs)) {_ :: _}
    }

    println(sequenceA(List(1.some, 2.some)))
    println(sequenceA(List(3.some, none, 1.some)))
    println(sequenceA(List(List(1,2,3), List(4,5,6))))

    type Function1Int[A] = ({type l[A]=Function1[Int, A]})#l[A]
    val res1 = sequenceA(List((_: Int) + 3, (_: Int) + 2, (_: Int) + 1): List[Function1Int[Int]])
    println(res1(3))
  }
}
