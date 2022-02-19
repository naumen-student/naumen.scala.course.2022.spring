object Main {
  def main(args : Array[String]) : Unit = {
    var i = 0
    var greets = List("Hello Scala! This is", "Guten Tag! Das ist", "Privjet Scala! Eto est")
    var name = "Alexey Komissarov"
    while (i < greets.length) {
      greet(name, greets(i))
      greetReverse(name, greets(i))
      i += 1
    }
  }

  def greet(name : String, greet : String) : Unit = {
    println(s"$greet $name")
  }

  def greetReverse(name : String, greet : String) : Unit = {
    var i = 0
    var reverseName = ""
    while (i < name.length()) {
      i += 1
      var currentLetter = name(name.length() - i)
      reverseName = s"$reverseName$currentLetter"
    }
    println(s"$greet $reverseName")
  }
}
