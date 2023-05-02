package ru.bmstu.portfolio.config

import ru.bmstu.portfolio.service.UserService
import zhttp.http._
import zhttp.http.middleware.HttpMiddleware

class AuthMiddleware {
  val auth: HttpMiddleware[Any, Nothing] = Middleware.bearerAuth(token => {
    UserService.isAuthenticated(token)
  })
}
