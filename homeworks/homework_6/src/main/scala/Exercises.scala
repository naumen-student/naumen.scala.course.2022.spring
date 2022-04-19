object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.foldLeft(List.empty[T])((result, current) => current +: result)

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = fibonacci(idx).last

  def fibonacci(idx: Int): Seq[Int] = idx match {
    case 0 => Seq(0)
    case 1 => Seq(0, 1)
    case _ => Range(2, idx + 1)
      .foldRight(List(0, 1))((_, res) => res ::: List(res.last + res.init.last))
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text.map(symbol => MORSE.getOrElse(symbol.toUpper.toString, symbol)).mkString(" ")

  def wordReverse(text: String): String =
    text
      .split("(?=[!. ,?])|(?<=[!. ,?])")
      .map(word => if (word.charAt(0).isUpper)
        word.toLowerCase.reverse.capitalize
      else
        word.reverse)
      .mkString("")
}
