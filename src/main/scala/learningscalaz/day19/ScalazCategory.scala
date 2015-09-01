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
  // 朝食の射
  sealed trait Breakfast {}
  case object Eggs extends Breakfast {}
  case object Oatmeal extends Breakfast {}
  case object Toast extends Breakfast {}
  case object Coffee extends Breakfast {}

  val favoriteBreakfast: Person => Breakfast = {
    case John => Eggs
    case Mary => Coffee
    case Sam  => Coffee
  }

  def main(args: Array[String]): Unit = {
    val a: Set[Person] = Set[Person](John, Mary, Sam)
    // val a = Set[Person](John, Mary, Sam)
    // val a: List[Person] = List[Person](John, Mary, Sam)
    println(a)
    println(favoriteBreakfast(John))
    println(favoriteBreakfast(Mary))
  }
}
