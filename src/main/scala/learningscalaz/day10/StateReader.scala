package learningscalaz.day10

import scalaz._
import Scalaz._

object StateReader {
  def main(args: Array[String]): Unit = {
    def myName(step: String): Reader[String, String] = Reader { step + ", I am " + _}

    def localExample: Reader[String, (String, String, String)] = for {
      a <- myName("First")
      b <- myName("Second") >=> Reader { _ + "dy" }
      c <- myName("Third")
    } yield (a, b, c)

    println(localExample("Fred"))

    type ReaderTOption[A, B] = ReaderT[Option, A, B]
    object ReaderTOption extends KleisliInstances with KleisliFunctions {
      def apply[A, B](f: A => Option[B]): ReaderTOption[A, B] = kleisli(f)
    }

    def configure(key: String) = ReaderTOption[Map[String, String], String] {_.get(key)}

    def setupConnection = for {
      host <- configure("host")
      user <- configure("user")
      password <- configure("password")
    } yield (host, user, password)

    val goodConfig = Map(
      "host" -> "eed3si9n.com",
      "user" -> "sa",
      "password" -> "****"
    )

    println(setupConnection(goodConfig))

    val badConfig = Map(
      "host" -> "example.com",
      "user" -> "sa"
    )
    println(setupConnection(goodConfig))
    println(setupConnection(badConfig))
  }
}
