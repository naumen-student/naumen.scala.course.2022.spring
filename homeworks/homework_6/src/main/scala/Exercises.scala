import scala.util.matching.Regex

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq match {
    case head :: tail => reverse(tail) ++ Seq(head)
    case _ => seq
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

  def morse(text: String): String = text.map(x => MORSE.getOrElse(x.toUpper.toString, x)).mkString(" ")

  val wordRegex: Regex = "([а-яА-Яa-zA-Z]+|[^а-яА-Яa-zA-Z])".r


  def wordReverse(text: String): String = wordRegex.findAllIn(text).map {
    case w if w.head.isUpper => w.toLowerCase.reverse.capitalize
    case w => w.reverse
  }.mkString("")

}
