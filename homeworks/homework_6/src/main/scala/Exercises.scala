import scala.collection.mutable

object Exercises {

  def reverse[T](seq: Seq[T]): Seq[T] = {
    if (seq.isEmpty) {
      return Nil
    }
    Seq(seq.last) ++ reverse(seq.init)
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */

  def fibonacci4Index(idx: Int): Int = {
    if (idx == 0) {
      return 0
    } else if (idx == 1) {
      return 1
    }
    val count = mutable.MutableList[Int](0, 1)
    for (i <- 1 until idx) {
      count += (count(count.size-2) + count.last)
    }
    count.last
  }

  def fibonacci(idx: Int): Seq[Int] = {
    if (idx == 0) {
      return Seq(0)
    }
    var res = mutable.MutableList(0, 1)
    for (i <- 1 until (idx)) {
      res += (res(res.size - 2) + res.last)
    }
    res
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    val res = new StringBuilder()
    for (i <- text.indices) {
      if (i != 0 && !"!?.,".contains(text(i))) {
        res.append(' ')
      }
      if (MORSE.contains(text(i).toUpper.toString)) {
        res.append(MORSE(text(i).toUpper.toString))
      } else {
        res.append(text(i))
      }
    }
    res.toString()
  }

  def wordReverse(text: String): String = {
    val textTmp = text + " "
    val res = new StringBuilder()
    val tmp = new StringBuilder()
    for (i <- textTmp) {
      if ("!?.,\"\' ".contains(i)) {
        if (tmp.nonEmpty) {
          tmp.reverseContents()
          if (tmp.last.isUpper) {
            tmp.setCharAt(tmp.size-1, tmp(tmp.size-1).toLower)
            tmp.setCharAt(0, tmp(0).toUpper)
          }
          res.append(tmp)
          tmp.clear()
        }
        res.append(i)
      } else {
        tmp.append(i)
      }
    }
    res.deleteCharAt(res.size-1)
    res.toString()
  }
}