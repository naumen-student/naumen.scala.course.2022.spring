import scala.annotation.tailrec

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */

  def fibonacci4Index(idx: Int, fibonacciSeq: Seq[Int] = Seq(0, 1)): Int = {
    fibonacci(idx, fibonacciSeq).last
  }

  @tailrec
  def fibonacci(idx: Int, fibonacciSeq: Seq[Int] = Seq(0, 1)): Seq[Int] = {
    if (idx < 0) {
      throw new IllegalArgumentException
    } else if (fibonacciSeq.length < 2) {
      throw new IllegalArgumentException
    } else if (idx < fibonacciSeq.length) {
      fibonacciSeq.slice(0, idx + 1)
    } else {
      fibonacci(idx, fibonacciSeq.appended(fibonacciSeq.last + fibonacciSeq(fibonacciSeq.length - 2)))
    }
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    text.flatMap(char => {
      val upperChar = char.toUpper.toString
      if (MORSE.contains(upperChar)) {
        f" ${MORSE(upperChar)}"
      } else if (char.isSpaceChar) {
        f" $char"
      } else {
        char.toString
      }
    }).substring(1)
  }

  @tailrec
  def wordReverse(text: String, leftText: String = ""): String = {
    if (text.isEmpty) {
      return leftText
    }
    val spanText = text.span(_.isLetter)
    val firstWord = spanText._1.reverse
    val upperFirstWord = if (firstWord.last.isUpper) {
      f"${firstWord.head.toUpper}${firstWord.toLowerCase.substring(1)}"
    } else {
      firstWord
    }
    val secondSpanText = spanText._2.span(!_.isLetter)
    wordReverse(secondSpanText._2, leftText + upperFirstWord + secondSpanText._1)
  }
}
