import scala.util.matching.Regex

object Exercises {

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def reverse[T](seq: Seq[T]): Seq[T] = seq match {
    case head :: tail => reverse(tail) ++ Seq(head)
    case Nil => seq
  }

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

  def morse(text: String): String = text
    .map(char => MORSE.getOrElse(char.toString.toUpperCase(), char))
    .mkString(" ")

  def wordReverse(text: String): String = {
    new Regex("\\pL+").replaceAllIn(text, w => {
      val reversed = w.toString().reverse
      if (reversed.last.isUpper)
        reversed.toLowerCase.capitalize
      else
        reversed
    })
  }
}