package ru.bmstu.portfolio.dto

sealed case class UserRef
(
  uId: Int,
  name: Option[String] = None,
)

sealed case class AuthResult
(
  user: UserRef,
  token: String,
)

sealed case class UserPublicData
(
  id: Int,
  email: String,
  name: String,
  photo: Image,
  description: String,
  phone: String,
  profession: String,
  country: String,
  town: String,
  year: Int
)