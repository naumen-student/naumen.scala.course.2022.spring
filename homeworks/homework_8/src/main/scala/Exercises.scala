import scala.util.{Failure, Success, Try}
object Exercises {

  trait Read[T] {
    def read(str: String): Either[String, T]
  }

  object Read {
    def read[T](v: String)(implicit read: Read[T]): Either[String, T] = read.read(v)
  }

  implicit class ReadOps(v: String) {
    def read[T](implicit reader: Read[T]): Either[String, T] = reader.read(v)
  }

  implicit val stringReader: Read[String] = Right(_)

  implicit val intReader: Read[Int] = (v: String) => {
    Try(v.toInt) match {
      case Success(num) => Right(num)
      case Failure(_) => Left("Value can not be converted to Int")
    }
  }

  implicit def optionReader[T: Read](implicit reader: Read[T]): Read[Option[T]] = {
    case "None" => Right(None)
    case v => OptionSomeReg.findFirstMatchIn(v) match {
      case Some(inside1) => reader.read(inside1.group(1)).toOption match {
        case Some(inside2) => Right(Some(inside2))
        case None => Left(v)
      }
      case None => Left(v)
    }
  }

  private val OptionSomeReg = "Some\\((.+)\\)".r

}
