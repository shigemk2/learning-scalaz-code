package learningscalaz.day11

import scalaz._
import Scalaz._

object Lens {
  def main(args: Array[String]): Unit = {
    case class Point(x: Double, y: Double)
    case class Color(r: Byte, g: Byte, b: Byte)

    case class Turtle(position: Point, heading: Double, color: Color) {
      def forward(dist: Double): Turtle =
        copy(position =
          position.copy(
            x = position.x + dist * math.cos(heading),
            y = position.y + dist * math.sin(heading)
          ))
    }

    val a = Turtle(Point(2.0, 3.0), 0.0,
      Color(255.toByte, 255.toByte, 255.toByte))
    println(a)
    println(a.forward(10))
  }
}
