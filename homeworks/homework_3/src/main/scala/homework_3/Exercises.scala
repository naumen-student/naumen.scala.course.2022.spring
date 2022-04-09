package homework_3

object Exercises {

    final val falseStr = "ложь"
    final val trueStr = "правда"
    private final val boolClassName = "java.lang.Boolean"

    def prettyBooleanFormatter1(x: Any): String = x match {
        case bool: Boolean => printBoolean(bool)
        case _ => x.toString
    }

    def prettyBooleanFormatter2(x: Any): String = x match {
        case value: Boolean => printBoolean(value)
        case _              => x.toString
    }

    def prettyBooleanFormatter3(x: Any): String = if (
        x.getClass.getName == boolClassName
    ) printBoolean(x.asInstanceOf[Boolean])
    else x.toString

    private def printBoolean(value: Boolean): String =
        if (value) trueStr else falseStr

    def sum1(x: Int, y: Int): Int = sumIntegers(Seq(x, y))
    def sum2(x: Int, y: Int): Int = sumIntegers(List(x, y))
    def sum3(x: Int, y: Int): Int = sumIntegers(IntPair(x, y))

    private def sumIntegers[CollectionType <: Iterable[Int]](xs: CollectionType): Int =
        xs.sum

    def max1(xs: Seq[Int]): Int = if (xs.isEmpty) Int.MinValue else xs.max
    def max2(xs: Seq[Int]): Seq[Int] = if (xs.isEmpty) Seq() else Seq(xs.max)
    def max3(xs: Seq[Int]): Option[Int] = if (xs.isEmpty) None else Some(xs.max)


    case class IntPair(x: Int, y: Int) extends Iterable[Int] {
        override def iterator: Iterator[Int] = Iterator(x, y)
    }
}