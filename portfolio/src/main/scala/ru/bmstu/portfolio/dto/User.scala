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

//object UserPublicData {
//  implicit val userDecoder: Decoder[UserPublicData] =
//    Decoder.forProduct10(UserPublicData, "id", "email", "name", "photo", )(UserPublicData.apply)
//  implicit val userEncoder: Encoder[UserPublicaData] =
//    Encoder.forProduct2("id", "name")(u => (u.id, u.name))
//  implicit def userEntityDecoder[F[_]: Sync]: EntityDecoder[F, User] = jsonOf
//  implicit def userEntityEncoder[F[_]: Applicative]: EntityEncoder[F, User] = jsonEncoderOf
//}

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