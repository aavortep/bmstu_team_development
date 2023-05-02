package ru.bmstu.portfolio

import ru.bmstu.portfolio.controller.{AlbumController, UserController}
import zio.{Random, Scope, ZIO, ZIOAppArgs, ZIOAppDefault}
import zhttp.http._
import zhttp.service.Server
import zio.Console.printLine

object Main extends ZIOAppDefault {

  val port = 8090

  val userController = new UserController
  val albumController = new AlbumController

  val routeRules = userController.openRest ++ albumController.openRest

  val httpApp = for {
    _ <- printLine(s"Starting server at http://localhost:$port")
    _ <- Server.start(port, routeRules)
  } yield ()

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = httpApp
}