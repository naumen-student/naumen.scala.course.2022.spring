import scala.annotation.tailrec
import cats.syntax.all._
import DataList._

object ListOps {
  implicit class DataListOps[T](dataList: DataList[T]) {

    def ::(value: T): DataList[T] = NonEmptyList(value, dataList)

    def reverse: DataList[T] = {
      @tailrec
      def reverseTailRec(buffer: DataList[T])(l: DataList[T]): DataList[T] =
        l match {
          case NonEmptyList(head, tail) => reverseTailRec(head :: buffer)(tail)
          case EmptyList                => buffer
        }
      reverseTailRec(EmptyList)(dataList)
    }

    def map[B](f: T => B): DataList[B] = {
      @tailrec
      def mapTailRec(buffer: DataList[B])(l: DataList[T]): DataList[B] =
        l match {
          case NonEmptyList(head, tail) => mapTailRec(f(head) :: buffer)(tail)
          case EmptyList                => buffer.reverse
        }
      mapTailRec(EmptyList)(dataList)
    }
  }

  /**
   * Функция fold "сворачивает" список из Т в один элемент типа Т.
   * Если в списке лишь один элемент, то он и вернётся, два - вернётся результат применения f к этим элементам,
   * больше двух - результат применения к f(f(f(...), a[i - 1]), a[i])
   * @param f функция свёртывания. Применяется попарно к предыдущему результату применения и i-ому элементу списка
   * @return None - если список пустой
   */

  def foldOption[T](f: (T, T) => T): DataList[T] => Option[T] = {
    @tailrec
    def foldLeft(acc: T)(list: DataList[T]): T =
      list match {
        case NonEmptyList(head, tail) => foldLeft(f(acc, head))(tail)
        case EmptyList                => acc
      }
    {
      case NonEmptyList(head, tail) => foldLeft(head)(tail).some
      case EmptyList                => none
    }
  }

  /**
   * Используя foldOption[T](f: (T, T) => T) реализуйте суммирование всех элементов списка.
   * @return Если список пустой, то 0
   */
  def sum[T: Numeric](list: DataList[T])(implicit numeric: Numeric[T]): T =
    ListOps.foldOption(numeric.plus).apply(list).getOrElse(numeric.zero) //Кошачий Monoid хочется...

  /**
   * Фильтрация списка. Хвостовая рекурсия
   * @param f - фильтрующее правило (если f(a[i]) == true, то элемент остаётся в списке)
   */
  @tailrec
  private def filterImpl[T](f: T => Boolean)(buffer: DataList[T])(l: DataList[T]): DataList[T] =
    l match {
      case NonEmptyList(head, tail) if f(head) => filterImpl(f)(head :: buffer)(tail)
      case NonEmptyList(head, tail)            => filterImpl(f)(buffer)(tail)
      case EmptyList                           => buffer.reverse
    }

  final def filter[T](f: T => Boolean): DataList[T] => DataList[T] = filterImpl(f)(EmptyList)

  final def map[A, B](f: A => B): DataList[A] => DataList[B] = _.map(f)

  /**
   * Используя композицию функций реализуйте collect. Collect - комбинация filter и map.
   * В качестве фильтрующего правила нужно использовать f.isDefinedAt
   */
  def collect[A, B](f: PartialFunction[A, B]): DataList[A] => DataList[B] = filter(f.isDefinedAt).andThen(map(f))
}
