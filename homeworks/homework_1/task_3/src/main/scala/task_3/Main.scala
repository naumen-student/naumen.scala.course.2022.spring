package task_3

object Main extends App{
  def greet(greeting: String, name: String): Unit = {
    println(s"$greeting Scala! This is $name")
  }

  val greetings = Array("Hello", "Hola", "Guten Tag", "Bonjour")
  val name = "Oleg Gubanov"
  for (i <- 0 to 1)
    for (greeting <- greetings)
      if (i == 0)
        greet(greeting, name)
      else
        greet(greeting, name.reverse)
}
