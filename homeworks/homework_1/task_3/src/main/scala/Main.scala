object Main {
  def main(args: Array[String]): Unit = {
    val name = "Artem Samoshkin";
    val greetings = List("Hola", "Hello", "Guten tag");

    printGreetings(name, greetings);
    printGreetings(name.reverse, greetings);
  }

  def printGreetings(name: String, greetings: List[String]): Unit = {
    greetings.foreach(greeting => {
      println(s"${greeting} Scala! This is ${name}");
    })
  }
}