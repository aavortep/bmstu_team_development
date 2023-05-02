package ru.bmstu.portfolio.config

import com.nimbusds.jose.JWSObject

object JwtAuthentication {
  private val secret = "mySecretKey"

  def validateJwt(jwt: String): Option[String] = {
    val jwsObject = JWSObject.parse(jwt)
    if (jwsObject.verify(signatureVerifier)) {
      Some(jwsObject.getPayload.toString)
    } else {
      None
    }
  }

  private def signatureVerifier = {
    new com.nimbusds.jose.crypto.MACVerifier(secret.getBytes)
  }
}
