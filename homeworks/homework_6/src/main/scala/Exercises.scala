object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = idx match {
    case 0 => 0
    case 1 => 1
    case i => fibonacci4Index(i - 1) + fibonacci4Index(i - 2)
  }

  def fibonacci(idx: Int): Seq[Int] = idx match {
    case 0 => Seq(fibonacci4Index(idx))
    case 1 => Seq(fibonacci4Index(0), fibonacci4Index(1))
    case i => fibonacci(idx - 1) :+ fibonacci4Index(idx)
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text.map(char => MORSE.getOrElse(char.toString.toUpperCase(), char)).mkString(" ")


  def wordReverse(text: String): String =  "([а-яА-Яa-zA-Z]+|[^а-яА-Яa-zA-Z])".r.findAllIn(text).map(word =>
    if (word.head.isUpper) word.toLowerCase.reverse.capitalize
    else word.reverse
  ).mkString("")

}
