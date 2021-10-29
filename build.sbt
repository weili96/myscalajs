//Note that for compiling and running your application, you will still need to use sbt from the command line.

enablePlugins(ScalaJSPlugin)

name := "myscalajs"

version := "0.1"

scalaVersion := "2.13.6"

// This is an application with a main method
scalaJSUseMainModuleInitializer := true

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.1.0"