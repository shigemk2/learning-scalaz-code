package learningscalaz.day19

import scalaz._
import Scalaz._

object ScalazPoint {
  // 前回の続き
  sealed trait Person {}
  case object John extends Person {}
  case object Mary extends Person {}
  case object Sam extends Person {}
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
  val favoritePerson: Person => Person = {
    case John => Mary
    case Mary => John
    case Sam  => Mary
  }
  val favoritePersonsBreakfast = favoriteBreakfast compose favoritePerson

  val johnPoint: Unit => Person = { case () => John }

  def main(args: Array[String]): Unit = {
    val res1 = favoriteBreakfast compose johnPoint
    println(res1(()))
    // println(res1()) // warningが出る
  }
}
