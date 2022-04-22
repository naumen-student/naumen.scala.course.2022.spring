import scala.annotation.unused

object Exercises {
  trait Read[T] { def read(@unused string: String): Either[String, T] }

  implicit val stringRead: Read[String] = (string: String) => Right(string)

  implicit val intRead: Read[Int] = (string: String) => {
    val value = string.toIntOption
    if (value.isEmpty) Left("")
    else Right(value.get)
  }

  implicit def optionRead[T: Read]: Read[Option[T]] = (string: String) => {
    if (string == "None") Right(None)
    else if (string.startsWith("Some(") && string.endsWith(")") && string.length >= 7)
      string.substring(5, string.length - 1).read[T].map(a => Some(a))
    else Left("")
  }

  object Read { def read[T](string: String)(implicit read: Read[T]): Either[String, T] = read.read(string) }

  implicit class ReadOps(string: String) {
    def read[T]()(implicit read: Read[T]): Either[String, T] = read.read(string)
  }
}
