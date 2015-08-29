package learningscalaz.day16

import scalaz._
import Scalaz._

object ScalazMemo {
  def main(args: Array[String]): Unit = {
    // この書き方だとforward reference extends over definition of value slowFibになるので、defで関数定義する
    // val slowFib: Int => Int = {
    //   case 0 => 0
    //   case 1 => 1
    //   case n => slowFib(n - 2) + slowFib(n - 1)
    // }
    def slowFib(n: Int): Int = n match {
      case 0 => 0
      case 1 => 1
      case n => slowFib(n - 2) + slowFib(n - 1)
    }
    println(slowFib(30))
    println(slowFib(40))
    // println(slowFib(45))
  }
}
