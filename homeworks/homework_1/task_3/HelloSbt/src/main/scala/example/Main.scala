package example

object Main extends App {
  def sayHello(
                helloWord: String = "Hello",
                changeUserName: String => String = (s) => s): Unit = {
    val name = System.getProperty("user.name")
    val helloPhrase = helloWord + " Scala! This is " + changeUserName(name)
    println(helloPhrase)
  }

  sayHello()
  sayHello("Guten tag")

  val reverse = (s: String) =>
    (for (i <- s.length - 1 to 0 by -1) yield s(i)).mkString
  reverse("test string")

  sayHello(changeUserName = reverse)
  sayHello("Hola", reverse)
}
