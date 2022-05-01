import scala.util.{Failure, Success, Try}
object Exercises {
  trait Read[T] {
    def read(string: String): Either[String, T]
  }

  object Read {
    def read[T](string: String)(implicit reader: Read[T]): Either[String, T] = reader.read(string)
  }

  implicit class ReadOps(string: String) {
    def read[T](implicit reader: Read[T]): Either[String, T] = reader.read(string)
  }

  implicit val stringReader: Read[String] = (string: String) => Right(string)

  implicit val integerReader: Read[Int] = (string: String) => {
    Try(string.toInt) match {
      case Success(value) => Right(value)
      case Failure(exception) => Left(exception.getMessage)
    }
  }

  implicit def optionReader[T: Read](implicit reader: Read[T]): Read[Option[T]] = {
    case "None" => Right(None)
    case value => "Some\\((.+)\\)".r.findFirstMatchIn(value) match {
      case Some(str) => reader.read(str.group(1)).toOption match {
        case Some(value) => Right(Some(value))
        case None => Left(value)
      }
      case None => Left(value)
    }
  }
}
