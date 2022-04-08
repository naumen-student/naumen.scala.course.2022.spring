import scala.util.matching.Regex

object Exercises {


    def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

    /**
     * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
     *
     * @param idx
     * @return
     */
    def fibonacci4Index(idx: Int): Int =
        idx match {
            case 0 => 0
            case 1 => 1
            case _ => fibonacci4Index(idx - 1) + fibonacci4Index(idx - 2)
        }

    def fibonacci(idx: Int): Seq[Int] =
        idx match {
            case 0 => Seq(0)
            case 1 => Seq(0, 1)
            case _ => fibonacci(idx - 1) :+ fibonacci4Index(idx)
        }

    lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
        "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
        "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
        "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
        "Y" -> "-.--", "Z" -> "--..")

    def morse(text: String): String = text
        .map(char => MORSE.getOrElse(char.toString.toUpperCase(), char))
        .mkString(" ")


    def wordReverse(text: String): String = {

        val pattern = new Regex("\\pL+")

        pattern.replaceAllIn(text, word => {
            val strWord = word.toString()
            if (strWord(0).isUpper)
                strWord.toLowerCase
                    .reverse
                    .capitalize
            else
                strWord.reverse
        })
    }
}
