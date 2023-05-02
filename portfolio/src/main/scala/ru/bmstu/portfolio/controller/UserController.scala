package ru.bmstu.portfolio.controller

import io.circe.generic.auto._
import io.circe.syntax._
import ru.bmstu.portfolio.dto.{CommandResult, NotFoundException}
import ru.bmstu.portfolio.service.UserService
import zhttp.http._

//* /users/home - аккаунт пользователя
//* /users?name=...?country=...&city=...&prof=...&page=...&amount=... - поиск авторов
//* /users/login - аккаунт пользователя
//* /users/logout - аккаунт пользователя

//* /users?name=...?country=...&city=...&prof=...&page=...&amount=... - поиск авторов

class UserController {
  val openRest: Http[Any, Nothing, Request, Response] = Http.collect[Request] {
    case req @ Method.POST -> !! / "users" / "login" => {
      Response.json(UserService.login("user", "password")
      .getOrElse(throw new NotFoundException("Wrong Email/Password"))
      .asJson.toString())
    }

    case Method.GET -> !! / "users" / (userId: String) if userId.matches("""\d+""") =>
      Response.json(UserService.userPage(userId.toInt)
        .getOrElse(throw new NotFoundException("User wasn't found"))
        .asJson.noSpaces
      )

    case Method.GET -> !! / "users" =>
      Response.json(UserService.getUsers().asJson.toString())
  }

  val protectedRest: Http[Any, Nothing, Request, Response] = Http.collect[Request] {
    case req @ Method.GET -> !! / "users" / "home" => {
      val uid = 0//
      val data = UserService.userPage(uid)
      Response.json(UserService.userPage(uid)
      .getOrElse(throw new NotFoundException("User not found"))
      .asJson.toString())
    }

    case Method.POST -> !! / "users" =>
      Response.json(CommandResult(true, "User created").asJson.toString())

    case Method.PUT -> !! / "users" / (userId: String) if userId.matches("""\d+""") =>
      Response.json(UserService.userPage(userId.toInt).getOrElse(throw new NotFoundException("..."))
      .asJson.toString())

    case Method.DELETE -> !! / "users" / (userId: String) if userId.matches("""\d+""") =>
      Response.json(CommandResult(true, "User deleted").asJson.toString())
  }
}