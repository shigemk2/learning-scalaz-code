object Apply {
  import scalaz._
  import Scalaz._

  def main(args: Array[String]): Unit = {
    println(9.some <*> {(_: Int) + 3 }.some)
    println(1.some <* 2.some)
    println(none <* 2.some)
    println(1.some *> 2.some)
    println(none *> 2.some)
  }
}
