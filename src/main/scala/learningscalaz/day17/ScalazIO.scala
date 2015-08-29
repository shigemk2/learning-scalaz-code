package learningscalaz.day17

import scalaz._
import Scalaz._
import effect._
import IO._

object ScalazIO {
  // IOアクション
  val action1 = for {
    _ <- putStrLn("Hello, world!")
  } yield ()
  def main(args: Array[String]): Unit = {
    println(action1.unsafePerformIO)
  }
}
