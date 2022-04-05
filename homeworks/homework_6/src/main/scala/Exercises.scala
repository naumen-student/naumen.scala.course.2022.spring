object Exercises {
  def reverse[T](seq: Seq[T]): Seq[T] = seq.foldLeft(Nil: Seq[T])((acc, v) => v +: acc)

  def hylo[A, B](coalgebra: A => Seq[A], algebra: Seq[B] => B)(a: A): B =
    algebra(coalgebra(a).map(hylo(coalgebra, algebra)))

  def fibonacci4Index(idx: Int): Int = idx match {
    case x if x > 0 => hylo[Int, Int](
      coalgebra = x => x match {
        case x if x > 2 => x - 1 :: x - 2 :: Nil
        case _ => Nil
      },
      algebra = x => x.sum match {
        case x if x > 0 => x
        case _ => 1
      })(idx)
    case _ => 0
  }

  def fibonacci(idx: Int): Seq[Int] = Range.inclusive(0, idx).map(fibonacci4Index)

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text.map(x => MORSE.getOrElse(x.toUpper.toString, x)).mkString(" ")

  val wordParser = "\\w+".r

  def wordReverse(text: String): String = {
    def reverse(string: String): String = string.headOption.map(head => head match {
      case h if h.isUpper => string.tail.reverse.capitalize + h.toLower
      case _ => string.reverse
    }).getOrElse("")

    text.foldLeft(("", ""))((acc, v) => acc match {
      case (res, acc) => v match {
        case v if v.isLetter => (res, acc + v)
        case v => (res + reverse(acc) + v, "")
      }
    }
    ) match {
      case (res, acc) => res + acc
    }
  }
}
