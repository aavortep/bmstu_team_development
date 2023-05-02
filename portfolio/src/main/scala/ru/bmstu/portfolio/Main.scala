package ru.bmstu.portfolio

import ru.bmstu.portfolio.config.AuthMiddleware
import ru.bmstu.portfolio.controller.{AlbumController, UserController}
import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}
import zhttp.service.Server
import zio.Console.printLine

object Main extends ZIOAppDefault {
  val port = 8090

  val userController = new UserController
  val albumController = new AlbumController
  val authMiddleware = new AuthMiddleware

  val openApi = userController.openRest ++ albumController.openRest
  val protectedApi = userController.protectedRest ++ albumController.protectedRest
  val protectedWithAuth = protectedApi @@ authMiddleware.auth
  val routes = openApi ++ protectedWithAuth

  val httpApp = for {
    _ <- printLine(s"Starting server at http://localhost:$port")
    _ <- Server.start(port, routes)
  } yield ()

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = httpApp
}