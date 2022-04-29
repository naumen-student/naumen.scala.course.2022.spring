import scala.annotation.tailrec

object ListOps {

  /** Функция fold "сворачивает" список из Т в один элемент типа Т.
   * Если в списке лишь один элемент, то он и вернётся, два - вернётся результат применения f к этим элементам,
   * больше двух - результат применения к f(f(f(...), a[i - 1]), a[i])
   *
   * @param f функция свёртывания. Применяется попарно к предыдущему результату применения и i-ому элементу списка
   * @return None - если список пустой
   */
  def foldOption[T](f: (T, T) => T): DataList[T] => Option[T] = {
    @tailrec
    def calculate(list: DataList[T], acc: Option[T]): Option[T] =
      (acc, list) match {
        case (None, DataList.NonEmptyList(head, tail)) =>
          calculate(tail, Some(head))
        case (Some(accValue), DataList.NonEmptyList(head, tail)) =>
          calculate(tail, Some(f(accValue, head)))
        case (_, DataList.EmptyList) => acc
      }

    calculate(_, None)
  }

  /** Используя foldOption[T](f: (T, T) => T) реализуйте суммирование всех элементов списка.
   *
   * @return Если список пустой, то 0
   */
  def sum[T: Numeric](list: DataList[T]): T = {

    /** Используйте для суммирования двух чисел любого типа (Int, Long, Double, Float etc)
     */
    def sumT(a: T, b: T): T = implicitly[Numeric[T]].plus(a, b)

    foldOption(sumT)(list).getOrElse(implicitly[Numeric[T]].zero)
  }

  /** Фильтрация списка. Хвостовая рекурсия
   *
   * @param f - фильтрующее правило (если f(a[i]) == true, то элемент остаётся в списке)
   */
  @tailrec
  private def filterImpl[T](
                             f: T => Boolean
                           )(buffer: DataList[T])(l: DataList[T]): DataList[T] =
  {
    @tailrec
    def listReverse(list: DataList[T])(acc: DataList[T]): DataList[T] =
      list match {
        case DataList.NonEmptyList(head, tail) => listReverse(tail)(DataList.NonEmptyList(head, acc))
        case DataList.EmptyList => acc
      }

    l match {
      case DataList.NonEmptyList(head, tail) if f(head) =>
        filterImpl(f)(DataList.NonEmptyList(head, buffer))(tail)
      case DataList.NonEmptyList(_, tail) => filterImpl(f)(buffer)(tail)
      case DataList.EmptyList => listReverse(buffer)(DataList.EmptyList)
    }
  }

  final def filter[T](f: T => Boolean): DataList[T] => DataList[T] =
    filterImpl(f)(DataList.EmptyList)

  final def map[A, B](f: A => B): DataList[A] => DataList[B] = {
    case DataList.EmptyList => DataList.EmptyList
    case DataList.NonEmptyList(head, tail) =>
      DataList.NonEmptyList(f(head), map(f)(tail))
  }

  /** Используя композицию функций реализуйте collect. Collect - комбинация filter и map.
   * В качестве фильтрующего правила нужно использовать f.isDefinedAt
   */
  def collect[A, B](f: PartialFunction[A, B]): DataList[A] => DataList[B] =
    list => map(f)(filter(f.isDefinedAt)(list))
}
