package task3

object Main extends App {
  def getHelloText(helloWords: String, name: String):String = s"$helloWords Scala! This is $name"
  var myName = "Elizaveta Shtol"
  var englishHello = "Hello"
  var germanHello = "Guten tag"
  var spanishHello = "Hola"
  println(getHelloText(englishHello, myName))
  println(getHelloText(germanHello, myName))
  println(getHelloText(spanishHello, myName))
  println(getHelloText(englishHello, myName.reverse))
  println(getHelloText(germanHello, myName.reverse))
  println(getHelloText(spanishHello, myName.reverse))
}
