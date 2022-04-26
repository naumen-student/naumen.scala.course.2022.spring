import scala.util.{Failure, Success, Try}
object Exercises {

  private val somePattern = "Some\\((.+)\\)".r

  trait Read[T] {
    def read(value: String): Either[String, T]
  }

  implicit class ReadOps(value: String) {
    def read[T](implicit reader: Read[T]) = reader.read(value)
  }

  implicit val stringRead: Read[String] = Right(_)


  implicit val intRead: Read[Int] = value => {
    Try(value.toInt) match {
      case Success(x) => Right(x)
      case Failure(_) => Left(value)
    }
  }

  object Read {
    def read[T](value: String)(implicit read: Read[T]) = read.read(value)
  }

  implicit def optionRead[T: Read](implicit reader: Read[T]): Read[Option[T]] = {
    case "None" => Right(None);
    case value => somePattern.findFirstMatchIn(value) match {
      case Some(str) => reader.read(str.group(1)).toOption match {
        case Some(x) => Right(Some(x))
        case None => Left(value);
      };
      case None => Left(value);
    }
  }
}
