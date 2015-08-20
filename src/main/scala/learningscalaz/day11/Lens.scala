package learningscalaz.day11

import scalaz._
import Scalaz._

object Lens {
  def main(args: Array[String]): Unit = {
    case class Point(x: Double, y: Double)
    case class Color(r: Byte, g: Byte, b: Byte)

    case class Turtle(
      position: Point,
      heading: Double,
      color: Color)

    println(Turtle(Point(2.0, 3.0), 0.0,
      Color(255.toByte, 255.toByte, 255.toByte)))
  }
}
