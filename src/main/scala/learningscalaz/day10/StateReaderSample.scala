package learningscalaz.day10

import scalaz._
import Scalaz._


object StateReaderSample {
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

    // def configure(key: String) = ReaderTOption[Map[String, String], String] {_.get(key)}
    def configure[S](key: String) = new StateTReaderTOption[Config, S, String] {
      def apply(s: S) = ReaderTOption[Config, (S, String)] { config: Config => config.get(key) map {(s, _)} }
    }

    // def setupConnection = for {
    //   host <- configure("host")
    //   user <- configure("user")
    //   password <- configure("password")
    // } yield (host, user, password)

    // val goodConfig = Map(
    //   "host" -> "eed3si9n.com",
    //   "user" -> "sa",
    //   "password" -> "****"
    // )

    // println(setupConnection(goodConfig))

    // val badConfig = Map(
    //   "host" -> "example.com",
    //   "user" -> "sa"
    // )
    // println(setupConnection(goodConfig))
    // println(setupConnection(badConfig))

    type StateTReaderTOption[C, S, A] = StateT[({type l[X] = ReaderTOption[C, X]})#l, S, A]

    object StateTReaderTOption extends StateTInstances with StateTFunctions {
      def apply[C, S, A](f: S => (S, A)) = new StateT[({type l[X] = ReaderTOption[C, X]})#l, S, A] {
        def apply(s: S) = f(s).point[({type l[X] = ReaderTOption[C, X]})#l]
      }
      def get[C, S]: StateTReaderTOption[C, S, S] =
        StateTReaderTOption { s => (s, s) }
      def put[C, S](s: S): StateTReaderTOption[C, S, Unit] =
        StateTReaderTOption { _ => (s, ()) }
    }

    type Stack = List[Int]
    type Config = Map[String, String]
    val pop: StateTReaderTOption[Config, Stack, Int] = {
      import StateTReaderTOption.{get, put}
      for {
        s <- get[Config, Stack]
        val (x :: xs) = s
        _ <- put(xs)
      } yield x
    }

    def push(x: Int): StateTReaderTOption[Config, Stack, Unit] = {
      import StateTReaderTOption.{get, put}
      for {
        xs <- get[Config, Stack]
        r <- put(x :: xs)
      } yield r
    }

    // def stackManip: StateTReaderTOption[Config, Stack, Int] = for {
    //   _ <- push(3)
    //   a <- pop
    //   b <- pop
    // } yield(b)
    def stackManip: StateTReaderTOption[Config, Stack, Unit] = for {
      x <- configure("x")
      a <- push(x.toInt)
    } yield(a)

    println(stackManip(List(5, 8, 2, 1))(Map()))
    println(stackManip(List(5, 8, 2, 1))(Map("x" -> "7")))
    println(stackManip(List(5, 8, 2, 1))(Map("y" -> "7")))
  }
}
