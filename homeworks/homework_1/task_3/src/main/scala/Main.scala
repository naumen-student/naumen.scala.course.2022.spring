object Main extends App {
  def sayHello(message: String, name: String): Unit = {
    println(s"$message$name")
  }

  val name = "Vladimir Grekalov";
  val hello = "Hello Scala! This is ";
  val hi = hello.replace("Hello", "Hi");
  sayHello(hello, name);
  sayHello(hi, name);
  sayHello(hello, name.reverse);
  sayHello(hi, name.reverse);
}
