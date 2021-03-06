package learningscalaz.day1

trait CanTruthy[A] { self =>
  def truthys(a: A): Boolean
}

object CanTruthy {
  def apply[A](implicit ev: CanTruthy[A]): CanTruthy[A] = ev
  def truthys[A](f: A => Boolean): CanTruthy[A] = new CanTruthy[A] {
    def truthys(a: A): Boolean = f(a)
  }
}

trait CanTruthyOps[A] {
  def self: A
  implicit def F: CanTruthy[A]
  final def truthy: Boolean = F.truthys(self)
}

object ToCanIsTruthyOps {
  implicit def toCanIsTruthyOps[A](v: A)(implicit ev: CanTruthy[A]) =
    new CanTruthyOps[A] {
      def self = v
      implicit def F: CanTruthy[A] = ev
    }
}

object YesNoTypeClass {
  import scalaz._
  import Scalaz._
  import ToCanIsTruthyOps._
  def main(args: Array[String]): Unit = {
    implicit val intCanTruthy: CanTruthy[Int] = CanTruthy.truthys({
      case 0 => false
      case _ => true
    })

    println(10.truthy)

    implicit def listCanTruthy[A]: CanTruthy[List[A]] = CanTruthy.truthys({
      case Nil => false
      case _   => true
    })

    println(List("foo").truthy)

    implicit val nilCanTruthy: CanTruthy[scala.collection.immutable.Nil.type] = CanTruthy.truthys(_ => false)
    println(Nil.truthy)

    implicit val booleanCanTruthy: CanTruthy[Boolean] = CanTruthy.truthys(identity)

    println(false.truthy)

    def truthyIf[A: CanTruthy, B, C](cond: A)(ifyes: => B)(ifno: => C) =
      if(cond.truthy) ifyes
      else ifno

    println(truthyIf(Nil) {"YEAH!"} {"NO!"})
    println(truthyIf(2 :: 3:: 4 :: Nil) {"YEAH!"} {"NO!"})
    println(truthyIf(true) {"YEAH!"} {"NO!"})
  }
}
