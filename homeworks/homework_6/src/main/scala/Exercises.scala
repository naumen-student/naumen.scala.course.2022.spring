import scala.collection.mutable.Stack
import scala.util.matching.Regex

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = {
    val stack: Stack[T] = Stack[T]()
    var newSeq: Seq[T] = Seq()
    for (x <- seq)
      stack.push(x)
    while (stack.nonEmpty)
      newSeq = newSeq :+ stack.pop()
    newSeq
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci(idx: Int): Seq[Int] = {
    if (idx == 0) Seq(0)
    else if (idx == 1) Seq(0, 1)
    else {
      val F: Array[Int] = new Array[Int](idx + 1)
      F(0) = 0
      F(1) = 1
      for (i <- 2 to idx)
        F(i) = F(i-1) + F(i-2)
      F.toSeq
    }
  }

  def fibonacci4Index(idx: Int): Int = fibonacci(idx)(idx)




  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text.map(c => MORSE.getOrElse(c.toUpper.toString, c)).mkString(" ")


  def wordReverse(text: String): String = {
    new Regex("\\pL+|\\PL").findAllIn(text).map { word =>
      val reversedWord = word.reverse
      if (reversedWord.last.isUpper)
        reversedWord.toLowerCase.capitalize
      else
        reversedWord
    }.mkString("")
  }
}
