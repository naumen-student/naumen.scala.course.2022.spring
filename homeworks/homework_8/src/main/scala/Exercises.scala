import scala.util.{Failure, Success, Try}
object Exercises {
  trait Read[T]{
    def read(value: String): Either[String, T];
  }

  object Read{
    def read[T](value: String)(implicit read: Read[T]): Either[String, T]  = read.read(value);
  }

  implicit class ReadOps(value: String){
    def read[T](implicit reader: Read[T]): Either[String, T]  = reader.read(value);
  }

  implicit val stringRead: Read[String] = (value: String) => Right(value)


  implicit val intRead: Read[Int] = (value: String) => {
    Try(value.toInt) match {
      case Success(x) => Right(x)
      case Failure(_) => Left(value)
    }
  }

  private val somePattern = "Some\\((.+)\\)".r

  implicit def optionRead[T: Read](implicit reader: Read[T]): Read[Option[T]] = {
    case "None" => Right(None);
    case value => somePattern.findFirstMatchIn(value) match {
      case Some(i) => reader.read(i.group(1)).toOption match {
        case Some(i) => Right(Some(i))
        case None => Left(value);
      };
      case None => Left(value);
    }
  }
}
