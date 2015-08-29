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
  // IOアクション2
  val action2 = IO {
    val source = scala.io.Source.fromFile("./README.md")
    source.getLines.toStream
  }

  def main(args: Array[String]): Unit = {
    println(action1.unsafePerformIO)
    println(action2.unsafePerformIO.toList)

    // TESS2
    def program: IO[Unit] = for {
      line <- readLn
      _ <- putStrLn(line)
    } yield ()

    println((program |+| program).unsafePerformIO)
    println((program |+| program |+| program).unsafePerformIO)
  }
}
