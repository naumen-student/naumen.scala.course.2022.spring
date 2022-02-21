import zio._
import cats.syntax.all._
import zio.interop.catz.core._

object Main extends ZIOAppDefault {
  private def createHelloWorldText(
    helloText: String,
    personText: String
  ): String =
    helloText + " Scala! This is " + personText

  override def run: ZIO[ZEnv with ZIOAppArgs, Any, Any] =
    for {
      person <- "Vyacheslav".pure[UIO]
      persons = person :: person.reverse :: Nil
      helloTexts = "Hello" :: "Hola" :: "Guten tag" :: Nil
      helloWorlds = for {
        p <- persons
        h <- helloTexts
      } yield createHelloWorldText(h, p)
      _ <- ZIO.foreach(helloWorlds)(s => Console.printLine(s))
    } yield ()
}
