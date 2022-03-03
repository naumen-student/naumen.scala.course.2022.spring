object Main {
  def main(args: Array[String]): Unit = {
    val phrases = List("Hello,", "Halo,", "Guten tag,")
    val main_phrase = " Scala! This is Chernogorov Michail!"
    phrases.map(x => println((x + main_phrase) + '\n' + (x + main_phrase).reverse))
  }
}