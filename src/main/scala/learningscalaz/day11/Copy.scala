package learningscalaz.day11

object Copy {
  def main(args: Array[String]): Unit = {
    case class PersonName(firstName: String, lastName: String)

    val p = PersonName("nanigashi", "nanno")
    println(p)
    println(p.copy(p.firstName.toUpperCase, p.firstName.toUpperCase))
    println(p.copy(firstName = p.firstName.toUpperCase))
    println(p)
  }
}
