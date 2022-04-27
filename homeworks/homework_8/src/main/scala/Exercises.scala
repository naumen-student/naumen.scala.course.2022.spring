import scala.util.Try
import scala.util.matching.Regex

object Exercises {

  trait Read[T] { //Reader?
    def read(value: String): Either[String, T]
  }

  object Read {
    def read[T](value: String)(implicit reader: Read[T]): Either[String, T] = reader.read(value)
  }

  implicit def stringReader: Read[String] = new Read[String] {
    override def read(value: String): Either[String, String] = Right(value)
  }

  implicit def intReader: Read[Int] = new Read[Int] {
    override def read(value: String): Either[String, Int] = {
      if (value.forall(x => Character.isDigit(x)))
        Right(value.toInt)
      else Left("Value was not a correct representation of Int")
    }
  }

  implicit def optionReader[T: Read]: Read[Option[T]] = new Read[Option[T]] {
    override def read(value: String): Either[String, Option[T]] = {
      val pattern: Regex = "Some\\((.+)\\)".r
      value match {
        case "None" => Right(None)
        case _ => pattern.findFirstMatchIn(value) match {
          case Some(matchedValue) => Read.read[T](matchedValue.group(1)) match {
            case Right(readValue) => Right(Some(readValue))
            case Left(v) => Left(v)
          }
          case _ => Left("Value was not a correct representation")
        }
      }
    }
  }

  implicit class ReadOps(value: String) {
    def read[V]()(implicit reader: Read[V]): Either[String, V] = reader.read(value)
  }

}
