import scala.util.Try
import scala.util.matching.Regex

object Exercises {

  val regSome = new Regex("""Some\((\S+)\)""")

  trait Read[T] {
    def read(str: String): Either[String, T]
  }

  implicit class ImplicitRead(str: String) {
    def read[T]()(implicit read: Read[T]): Either[String, T] = read.read(str)
  }

  object Read {
    def read[T](str: String)(implicit read: Read[T]): Either[String, T] = read.read(str)

    implicit object readString extends Read[String] {
      def read(str: String): Either[String, String] = Right(str)
    }

    implicit object readInt extends Read[Int] {
      def read(str: String): Either[String, Int] = Try(str.toInt).toOption match {
        case Some(value) => Right(value)
        case None => Left("failed to parse")
      }
    }

    implicit def readOption[T: Read]: Read[Option[T]] = {
      case regSome(value) => value.read[T] match {
        case Right(value) => Right(Some(value))
        case Left(_) => Left("failed to read option")
      }
      case "None" => Right(None)
      case _ => Left("Unexpected")
    }
  }
}