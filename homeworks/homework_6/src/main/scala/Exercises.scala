import scala.annotation.tailrec
import scala.util.matching.Regex

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {
    //формула Бине
    math.round((math.pow((1 + math.sqrt(5)) / 2, idx) - math.pow((1 - math.sqrt(5)) / 2, idx)) / math.sqrt(5))
      .asInstanceOf[Int]
  }

  def fibonacci(idx: Int): Seq[Int] = {
    idx match {
      case x if x < 0 => throw new IllegalArgumentException
      case 0 => Seq(0)
      case 1 => Seq(0, 1)
      case _ => fibRecursion(List(1, 0), idx)
    }
  }

  @tailrec
  private def fibRecursion(list: List[Int], n: Int): List[Int] = {
    n match {
      case x if x == list.length - 1 => list.reverse
      case _ => fibRecursion((list.head + list(1)) :: list, n)
    }
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    text.toUpperCase.split("").map(str => {
      MORSE.getOrElse(str, str)
    }).mkString(" ")
  }


  def wordReverse(text: String): String = {
    val pattern: Regex = "\\p{L}+".r
    pattern.replaceAllIn(text, m => {
      val str = m.toString()
      if (str(0).isUpper) {
        val arr = str.toCharArray
        arr(0) = arr(0).toLower
        val newArr = arr.reverse
        newArr(0) = newArr(0).toUpper
        newArr.mkString("")
      }
      else
        str.reverse
    })
  }
}
