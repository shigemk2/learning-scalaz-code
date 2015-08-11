import scalaz._
import Scalaz._

object MonadLaws {
  def main(args: Array[String]): Unit = {
    println((Monad[Option].point(3) >>= { x => (x + 100000).some }) assert_=== 3 |> { x => (x + 100000).some })

  }
}
