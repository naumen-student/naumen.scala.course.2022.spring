import scala.util.Try
object Exercises {

  trait Reader[B] {
    def readValue(a: String): Either[String, B]
  }

  implicit class ReaderOps[B](value: String) {
    def read[B](implicit r: Reader[B]): Either[String, B] = r.readValue(value)
  }

  implicit val stringReader: Reader[String] = (a: String) => Right(a)

  implicit val intReader: Reader[Int] = (a: String) => Try(Right(a.toInt)).getOrElse(Left(s"Failed to read $a"))

  implicit def optReader[B: Reader]: Reader[Option[B]] = {
    case str if str.take(4) == "Some" =>
      str.drop(5).dropRight(1).read[B] match {
        case Right(value) => Right(Some(value))
        case Left(_) => Left("Failed to read")
      }
    case str if str == "None" =>
      Right(None)
    case _ =>
      Left("Failed to read")
  }

  object Read {
    def read[B](value: String)(implicit reader: Reader[B]): Either[String, B] = {
      reader.readValue(value)
    }
  }
}
