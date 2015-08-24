package learningscalaz.day11

import scalaz._
import Scalaz._

object LensSample {
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

    val turtlePosition = Lens.lensu[Turtle, Point] (
      (a, value) => a.copy(position = value),
      _.position
    )

    val pointX = Lens.lensu[Point, Double] (
      (a, value) => a.copy(x = value),
      _.x
    )

    val turtleX = turtlePosition >=> pointX
    val t0 = Turtle(Point(2.0, 3.0), 0.0,
      Color(255.toByte, 255.toByte, 255.toByte))
    println(turtleX.get(t0))

    println(turtleX.set(t0, 5.0))

    println(turtleX.mod(_ + 1.0, t0))

    // val incX = turtleX =>= {_ + 1.0 }
    // println(incX(t0))

    val incX = for {
      x <- turtleX %= {_ + 1.0}
    } yield x

    println(incX(t0))
  }
}
