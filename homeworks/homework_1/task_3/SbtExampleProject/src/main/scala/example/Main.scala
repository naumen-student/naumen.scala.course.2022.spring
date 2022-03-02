package example

object Main extends App {
  val greeting = "Hello Scala! This is Terentii";
  println(greeting);
  val greetingHola = "Hola Skala! This is Terentii";
  println(greetingHola);
  val greetingRu = "Zdarova Skala! This is Terentii";
  println(greetingRu);
  val greetingReversed = "Hello Scala! This is iitnereT";
  println(greetingReversed);
  val greetingHolaReversed = "Hola Scala! This is iitnereT";
  println(greetingHolaReversed);
  val greetingRuReversed = "Zdarova Scala! This is iitnereT";
  println(greetingRuReversed);

  println();

  val greetings = Array("Hello", "Hola", "Zdarova");
  val myName = "Terentii";

  def SayHi(name: String, greet: String): Unit ={
    println(greet + " Scala! This is " + name);
  }

  for (greet <- greetings)
    SayHi(myName, greet);

  for (greet <- greetings)
    SayHi(myName.reverse ,greet);
}
