package ru.pinguin

object Main extends App {
  val name: String = "Stepan Khudyakov"
  val greetings: Array[String] = Array("Hello", "Hola", "Guten tag")
  greetings.foreach((greet: String) => printGreeting(greet, name))
  greetings.foreach((greet: String) => printGreeting(greet, name.reverse))

  def printGreeting(greeting: String, name: String): Unit = println(
    s"$greeting, Scala! This is $name"
  )
}
