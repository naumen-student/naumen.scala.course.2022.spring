object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {
    @scala.annotation.tailrec 
    def fib(idx: Int, prev: Int = 0, next: Int = 1): Int = idx match {
      case 0 => prev
      case 1 => next
      case _ => fib(idx - 1, next, (next + prev))
    }
    fib(idx)
  }

  def fibonacci(idx: Int): Seq[Int] = {
    @scala.annotation.tailrec 
    def fib(idx: Int, prev: Int = 0, next: Int = 1, acc: Seq[Int] = Nil): Seq[Int] = idx match {
      case 0 => 0 +: acc
      case 1 => Seq(0, 1) ++: acc
      case _ => fib(idx - 1, next, (next + prev), acc :+ (next + prev))
    }
    fib(idx)
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = 
    text.toUpperCase.map(l => Exercises.MORSE getOrElse (l.toString, l)).mkString(" ")


  def wordReverse(text: String): String = {
    val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя"
    
    val splittedText = text.split(" ").toList.map(w => w.partition(alphabet.contains(_)))
    val punctuation = splittedText.map(_._2)
    val words = splittedText.map(_._1)
    val reversedWords = words.map(w => 
      if (w.head.isUpper) w.toLowerCase.reverse.capitalize else w.reverse)
    reversedWords.zip(punctuation).map(w => List(w._1, w._2).foldLeft("")(_+_)).mkString(" ")
  }

}
