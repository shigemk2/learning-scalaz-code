object Apply {
  import scalaz._
  import Scalaz._

  def main(args: Array[String]): Unit = {
    println(9.some <*> {(_: Int) + 3 }.some)
  }
}
