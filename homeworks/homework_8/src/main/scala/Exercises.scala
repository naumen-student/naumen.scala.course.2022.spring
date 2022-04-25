import scala.util.{Failure, Success, Try}
object Exercises {
  private final val somePattern = "Some\\((.+)\\)".r
  private final val nonePattern = "None"

  trait Read[T] {
    def read(str: String): Either[String, T]
  }

  implicit class ReadOps(value: String) {
    def read[T](implicit reader: Read[T]): Either[String, T] = reader.read(value)
  }

  object Read {
    def read[T](value: String)(implicit read: Read[T]): Either[String, T] = read.read(value)
  }

  implicit val stringRead: Read[String] = Right(_)

  implicit val intReader: Read[Int] = (value: String) => {
    Try(value.toInt) match {
      case Success(x) => Right(x)
      case Failure(_) => Left(value)
    }
  }

  implicit def optionRead[T: Read](implicit reader: Read[T]): Read[Option[T]] = {
    case value if value == nonePattern => Right(None);
    case value => somePattern.findFirstMatchIn(value) match {
      case Some(str) => reader.read(str.group(1)).toOption match {
        case Some(x) => Right(Some(x))
        case None => Left(value);
      };
      case None => Left(value);
    }
  }
}