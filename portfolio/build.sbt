lazy val scalatest      = "org.scalatest"       %% "scalatest"        % "3.2.15"    % Test
lazy val scalatestplus  = "org.scalatestplus"   %% "scalacheck-1-14"  % "3.2.2.0"   % Test
lazy val mockito        = "org.scalatestplus"   %% "mockito-4-6"      % "3.2.15.0"  % Test

ThisBuild / organization := "ru.bmstu"
ThisBuild / scalaVersion := "2.12.16"
ThisBuild / version      := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "portfolio",
    libraryDependencies += scalatest,
    libraryDependencies += scalatestplus,
    libraryDependencies += mockito,
    libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "2.4.2",
      libraryDependencies ++= Seq(
          "org.postgresql" % "postgresql" % "42.5.4"
    )


  )