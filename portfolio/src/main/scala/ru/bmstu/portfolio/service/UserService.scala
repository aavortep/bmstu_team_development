package ru.bmstu.portfolio.service

import ru.bmstu.portfolio.dto.{AuthResult, Image, UserPublicData, UserRef}

import java.util.Base64

object UserService {
  def isAuthenticated(token: String): Boolean =
    token.startsWith("token")

  def userPage(userId: Int): Option[UserPublicData] = {
    val image = getClass.getClassLoader.getResourceAsStream("example.png").readAllBytes()
    val image64 = Base64.getEncoder.encodeToString(image)

    if (userId < 10) Some(UserPublicData(userId, s"email_id$userId@gmail.com", s"user$userId",
      Image(userId, image64), "About myself", "212-85-06", "designer", "Russia", "Moscow", 1984))
    else None
  }

  def login(login: String, password: String): Option[AuthResult] = {
    if (login == "user" && password == "password") Some(AuthResult(UserRef(0, Some("Name")), "token"))
    else None
  }

  def getUsers(): List[UserRef] = {
    val result = for (i <- 1 to 8) yield {UserRef(i, Some(s"$i-Name-$i"))}
    result.toList
  }
}
