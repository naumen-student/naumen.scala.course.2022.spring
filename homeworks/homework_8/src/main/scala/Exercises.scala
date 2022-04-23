import scala.util.{Failure, Success, Try}
import scala.util.matching.Regex
object Exercises {

  trait Read[T] {
    def read(value: String): Either[String, T]
  }

  object Read {
    def read[T](value: String)(implicit reader: Read[T]): Either[String, T] = reader.read(value)
  }

  implicit def stringReader: Read[String] = new Read[String] {
    override def read(value: String): Either[String, String] = Right(value)
  }

  implicit def intReader: Read[Int] = new Read[Int] {
    override def read(value: String): Either[String, Int] = {
      Try(value.toInt) match {
        case Success(x) => Right(x)
        case Failure(_) => Left(value)
      }
    }
  }

  val pattern: Regex = "Some\\((.+)\\)".r

  implicit def optionReader[T: Read]: Read[Option[T]] = new Read[Option[T]] {
    override def read(value: String): Either[String, Option[T]] = {
      value match {
        case "None" => Right(None)
        case _ => pattern.findFirstMatchIn(value) match {
          case Some(str) => Read.read[T](str.group(1)) match {
            case Right(x) => Right(Some(x))
            case Left(v) => Left(v)
          }
          case _ => Left(value)
        }
      }
    }
  }

  implicit class ReadOps(value: String) {
    def read[V]()(implicit reader: Read[V]): Either[String, V] = reader.read(value)
  }
}
