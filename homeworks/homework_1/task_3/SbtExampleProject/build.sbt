ThisBuild / version := "0.1.0-SNAPSHOT"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.0.0"
ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "SbtExampleProject"
  )
