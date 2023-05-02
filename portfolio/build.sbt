lazy val http4sVersion  = "0.23.14"
lazy val circeVersion   = "0.14.5"

lazy val scalatest      = "org.scalatest"       %% "scalatest"            % "3.2.15"    % Test
lazy val scalatestplus  = "org.scalatestplus"   %% "scalacheck-1-14"      % "3.2.2.0"   % Test
lazy val mockito        = "org.scalatestplus"   %% "mockito-4-6"          % "3.2.15.0"  % Test

lazy val blazeServer    = "org.http4s"          %% "http4s-blaze-server"  % http4sVersion
lazy val http4sDsl      = "org.http4s"          %% "http4s-dsl"           % http4sVersion
lazy val http4sCirce    = "org.http4s"          %% "http4s-circe"         % http4sVersion

lazy val circeGeneric   = "io.circe"            %% "circe-generic"        % circeVersion
lazy val circeLiteral   = "io.circe"            %% "circe-literal"        % circeVersion
lazy val circeCore      = "io.circe"            %% "circe-core"           % circeVersion

ThisBuild / organization := "ru.bmstu"
ThisBuild / scalaVersion := "2.12.16"
ThisBuild / version      := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "portfolio",
    libraryDependencies ++= Seq(
      scalatest,
      scalatestplus,
      mockito,
    ),
    libraryDependencies ++= Seq(
      circeGeneric,
      circeLiteral,
      circeCore,

      http4sDsl,
      http4sCirce,

      "dev.zio" %% "zio" % "2.0.10",
      "dev.zio" %% "zio-json" % "0.4.2",
      "dev.zio" %% "zio-streams" % "2.0.10",
      "io.d11" %% "zhttp" % "2.0.0-RC11",

//      "com.typesafe.akka" %% "akka-http" % "10.5.0",
//      "com.typesafe.akka" %% "akka-http-spray-json" % "10.5.0",
//      "com.typesafe.akka" %% "akka-stream" % "2.8.0",
//      "io.swagger.core.v3" % "swagger-jaxrs2" % "2.2.8",
//      "org.webjars" % "swagger-ui" % "4.18.1",
      "com.nimbusds" % "nimbus-jose-jwt" % "9.30.2",
//      "com.github.swagger-akka-http" %% "swagger-akka-http" % "2.10.0",
//      "com.typesafe.akka" %% "akka-http-spray-json" % "10.5.0"
    )
  )