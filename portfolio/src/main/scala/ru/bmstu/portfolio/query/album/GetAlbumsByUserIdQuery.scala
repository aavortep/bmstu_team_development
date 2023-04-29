package ru.bmstu.portfolio.query.album

import ru.bmstu.portfolio.dto.{Album, ProcessException}
import ru.bmstu.portfolio.query.{AQuery, TQueryVisitor}

sealed case class GetAlbumsByUserIdQuery(userId: Int, page: Int, amount: Int) extends AQuery[List[Album]] {
  @throws[ProcessException]
  override def acceptVisitor(visitor: TQueryVisitor): Unit =
    visitor.visitGetAlbumsByUserIdQuery(this)
}
