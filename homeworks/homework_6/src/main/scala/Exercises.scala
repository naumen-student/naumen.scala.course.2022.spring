object Exercises {
  def reverse[T](seq: Seq[T]): Seq[T] = seq match {
    case head :: tail => reverse(tail) ++ Seq(head)
    case _ => seq
  }

  def fibonacci4Index(idx: Int): Int = idx match {
    case 0 => 0
    case 1 => 1
    case idx if idx >= 2 => fibonacci4Index(idx - 1) + fibonacci4Index(idx - 2)
  }

  def fibonacci(idx: Int): Seq[Int] = idx match {
    case 0 => Seq(0)
    case 1 => Seq(0, 1)
    case idx if idx >= 2 => fibonacci(idx - 1) :+ fibonacci4Index(idx)
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text
    .map(w => MORSE.getOrElse(w.toString.toUpperCase(), w))
    .mkString(" ")

  val wordsRegexp = "([а-яА-Яa-zA-Z]+|[^а-яА-Яa-zA-Z])".r
  def wordReverse(text: String): String =
    wordsRegexp
      .findAllIn(text)
      .map {
        case word if word.head.isUpper => (word.head.toLower + word.tail).reverse.capitalize
        case word => word.reverse
      }.mkString("")

}
