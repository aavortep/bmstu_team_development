package ru.bmstu.portfolio.query.work

import ru.bmstu.portfolio.dto.{ProcessException, Work}
import ru.bmstu.portfolio.query.{AQuery, TQueryVisitor}

sealed case class GetWorksByAlbumIdQuery(albumId: Int, page: Int, amount: Int) extends AQuery[List[Work]]{
  @throws[ProcessException]
  override def acceptVisitor(visitor: TQueryVisitor): Unit =
    visitor.visitGetWorksByAlbumIdQuery(this)
}
