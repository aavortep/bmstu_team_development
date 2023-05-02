package ru.bmstu.portfolio.config

import com.nimbusds.jwt.{JWTClaimsSet, SignedJWT}
import java.util.Date

object JwtGenerator {
  private val secret = "mySecretKey"
  private val issuer = "myIssuer"
  private val audience = "myAudience"

  def generateJwt(userId: String, token: String): String = {
    val now = new Date()
    val claims = new JWTClaimsSet.Builder()
      .issuer(issuer)
      .subject(userId)
      .claim("token", token)
      .audience(audience)
      .issueTime(now)
      .expirationTime(new Date(now.getTime + 60 * 60 * 1000)) // 1 hour
      .build()
    val signedJwt = new SignedJWT(new com.nimbusds.jose.JWSHeader(com.nimbusds.jose.JWSAlgorithm.HS256), claims)
    signedJwt.sign(new com.nimbusds.jose.crypto.MACSigner(secret.getBytes))
    signedJwt.serialize()
  }
}