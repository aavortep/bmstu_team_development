package ru.bmstu.portfolio.query.work

import ru.bmstu.portfolio.dto.Work
import ru.bmstu.portfolio.query.{AQuery, TQueryVisitor}

sealed case class GetWorksByAlbumIdQuery(albumId: Int, page: Int, amount: Int) extends AQuery[List[Work]]{
  override def acceptVisitor(visitor: TQueryVisitor): Unit =
    visitor.visitGetWorksBuAlbumIdQuery(this)
}
