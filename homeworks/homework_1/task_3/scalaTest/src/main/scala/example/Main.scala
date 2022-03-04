package example

object Main extends App {
  def hello(hello: String,name: String ): Unit = {
    println(hello + " Scala! This is " + name)
  }

  hello("Hello","Alexander Epik")
  hello("Guten tag","Alexander Epik")
  hello("Hello","Alexander Epik".reverse)
}
