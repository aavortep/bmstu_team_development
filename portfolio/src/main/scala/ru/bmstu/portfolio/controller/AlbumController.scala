package ru.bmstu.portfolio.controller

import io.circe.generic.auto._
import io.circe.syntax._
import ru.bmstu.portfolio.dto.{CommandResult, NotFoundException}
import ru.bmstu.portfolio.service.AlbumService
import zhttp.http._


class AlbumController {
    val openRest: Http[Any, Nothing, Request, Response] = Http.collect[Request] {
        case Method.GET -> !! / "albums" / albumId =>
            Response.json(AlbumService.albumData(Integer.parseInt(albumId))
                  .getOrElse(throw new NotFoundException("Album wasn't found"))
                  .asJson.toString()
            )

        case Method.GET -> !! / "albums" / albumId / "works" =>
            Response.json(AlbumService.albumWorks(Integer.parseInt(albumId), 5, 1)
              .getOrElse(throw new NotFoundException(s"Album $albumId wasn't found"))
              .asJson.noSpaces
            )

//      ?user_id=...&name=...&type=...software=...&time_from=...&time_to=...&amount=...&page=...
        case Method.GET -> !! / "albums" =>
            Response.json(
                AlbumService.albums(6, 1)
                  .asJson.toString()
            )

    }

    val protectedRest: Http[Any, Nothing, Request, Response] = Http.collect[Request] {
        case Method.POST -> !! / "albums" =>
            Response.json(CommandResult(true, "Album created").asJson.toString())

        case Method.POST -> !! / "albums" / albumId / "authors" =>
            Response.json(AlbumService.albumData(albumId.toInt).getOrElse(throw new NotFoundException("..."))
            .asJson.toString())

        case Method.POST -> !! / "albums" / albumId / "works" =>
            Response.json(CommandResult(true, "Work added").asJson.toString())

        case Method.PUT -> !! / "albums" / (albumId: String) if albumId.matches("""\d+""") =>
        Response.json(AlbumService.albumData(albumId.toInt).getOrElse(throw new NotFoundException("..."))
        .asJson.toString())

        case Method.DELETE -> !! / "albums" / albumId =>
            Response.json(CommandResult(true, "Album deleted").asJson.toString())

        case Method.DELETE -> !! / "albums" / albumId / "works" / workId =>
            Response.json(CommandResult(true, "Work deleted").asJson.toString())
    }
}
