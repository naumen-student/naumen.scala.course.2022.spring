import scala.annotation.tailrec
import scala.util.matching.Regex

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq match {
    case head :: tail => reverse(tail) ++ Seq(head)
    case _ => seq
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx : Int
   * @return
   */
  def fibonacci4Index(idx: Int): Int = fibonacci4IndexInternal(idx)

  @tailrec
  private def fibonacci4IndexInternal(index: Int, current: Int = 0, prev: Int = 1): Int = index match {
    case x if x <= 0 => current
    case _ => fibonacci4IndexInternal(index - 1, prev, current + prev)
  }

  def fibonacci(idx: Int): Seq[Int] = fibonacciInternal(idx)

  @tailrec
  private def fibonacciInternal(idx: Int, current: Int = 0, prev: Int = 1, seq: List[Int] = List(0)): Seq[Int] =
    idx match {
      case x if x <= 0 => seq.reverse
      case _ => fibonacciInternal(idx - 1, prev, current + prev, prev :: seq)
    }

  lazy val MORSE = Map(
    "A" -> ".-",
    "B" -> "-...",
    "C" -> "-.-.",
    "D" -> "-..",
    "E" -> ".",
    "F" -> "..-.",
    "G" -> "--.",
    "H" -> "....",
    "I" -> "..",
    "J" -> ".---",
    "K" -> "-.-",
    "L" -> ".-..",
    "M" -> "--",
    "N" -> "-.",
    "O" -> "---",
    "P" -> ".--.",
    "Q" -> "--.-",
    "R" -> ".-.",
    "S" -> "...",
    "T" -> "-",
    "U" -> "..-",
    "V" -> "...-",
    "W" -> ".--",
    "X" -> "-..-",
    "Y" -> "-.--",
    "Z" -> "--..")

  def morse(text: String): String = text.map(x => MORSE.getOrElse(x.toUpper.toString, x)).mkString(" ")

  val wordRegex: Regex = "([а-яА-Яa-zA-Z]+|[^а-яА-Яa-zA-Z])".r


  def wordReverse(text: String): String = wordRegex.findAllIn(text).map {
    case w if w.head.isUpper => w.toLowerCase.reverse.capitalize
    case w => w.reverse
  }.mkString("")

}