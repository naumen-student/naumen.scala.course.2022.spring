import scala.annotation.tailrec
import DataList.{EmptyList, NonEmptyList}

object ListOps {

  def foldOption[T](f: (T, T) => T): DataList[T] => Option[T] = {
    case NonEmptyList(head, tail) => foldOption(f)(tail) match {
      case Some(value) => Some(f(head, value))
      case None => Some(head)
    }
    case EmptyList => None
  }

  def sum[T : Numeric](list: DataList[T]): T = {
    def sumT(a: T, b: T) = implicitly[Numeric[T]].plus(a, b)
    foldOption(sumT)(list).getOrElse(implicitly[Numeric[T]].zero)
  }

  @tailrec
  private def filterImpl[T](f: T => Boolean)(buffer: DataList[T])(l: DataList[T]): DataList[T] = l match {
    case EmptyList => reverse(buffer, EmptyList)
    case NonEmptyList(head, tail) =>
      filterImpl(f)(if (f(head)) NonEmptyList(head, buffer) else buffer)(tail)
  }

  @tailrec
  def reverse[T](l: DataList[T], buffer: DataList[T]): DataList[T] = l match {
    case NonEmptyList(head, tail) => reverse(tail, NonEmptyList(head, buffer))
    case EmptyList => buffer
  }

  final def filter[T](f: T => Boolean): DataList[T] => DataList[T] = filterImpl(f)(DataList.EmptyList)

  final def map[A, B](f: A => B): DataList[A] => DataList[B] = {
    case DataList.EmptyList => DataList.EmptyList
    case DataList.NonEmptyList(head, tail) => DataList.NonEmptyList(f(head), map(f)(tail))
  }

  def collect[A, B](f: PartialFunction[A, B]): DataList[A] => DataList[B] = filter(f.isDefinedAt).andThen(map(f))

}