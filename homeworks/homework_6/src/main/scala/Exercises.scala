object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq match {
    case head :: tail => reverse(tail) ++ Seq(head)
    case Nil => seq
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = idx match {
    case 0 => 0
    case 1 => 1
    case _ => fibonacci4Index(idx - 2) + fibonacci4Index(idx - 1)
  }

  def fibonacci(idx: Int): Seq[Int] = idx match {
    case 0 => Seq(fibonacci4Index(idx))
    case 1 => Seq(fibonacci4Index(0), fibonacci4Index(1))
    case _ => fibonacci(idx - 1) :+ fibonacci4Index(idx)
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text
    .map(w => MORSE.getOrElse(w.toString.toUpperCase(), w))
    .mkString(" ")

  var symbols_split = "[.,!? ]"

  var reg = s"(?=[${symbols_split}])|(?<=[${symbols_split}])"

  def wordReverse(text: String): String = text.split(reg).map(x => if (x.charAt(0).isUpper) {
    x.toLowerCase.reverse.capitalize
  } else x.reverse)
    .mkString("")

}
