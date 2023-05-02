package ru.bmstu.portfolio.service

import ru.bmstu.portfolio.dto.{Album, Image, UserRef, Work}
import ru.bmstu.portfolio.query.work.GetWorksByAlbumIdQuery

import java.nio.file.{Files, Paths}
import java.util.Base64

object AlbumService {
  def albumData(albumId: Int): Option[Album] = {
    if (albumId < 10) Some(Album(Some(albumId), s"name$albumId", UserRef(0, Some("UserName")), None, "software",
                                "albumType", "02.02.2023"))
    else None
  }

  def albumWorks(albumId: Int, amount: Int, page: Int): Option[List[Work]] = {
    val image = getClass.getClassLoader.getResourceAsStream("example.png").readAllBytes()
    val image64 = Base64.getEncoder.encodeToString(image)

    val toList: IndexedSeq[Work] => List[Work] = _.toList
    if (albumId < 10) Some(toList(for (i <- 1 to amount) yield {
      Work(Some(albumId + amount * page), albumId, s"name$page-$amount",
        Image(i + i * amount, image64), s"Some description ${page * amount}")}))
    else None
  }

  def albums(amount: Int, page: Int): List[Album] = {
    val result = for (i <- 1 to amount) yield {
      Album(Some(i + amount * page), s"name$page-$amount", UserRef(0, Some("Name")), None, "soft", "albumType", "03.05.2023")
    }
    result.toList
  }
}
