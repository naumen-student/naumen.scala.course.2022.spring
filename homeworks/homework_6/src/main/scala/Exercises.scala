object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  def fibonacci4Index(idx: Int): Int  = idx match {
    case 0 => 0
    case 1 => 1
    case _ => fibonacci4Index(idx - 1) + fibonacci4Index(idx - 2)
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

  def morse(text: String): String = text.map(x => MORSE.getOrElse(x.toUpper.toString, x)).mkString(" ")


  def wordReverse(text: String): String = {
    "[a-zA-Zа-яА-Я]+|[^a-zA-Zа-яА-Я]".r
      .findAllIn(text)
      .map { word =>
      if (word.head.isUpper)
        word.toLowerCase.reverse.capitalize
      else
        word.reverse
    }.mkString("")
  }

}
