package ru.bmstu.portfolio.query.album

import ru.bmstu.portfolio.dto.Album
import ru.bmstu.portfolio.query.{AQuery, TQueryVisitor}

sealed case class GetAlbumsByUserIdQuery(userId: Int, page: Int, amount: Int) extends AQuery[List[Album]] {
  override def acceptVisitor(visitor: TQueryVisitor): Unit =
    visitor.visitGetAlbumsByUserIdQuery(this)
}
