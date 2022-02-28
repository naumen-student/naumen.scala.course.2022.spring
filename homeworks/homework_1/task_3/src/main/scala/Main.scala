object Main extends App {
  val name: String = "gODeaLoAple"
  val greetings: List[String] =
    "Hello" :: "Hola" :: "Hi" :: "Dobar dan" :: "Selam" :: "Salut" :: "Bonjour" :: Nil

  println(greet("Hello", name))
  println()
  greet(greetings, name).foreach(println)
  println()
  greet(greetings, name.reverse).foreach(println)

  private def greet(greeting: String, name: String): String =
    s"$greeting Scala! This is $name"

  private def greet(greetings: List[String], name: String): List[String] =
    greetings.map(word => greet(word, name))
}
