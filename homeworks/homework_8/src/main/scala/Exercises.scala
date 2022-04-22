import scala.util.{Failure, Success, Try}
object Exercises {

  trait Read[T] {
    def read(value: String):Either[String, T]
  }

  object Read {
    def read[T](value: String)(implicit reader: Read[T]): Either[String, T] = reader.read(value)
  }

  implicit val intRead: Read[Int] = (value: String) => Try(value.toInt) match {
    case Success(v) => Right(v)
    case Failure(_) => Left(value)
  }

  implicit val stringRead: Read[String] = (value: String) => Right(value)

  implicit class ReadOps(value: String) {
    def read[T](implicit reader: Read[T]): Either[String, T] = reader.read(value)
  }

  private val pattern = "Some\\((.+)\\)".r

  implicit def operationRead[T: Read](implicit reader: Read[T]): Read[Option[T]] =
  {
    case "None" => Right(None)
    case value => pattern.findFirstMatchIn(value) match {
      case Some(str) => reader.read(str.group(1)) match {
        case Right(value) => Right(Some(value))
        case Left(_) => Left(value)
      }
      case None => Left(value)
    }
  }
}
