import scala.util.matching.Regex
import scala.util.{Failure, Success, Try}

object Exercises {
  trait Read[T] {
    def read(value: String): Either[String, T]
  }

  object Read {
    def read[T](value: String)(implicit reader: Read[T]): Either[String, T] = reader.read(value)
  }

 implicit class ReadOps(value: String) {
   def read[T](implicit reader: Read[T]): Either[String, T] = reader.read(value)
 }

  implicit def readString: Read[String] = (value: String) => Right(value)

  implicit def readInt: Read[Int] = (value: String) => Try(value.toInt) match {
    case Success(value) => Right(value)
    case Failure(e: Exception) => Left(e.getMessage)
  }

  private val pattern: Regex = "Some\\((.+)\\)".r

  implicit def readOption[T: Read]: Read[Option[T]] = {
    case "None" => Right(None)
    case value => pattern.findFirstMatchIn(value) match {
      case Some(value) => Read.read[T](value.group(1)) match {
        case Right(value) => Right(Some(value))
        case Left(value) => Left(value)
      }
      case _ => Left(value)
    }
  }
}
