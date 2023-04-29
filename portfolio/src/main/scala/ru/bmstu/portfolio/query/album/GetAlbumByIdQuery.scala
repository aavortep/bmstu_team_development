package ru.bmstu.portfolio.query.album

import ru.bmstu.portfolio.dto.Album
import ru.bmstu.portfolio.query.{AQuery, TQueryVisitor}

sealed case class GetAlbumByIdQuery(albumId: Int) extends AQuery[Album] {
  override def acceptVisitor(visitor: TQueryVisitor): Unit =
    visitor.visitGetAlbumByIdQuery(this)
}
