package Main

object Main extends App {
  val person = "Mazyrina Alena"
  val hellos = Array("Hello", "Hola", "Guten Tag", "Szia", "Ohayo")
  printHello(hellos: Array[String], person: String)
  printHello(hellos: Array[String], person.reverse: String)

  def printHello (hellos: Array[String], name: String) = {
    for(hello <- hellos) println(s"$hello Scala! This is $name")
  }
}

