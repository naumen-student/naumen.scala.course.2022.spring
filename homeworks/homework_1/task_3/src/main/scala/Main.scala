object Main extends App {

  val name = "Egor Polieftov"

  val helloWords = Seq("Hello", "Hola", "Guten tag")

  helloWords.foreach(helloWord => println(s"$helloWord Scala! This is $name"))
  helloWords.foreach(helloWord => println(s"$helloWord Scala! This is ${name.reverse}"))
}
