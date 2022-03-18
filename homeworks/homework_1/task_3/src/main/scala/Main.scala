object Main extends App {
  def hello_pattern(hello:String, name:String):Unit = {
    println(s"$hello Scala! This is $name")
  }

  val name = "Andrew Lazarev"
  var hello_words = Array("Hello", "Guten Tag", "Hola")

  for (greeting <- hello_words)
    hello_pattern(greeting, name)

  for (greeting <- hello_words)
    hello_pattern(greeting, name.reverse)
}
