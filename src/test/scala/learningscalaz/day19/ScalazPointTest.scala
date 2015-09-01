package learningscalaz.day19

import scalaz._
import Scalaz._
import org.scalacheck.{Properties, Prop, Arbitrary, Gen}

object ScalazPointTest {

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
  def arrowEqualsProp(f: Person => Breakfast, g: Person => Breakfast)
    (implicit ev1: Equal[Breakfast], ev2: Arbitrary[Person]): Prop =
    Prop.forAll { a: Person =>
      f(a) === g(a)
    }

  implicit val arbPerson: Arbitrary[Person] = Arbitrary {
    Gen.oneOf(John, Mary, Sam)
  }

  implicit val breakfastEqual: Equal[Breakfast] = Equal.equalA[Breakfast]

  def main(args: Array[String]): Unit = {
    val res1 = arrowEqualsProp(favoriteBreakfast, favoritePersonsBreakfast)
    res1.check
    val res2 = arrowEqualsProp(favoriteBreakfast, favoritePersonsBreakfast)
    res1.check
  }

}
