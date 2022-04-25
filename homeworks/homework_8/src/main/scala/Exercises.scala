import scala.util.{Failure, Success, Try}

object Exercises {
  trait Reader[T] {
    def read(str: String): Either[String, T]
  }
  object Read{
    def read[T](str: String)(implicit reader: Reader[T]): Either[String, T] = reader.read(str)
  }

  implicit class ExtendingClass(str: String) {
    def read[V](implicit reader: Reader[V]): Either[String, V] = reader.read(str)
  }

  implicit def readerStr: Reader[String] = (str: String) => Right(str)

  implicit def readerInt: Reader[Int] = (str: String) => Try(str.toInt) match {
      case Success(str) => Right(str)
      case Failure(e: Exception) => Left(e.getMessage)
      case _ => Left(s"Failed to read from $str")
    }

  implicit def readerOption[T: Reader]: Reader[Option[T]] = {
    case "None" => Right(None)
    case str => "Some\\((.+)\\)".r.findFirstMatchIn(str) match {
      case Some(str) => Read.read[T](str.group(1)) match {
        case Right(str) => Right(Some(str))
        case Left(str) => Left(s"Failed to read from $str")
      }
      case _ => Left(s"Failed to read from $str")
    }
  }
}