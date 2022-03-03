package example

object Main extends App {
  val yourName = "Ksenia Khomutova"

  val helloList = List("Hello", "Hola", "Guten Tag")

  def hello(hello: String, yourName: String) = {
    println(s"${hello} Scala! This is ${yourName}")
  }

  def helloReversed(hello: String, yourName: String) = {
    println(s"${hello} Scala! This is ${yourName.reverse}")
  }

  helloList.foreach(word => hello(word, yourName))
  println()
  helloList.foreach(word => helloReversed(word, yourName))

}
