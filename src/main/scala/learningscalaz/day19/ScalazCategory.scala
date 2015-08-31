package learningscalaz.day19

import scalaz._
import Scalaz._

object ScalazCategory {
  // { John, Mary, Sam }
  // この圏をScalaで実装する
  sealed trait Person {}
  case object John extends Person {}
  case object Mary extends Person {}
  case object Sam extends Person {}

  def main(args: Array[String]): Unit = {
    val a: Set[Person] = Set[Person](John, Mary, Sam)
    println(a)
  }
}
