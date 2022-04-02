name := "ServerTest"

version := "0.1"

scalaVersion := "2.13.8"

libraryDependencies += "org.typelevel" %% "cats-core" % "2.7.0"
//libraryDependencies += "org.typelevel" %% "cats-effect" % "3.2.5"
libraryDependencies += "dev.zio" %% "zio" % "2.0.0-M6-2"
libraryDependencies += "dev.zio" %% "zio-interop-cats" % "3.3.0-RC2"
libraryDependencies += "io.estatico" %% "newtype" % "0.4.4"

addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.0")
