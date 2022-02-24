package main.scala

object Main extends App {
  val name = "Vladimir Tiunov"
  val standardSample = " Scala! This is "
  val someGreetings = List("Hello", "Hola", "Guten tag")
  def printGreetings(someGr: List[String], person: String): Unit =
    println(someGr.map(gr => s"$gr $standardSample $person").mkString("\n"))

  printGreetings(someGreetings, name)
  printGreetings(someGreetings, name.reverse)
}
