package example

object Main extends App {
  val greet = (greeting: String, name: String) => println(s"$greeting Scala! This is $name")
  val manyTimesGreet = (greetings: Array[String], name: String) =>
    greetings foreach ((greeting: String) => greet(greeting, name))
  val greetings = Array("Hello", "Guten Morgen", "Guten Tag", "Guten Abend")
  val myName = "Maxim Francevich"
  manyTimesGreet(greetings, myName)
  manyTimesGreet(greetings, myName.reverse)
}
