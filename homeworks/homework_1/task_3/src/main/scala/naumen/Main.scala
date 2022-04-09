package naumen

object Main{
  def main(args: Array[String]) : Unit = {
    val greets = List("Hello, Scala! This is", "Guten tag, Scala! This is", "Halo, Scala! This is")
    val name = "Semke Daniil"
    printGreets(name, greets);
  }

  def printGreets(name: String, greets: List[String]): Unit = {
    greets.foreach(greet => {
      println(s"$greet $name")
      println(s"$greet $name".reverse)
    });
  }
}
