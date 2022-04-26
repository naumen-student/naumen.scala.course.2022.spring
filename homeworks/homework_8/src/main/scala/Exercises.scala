import javax.naming.directory.InvalidAttributesException
import scala.util.matching.Regex

object Exercises {
  trait Reader[T] {
    def read(raw: String): Either[Throwable, T]
  }

  object Read {
    def read[T](raw: String)(implicit reader: Reader[T]): Either[Throwable, T] = reader.read(raw)
  }

  implicit class ReaderOps(raw: String) {
    def read[T: Reader](implicit reader: Reader[T]): Either[Throwable, T] = reader.read(raw)
  }

  implicit object StringReader extends Reader[String] {
    override def read(raw: String): Either[Throwable, String] = Right(raw)
  }
  implicit object IntReader extends Reader[Int] {
    override def read(raw: String): Either[Throwable, Int] =
      raw.toIntOption.toRight(new InvalidAttributesException(s"""string "$raw" can not be parsed to int"""))
  }
  implicit def optionReader[T](implicit innerReader: Reader[T]): Reader[Option[T]] =
    new Reader[Option[T]] {
      private val someRegex = "^Some\\((.*)\\)$".r
      private val noneRegex = "^None$".r
      override def read(raw: String): Either[Throwable, Option[T]] = {
        val isNone = noneRegex.findFirstIn(raw).isDefined
        val maybeSome = someRegex.findFirstMatchIn(raw).map(x => x.group(1))
        (isNone, maybeSome) match {
          case (true, None)       => Right(None)
          case (false, Some(raw)) => innerReader.read(raw).map(x => Some(x))
          case (_, _)             => Left(new InvalidAttributesException(s"""string "$raw" can not be parsed to option"""))
        }
      }
    }

  implicit class IntParseOps(val maybeInt: String) { //В 2.13 toIntOption есть из коробки
    private val intRegex: Regex = "^\\d+$".r
    def toIntOption: Option[Int] = intRegex.findFirstIn(maybeInt).map(_.toInt)
  }
}
