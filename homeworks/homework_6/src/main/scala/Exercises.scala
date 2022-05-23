object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {
    val fi = (1 + math.sqrt(5))/2
    ((math.pow(fi, idx) - math.pow(- fi, - idx)) / (2 * fi - 1)).toInt
  }

  def fibonacci(idx: Int): Seq[Int] = {
    (0 to idx).map(fibonacci4Index)
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    text.map { l =>
      if (MORSE.contains(l.toString.toUpperCase()))
        MORSE(l.toString.toUpperCase())
      else
        l.toString
    }.mkString(" ")
  }


  def wordReverse(text: String): String = {
    "[a-zA-Zа-яА-Я]+|[^a-zA-Zа-яА-Я]".r.findAllIn(text).map { word =>
      if (word.head.isUpper)
        word.toLowerCase.reverse.capitalize
      else
        word.reverse
    }.mkString("")
  }

}