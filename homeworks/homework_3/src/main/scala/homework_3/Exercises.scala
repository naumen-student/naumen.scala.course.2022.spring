package homework_3

import scala.util.Try

object Exercises {

    /**
     * Задание №1
     * Реализуйте функцию, которая принимает любой тип и преобразует его в строку.
     * Для всех типов кроме Boolean достаточно воспользоваться стандартной функцией .toString.
     * Для типа Boolean сделайте особое преобразование: true -> "правда", false -> "ложь".
     *
     * Реализуйте функцию тремя разными способами, отличающимися тем, как определяется какой тип имеет значение переданное в аргументе.
     * Определение типа необходимо для реализации специальной логики работы с Boolean значениями, которая описана в условии выше.
     */
    def prettyBooleanFormatter1(x: Any): String =
        x match {
            case x: Boolean => x.toTaskFormat
            case _          => x.toString
        }

    def prettyBooleanFormatter2(x: Any): String =
        Try(x.asInstanceOf[Boolean]).toOption.map(_.toTaskFormat).getOrElse(x.toString)

    def prettyBooleanFormatter3(x: Any): String =
        x match {
            case x if x.getClass == classOf[java.lang.Boolean] => x.asInstanceOf[Boolean].toTaskFormat
            case _                                             => x.toString
        }

    implicit class BooleanFormatterOps(b: Boolean) {
        def toTaskFormat: String = if (b) "правда" else "ложь"
    }

    /**
     * Задание №2
     * Реализуйте функцию нахождения максимального числа в переданной коллекции интов (можно использовать все методы стандартной библиотеки).
     *
     * Реализуйте функцию тремя разными способами, отличающимися тем как функция себя ведет на пустой коллекции.
     * Обратите внимание на возвращаемые типы.
     */
    def max1(xs: Seq[Int]): Int = xs.max

    def max2(xs: Seq[Int]): Seq[Int] = xs.foldLeft(None: Option[Int])((acc, v) => acc.getOrElse(v).max(v).some).toSeq

    def max3(xs: Seq[Int]): Option[Int] = xs.some.filterNot(_.isEmpty).map(_.max)

    implicit class OptionSomeOps[A](a: A) { // Как же хочется импортировать котов
        def some: Some[A] = Some(a)
    }

    /**
     * Задание №3
     * Допустим дана функция sumIntegers, которая умеет суммировать числа.
     */
    def sumIntegers[CollectionType <: Iterable[Int]](xs: CollectionType): Int = xs.sum

    /**
     * Реализуйте на основе нее 3 варианта суммирования 2х чисел, отличающиеся способом передачи этих 2х чисел в функцию sumIntegers.
     * Как минимум одна из реализаций должна использовать тип данных (класс) написанный вами самостоятельно.
     */
    def sum1(x: Int, y: Int): Int = x :: y :: Nil sumIntegers
    def sum2(x: Int, y: Int): Int = IterableTuple(x, y).sumIntegers
    def sum3(x: Int, y: Int): Int = Branch(Leaf(x), Leaf(y)).sumIntegers

    case class IterableTuple[A](x: A, y: A) extends Iterable[A] {
        override def iterator: Iterator[A] = Iterator(x, y)
    }

    sealed trait Tree[A] extends Iterable[A]
    case class Leaf[A](value: A) extends Tree[A] {
        override def iterator: Iterator[A] = Iterator(value)
    }
    case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A] {
        override def iterator: Iterator[A] = left.iterator ++ right.iterator
    }

    implicit class SumIntegersOps(xs: Iterable[Int]) {
        def sumIntegers: Int = Exercises.sumIntegers(xs)
    }

}
