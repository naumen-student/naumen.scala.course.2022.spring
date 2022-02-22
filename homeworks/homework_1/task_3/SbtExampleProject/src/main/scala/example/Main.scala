package example

object Main extends App {
  val mainString: String = " Scala! This is "
  val greetingsList: List[String] = List("Hello", "Hola", "Guten tag")
  val name = "Chingis Tulenov"
  val namesList: List[String] = List(name, name.reverse)
  for (greetings <- greetingsList)
    for (name <- namesList)
      println(greetings + mainString + name)
}
