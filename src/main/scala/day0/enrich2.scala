import scala.language.implicitConversions

trait MonoidOp[A] {
  val F: Monoid[A]
  val value: A
  def |+|(a2: A) = F.mappend(value, a2)
}

object Enrich2 {
  implicit def toMonoidOp[A: Monoid](a: A): MonoidOp[A] = new MonoidOp[A] {
    val F = implicitly[Monoid[A]]
    val value = a
  }

  def main(args: Array[String]): Unit = {
    // 3 |+| 4
    // "a" |+| "b"
  }
}

