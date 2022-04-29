package example

object Main extends App {
  val privet = List("Hello", "Hola", "Guten tag")
  val name = ", Scala! This is Tamara Mezenova"
  val eman = ", Scala! This is avonezeM aramaT "
  val a = privet(0) + name
  println(a)
  val b = privet(1) + name
  println(b)
  val c = privet(2) + name
  println(c)
  val greetings = Array(privet(0) + eman, privet(1) + eman, privet(2) + eman)
  println(greetings(0))
  println(greetings(1))
  println(greetings(2))
}
