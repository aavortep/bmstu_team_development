package ru.bmstu.portfolio.controller

import io.circe.generic.auto._
import io.circe.syntax._
import ru.bmstu.portfolio.dto.NotFoundException
import ru.bmstu.portfolio.service.AlbumService
import zhttp.http.HttpError.BadRequest
import zhttp.http._



//* /albums?user_id=...&name=...&type=...software=...&time_from=...&time_to=...&amount=...&page=... - поиск альбомов
//* /albums/{album_id}/works?page=...&amount=... - работы конкретного альбома

//* /albums - добавление нового альбома
//```
//{
//"name": "zxcvbnm",
//"software": "Photoshop",
//"type": "illustration"
//}
//```
//* /albums/{album_id}/authors -- добавление соавтора
//```
//{
//"userId": 5
//}
//```
//* /albums/{album_id}/works -- добавление работы в альбом
//```
//{
//"name": "hellohello",
//"photo": "",
//"description": ""
//}
//```

class AlbumController {
//    val openRest: Http[Any, Nothing, Request, Response] = Http.collect[Request] {
//        case Method.GET -> !! / "albums" / albumId / "works" =>
//            Response.json(AlbumService.albumWorks(Integer.parseInt(albumId), 5, 1)
//              .getOrElse(throw new NotFoundException(s"Album $albumId wasn't found"))
//              .asJson.noSpaces
//            )
////        case Method.GET -> !! / "albums" / albumId =>
////            Response.json(AlbumService.albumWorks(Integer.parseInt(albumId), 5, 1)
////              .getOrElse(throw new NotFoundException(s"Album $albumId wasn't found"))
////              .asJson.noSpaces)
//    }
    val openRest: Http[Any, BadRequest, Request, Response] = Http.collect[Request] {
        case Method.GET -> !! / "albums" / albumId =>
            Response.json(
                AlbumService.albumData(Integer.parseInt(albumId))
                  .getOrElse(throw new NotFoundException("Album wasn't found"))
                  .asJson.toString()
            )

        case Method.GET -> !! / "albums" =>
            Response.json(
                AlbumService.albums(6, 1)
                  .asJson.toString()
            )

        case Method.GET -> !! / "albums" / albumId / "works" =>
            Response.json(AlbumService.albumWorks(Integer.parseInt(albumId), 5, 1)
              .getOrElse(throw new NotFoundException(s"Album $albumId wasn't found"))
              .asJson.noSpaces
            )

        // Add more cases as needed
    }.mapError { error =>
        HttpError.BadRequest(error.toString)
    }
}
