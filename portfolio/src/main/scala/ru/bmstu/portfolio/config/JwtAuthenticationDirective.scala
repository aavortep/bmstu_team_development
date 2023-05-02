//package ru.bmstu.portfolio.config

//import akka.http.scaladsl.server.{Directive0, Directives}
//import akka.http.scaladsl.server.directives.AuthenticationResult.{missingJwt, invalidJwt, authenticated}
//import akka.http.scaladsl.server.directives.AuthenticationDirective
//import akka.http.scaladsl.server.directives.HeaderDirectives._
//import scala.concurrent.Future
//import scala.util.{Success, Failure}
//
//trait JwtAuthenticationDirective extends Directives {
//
//  private val authPrefix = "Bearer "
//
//  def authenticate: AuthenticationDirective[String] =
//    extractAuthorizationHeader.flatMap {
//      case Some(authHeader) if authHeader.startsWith(authPrefix) =>
//        val jwt = authHeader.substring(authPrefix.length)
//        onComplete(Future { JwtAuthentication.validateJwt(jwt) }) flatMap {
//          case Success(Some(payload)) => provide(payload)
//          case Success(None) => authenticateOrRejectWithChallenge(missingJwt, challengeRealm = "secure")
//          case Failure(ex) => authenticateOrRejectWithChallenge(invalidJwt(ex.getMessage), challengeRealm = "secure")
//        }
//      case _ => authenticateOrRejectWithChallenge(missingJwt, challengeRealm = "secure")
//    }
//}
