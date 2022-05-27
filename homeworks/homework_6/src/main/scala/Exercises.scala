object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = idx match{
    case 0 => 0
    case 1 => 1
    case i => fibonacci4Index(i-1) + fibonacci4Index(i-2)
  }

  def fibonacci(idx: Int): Seq[Int] = idx match{
    case 0 = Seq(0)
    case 1 = Seq(0,1)
    case idx => fibonacci(idx-1) :+ fibonacci(idx)
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text.map(i => MORSE.getOrElse(i.toString.toUpperCase(), i)).mkString(" ")

  def wordReverse(text: String): String ={
    "[a-zA-Zа-яА-Я]+|[^a-zA-Zа-яА-Я]".r.findAllIn(text).map{w =>
      if (w.head.isUpper){w.toLowerCase.reverse.capitalize}
      else{w.reverse}
    }.mkString("")
  }

}
