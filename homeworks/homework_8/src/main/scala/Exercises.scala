import scala.util.Try

object Exercises {
  private val regex: util.matching.Regex = "Some\\((.+)\\)".r

  implicit def readString: Read[String] = (value: String) => Right(value)

  def toInt(s: String): util.Try[Int] = util.Try(Integer.parseInt(s.trim))

  implicit def readInt: Read[Int] = (x: String) => {
    toInt(x) match {
      case util.Success(x) => Right(x)
      case util.Failure(_) => Left(x)
    }
  }

  trait Read[T] {
    def read(str: String): Either[String, T]
  }

  object Read {
    def read[T](x: String)(implicit reader: Read[T]): Either[String, T] = reader.read(x)
  }

  implicit class ReadOps(value: String) {
    def read[V]()(implicit reader: Read[V]): Either[String, V] = reader.read(value)
  }

  implicit def optionReader[T: Read]: Read[Option[T]] = {
    case "None" => Right(None)
    case v => regex.findFirstMatchIn(v) match {
      case Some(str) => Read.read[T](str.group(1)) match {
        case Right(x) => Right(Some(x))
        case Left(x) => Left(x)
      }
      case _ => Left(v)
    }
  }
}
