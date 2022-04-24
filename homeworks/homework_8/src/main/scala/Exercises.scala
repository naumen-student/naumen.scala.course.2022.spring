import scala.util.Try

object Exercises {
  trait Read[T] {
    def read(string: String): Either[String, T]
  }

  object Read {
    def read[T](string: String)(implicit reader: Read[T]): Either[String, T] = {
      reader.read(string)
    }
  }

  implicit def readInt: Read[Int] =
    new Read[Int] {
      override def read(string: String): Either[String, Int] =
        try {
          Right(string.toInt)
        } catch {
          case e: Exception => Left(e.getMessage)
        }
    }

  implicit def readOption[A](implicit reader: Read[A]): Read[Option[A]] =
    new Read[Option[A]] {
      override def read(string: String): Either[String, Option[A]] = {
        try {
          if (string.startsWith("Some(") && string.endsWith(")")) {
            val res = reader.read(string.substring(5, string.length - 1))
            if (res.isRight)
              Right(res.toOption)
            else
              Left(string)
          } else if (string == "None")
            Right(None)
          else
            Left(string)
        } catch {
          case e: Exception => Left(e.getMessage)
        }
      }
    }

  implicit def readString: Read[String] =
    new Read[String] {
      override def read(string: String): Either[String, String] = {
          Right(string)
      }
    }

  implicit class ReadOps(string: String) {
    def read[T](implicit reader: Read[T]): Either[String, T] = {
      reader.read(string)
    }
  }
}
