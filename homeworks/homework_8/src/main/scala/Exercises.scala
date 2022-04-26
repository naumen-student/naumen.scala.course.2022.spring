import scala.util.matching.Regex
import scala.util.{Failure, Success, Try}

object Exercises {
  trait Read[T] {
    def read(str: String) : Either[String, T];
  }

  object Read {
    def read[T](str: String)(implicit read: Read[T]): Either[String, T] = read.read(str);
  }

  implicit class ReadOps(str: String) {
    def read[T](implicit read: Read[T]) : Either[String, T] = read.read(str);
  }

  implicit def intRead: Read[Int] = new Read[Int] {
    override def read(x: String): Either[String, Int] = {
      toInt(x) match {
        case Success(x) => Right(x);
        case Failure(_) => Left(x);
      }
    }
  }

  val pattern: Regex = "Some\\((.+)\\)".r;

  implicit def optionRead[T: Read]: Read[Option[T]] = new Read[Option[T]] {
    override def read(value: String): Either[String, Option[T]] = {
      value match {
        case "None" => Right(None);
        case _ => pattern.findFirstMatchIn(value) match {
          case Some(str) => Read.read[T](str.group(1)) match {
            case Right(x) => Right(Some(x));
            case Left(v) => Left(v);
          }
          case _ => Left(value);
        }
      }
    }
  }

  implicit def stringRead: Read[String] = new  Read[String] {
    override def read(str: String): Either[String, String] = Right(str);
  }
}
