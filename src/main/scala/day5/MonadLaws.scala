import scalaz._
import Scalaz._

object MonadLaws {
  def main(args: Array[String]): Unit = {
    // 左単位元
    println((Monad[Option].point(3) >>= { x => (x + 100000).some }) assert_=== 3 |> { x => (x + 100000).some })
    // 右単位元
    println(("move on up".some flatMap {Monad[Option].point(_)}) assert_=== "move on up".some)
  }
}
