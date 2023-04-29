package ru.bmstu.portfolio.query.album

import ru.bmstu.portfolio.dto.Album
import ru.bmstu.portfolio.query.{AQuery, TQueryVisitor}

sealed case class SearchAlbumsInIntervalQuery(from: String, to: String,
                                              page: Int, amount: Int) extends AQuery[List[Album]] {
  override def acceptVisitor(visitor: TQueryVisitor): Unit =
    visitor.visitSearchAlbumsInIntervalQuery(this)
}
