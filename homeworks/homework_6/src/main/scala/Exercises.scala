import scala.annotation.tailrec

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {

    @tailrec
    def fibTailRec(n: Int, prev: Int, cur: Int): Int = {
      n match {
        case n if n < 3 => cur
        case n => fibTailRec(n - 1, cur, prev + cur)
      }
    }

    fibTailRec(idx, 1, 1)
  }

  def fibonacci(idx: Int): Seq[Int] = {
    idx match {
      case 0 => Seq(0)
      case 1 => Seq(0, 1)
      case 2 => Seq(0, 1, 1)
      case num =>
        @tailrec
        def fibTailRec(n: Int, curSeq: Seq[Int]): Seq[Int] = {
          n match {
            case n if n < 3 => curSeq
            case n => fibTailRec(n - 1, curSeq :+ (curSeq.last + curSeq(curSeq.length - 2)))
          }
        }

        fibTailRec(num, Seq(0, 1, 1))
    }
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text.map(letter => MORSE.getOrElse(letter.toUpper.toString, letter)).mkString(" ")

  def wordReverse(text: String): String = "\\pL+|\\PL".r.
    findAllIn(text)
    .map {
      case word if word.head.isUpper => word.toLowerCase.reverse.capitalize
      case word => word.reverse
    }.mkString("")
}
