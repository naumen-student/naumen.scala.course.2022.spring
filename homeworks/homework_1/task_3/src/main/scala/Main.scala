object Main extends App {

  def main(): Unit = {
    val greetings = "Hello" :: "Hola" :: "Guten tag" :: Nil
    val name = "Ivan"
    val names = name :: name.reverse :: Nil
    val personGreetings = for {
        name <- names
        greeting <- greetings
    } yield greeting + " Scala! This is " + name
    personGreetings.foreach(x => println(x))
  }
  main()

}
