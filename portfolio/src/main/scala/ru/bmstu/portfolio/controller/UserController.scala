package ru.bmstu.portfolio.controller


import io.circe.generic.auto._
import io.circe.syntax._
import ru.bmstu.portfolio.command.user.LoginUserCommand
import ru.bmstu.portfolio.dto.NotFoundException
import ru.bmstu.portfolio.service.UserService
import zhttp.http._

//* /users/home - аккаунт пользователя
//* /users?name=...?country=...&city=...&prof=...&page=...&amount=... - поиск авторов
//* /users/login - аккаунт пользователя
//* /users/logout - аккаунт пользователя

//* /users?name=...?country=...&city=...&prof=...&page=...&amount=... - поиск авторов

class UserController {
  val openRest: UHttpApp = Http.collect[Request] {
    case req @ Method.POST -> !! / "users" / "login" => {
      Response.text("Answer")
    }
  } ++ Http.collect[Request] {
    case Method.GET -> !! / "users" / userId =>
      Response.json(UserService.userPage(Integer.parseInt(userId))
        .getOrElse(throw new NotFoundException("User wasn't found"))
        .asJson.noSpaces
      )
  }

  val protectedRest: UHttpApp = Http.collect[Request] {
    case Method.GET -> !! / "users" / "home" => {
      val uid = 0// PathParam
      val data = UserService.userPage(uid)
      Response.text(data.toString)
    }
  }
}