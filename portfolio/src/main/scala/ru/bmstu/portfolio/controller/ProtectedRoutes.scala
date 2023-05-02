package ru.bmstu.portfolio.controller

//import ru.bmstu.portfolio.config.JwtAuthenticationDirective
//
////@Path("/protected")
//class ProtectedRoutes extends JwtAuthenticationDirective {
//
//  @Path("/secret")
//  @Operation(
//    summary = "Get a secret message",
//    description = "Returns a secret message that is only accessible to authenticated users",
//    responses = Array(
//      new ApiResponse(responseCode = "200", description = "Successful response",
//        content = Array(new Content(mediaType = "text/plain"))),
//      new ApiResponse(responseCode = "401", description = "Unauthorized")
//    )
//  )
//  @GET
//  def secret(): Route = authenticate { payload =>
//    complete(s"Welcome, $payload!")
//  }
//}