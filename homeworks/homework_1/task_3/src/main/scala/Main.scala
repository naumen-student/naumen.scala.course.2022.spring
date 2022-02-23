object Main {
  def main(args: Array[String]): Unit = {
    val template = "Scala! This is"
    val greetings = List("Hello", "Hola", "Guten tag")

    val name = "Danil Lunev"
    val names = List(name, name.reverse)

    val personGreetings = for {
      name <- names
      greeting <- greetings
    } yield greeting + " " + template + " " + name

    personGreetings.foreach(x => println(x))
  }
}
