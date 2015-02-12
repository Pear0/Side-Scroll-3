lazy val root = (project in file(".")).enablePlugins(ScalaJSPlugin)

name := "Side-Scroll-3"

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0"