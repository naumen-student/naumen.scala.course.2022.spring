import scala.util.matching.Regex

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = {
    var list: List[T] = List[T]()
    for (x <- seq)
      list = x :: list
    list
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {
    idx match {
      case 0 => 0
      case 1 => 1
      case idx => fibonacci4Index(idx - 2) + fibonacci4Index(idx - 1)
    }
  }

  def fibonacci(idx: Int): Seq[Int] = {
    idx match {
      case 0 => Seq(0)
      case 1 => Seq(0, 1)
      case idx => fibonacci(idx - 1) :+ fibonacci4Index(idx)
    }
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    text.map(char => MORSE.getOrElse(char.toUpper.toString, char)).mkString(" ")
  }


  def wordReverse(text: String): String = {
    new Regex("\\pL+").replaceAllIn(text, word => {
      val reversed = word.toString().reverse
      if (reversed.last.isUpper)
        reversed.toLowerCase.capitalize
      else {
        reversed
      }
    })
  }
}
