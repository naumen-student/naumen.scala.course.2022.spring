object Exercises {


  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")
  val fibStream: Stream[Int] = 0 #:: 1 #:: fibStream.zip(fibStream.tail).map(n => n._1 + n._2)

  def reverse[T](seq: Seq[T]): Seq[T] = seq.foldLeft(Seq[T]())((tail, el) => el +: tail)

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */

  def fibonacci4Index(idx: Int): Int = fibStream(idx)

  def fibonacci(idx: Int): Seq[Int] = fibStream.take(idx + 1)

  def morse(text: String): String = text.map(ch => MORSE.getOrElse(ch.toUpper.toString, ch)).mkString(" ")

  def wordReverse(text: String): String =
    "([а-яА-Яa-zA-Z]+|[^а-яА-Яa-zA-Z])".r.findAllIn(text).map(word =>
      if (word.head.isUpper) word.toLowerCase.reverse.capitalize
      else word.reverse
    ).mkString("")

}
