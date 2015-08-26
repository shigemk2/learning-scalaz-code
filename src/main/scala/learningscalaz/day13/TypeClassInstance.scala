package learningscalaz.day13

// 型クラスインスタンスと関数
object TypeClassInstance {
  import scalaz.std.option._
  def main(args: Array[String]): Unit = {
    println(scalaz.Monad[Option].point(0))
  }
}

object AllInstancesSample {
  import scalaz.std.AllInstances._
  def main(args: Array[String]): Unit = {
    println(scalaz.Monoid[Int])
  }
}


