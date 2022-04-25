package example

object Main extends App {
  println("Hello")

  println("Hello Scala! This is Ilya")

  val greet_1 = "Hello"

  val greet_2 = "Hola"

  val greet_3 = "Guten tag"

  println(greet_1 + " Scala! This is Ilya")

  val name_1 = "Ilya Grebenyuk"

  println(greet_1 + " Scala! This is " + name_1)

  val name_1_rvrs = name_1.reverse

  println(greet_1 + " Scala! This is " + name_1)

  println(greet_1 + " Scala! This is " + name_1_rvrs)

  println(greet_2 + " Scala! This is " + name_1_rvrs)

  println(greet_3 + " Scala! This is " + name_1_rvrs)

  def hello(greet: String, name: String) : Unit = {
    println(greet + " " + name)
  }

  hello(greet_1, name_1)
}
