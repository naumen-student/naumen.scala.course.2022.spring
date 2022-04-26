import scala.util.matching.Regex
import scala.util.{Failure, Success, Try}

object Exercises {
  trait Read[T]{
    def read(str: String) : Either[String, T]
  }

  object Read{
    def read[T](str: String)(implicit read: Read[T]): Either[String, T] = read.read(str)
  }

  implicit class ReadOps(str: String){
    def read[T](implicit read: Read[T]) : Either[String, T] = read.read(str)
  }

  implicit def stringRead: Read[String] = new  Read[String] {
    override def read(str: String): Either[String, String] = Right(str)
  }

  implicit def intRead: Read[Int] = new Read[Int] {
    override def read(str: String): Either[String, Int] = Try(str.toInt) match {
      case Success(value) => Right(value)
      case Failure(exception) => Left("Failed to read a number")
    }
  }

  val pattern: Regex = "Some\\((.+)\\)".r

  implicit def optionRead[T : Read]: Read[Option[T]] = new Read[Option[T]] {
    override def read(str: String) : Either[String, Option[T]] = str match {
      case "None" => Right(None)
      case _ => pattern.findFirstMatchIn(str) match {
        case Some(opt) => Read.read[T](opt.group(1)) match {
          case Right(value) => Right(Some(value))
          case Left(_) => Left("Failed to read option value")
        }
        case None => Left("Incorrect format")
      }
    }
  }
}
