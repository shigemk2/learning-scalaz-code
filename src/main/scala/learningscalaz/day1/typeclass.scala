package learningscalaz.day1

case class TrafficLight(name: String)

object TypeClass1 {
  import scalaz._
  import Scalaz._

  def main(args: Array[String]): Unit = {
    val red    = TrafficLight("red")
    val yellow = TrafficLight("yellow")
    val green  = TrafficLight("green")
    implicit val TrafficLightEqual: Equal[TrafficLight] = Equal.equal(_ == _)

    println(red === yellow)
  }
}
