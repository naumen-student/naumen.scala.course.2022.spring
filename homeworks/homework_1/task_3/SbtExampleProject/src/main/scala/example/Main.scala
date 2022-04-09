package example

object Main extends App {
  val greetings = Array("Hello", "Hola", "Guten tag")
  val fullName = "Alexander Shamala"
  val names = Array(fullName, fullName.reverse)
  for (n <- names; g <- greetings)
    println(s"$g Scala! This is $n")
}
