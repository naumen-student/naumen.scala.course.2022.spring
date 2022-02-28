object Main extends App {
  def hello(hello: String, name: String): Unit = {
    println(hello + " Scala! This is " + name)
  }

  var name = "Vadim Yun"

  hello("Hello", name)
  hello("Hello", name.reverse)
  hello("Guten tag", name)
  hello("Guten tag", name.reverse)
  hello("Hola", "Vadim Yun")
  hello("Hola", "Vadim Yun".reverse)
}