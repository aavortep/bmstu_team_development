package ru.bmstu.portfolio.query.album

import ru.bmstu.portfolio.dto.{Album, ProcessException}
import ru.bmstu.portfolio.query.{AQuery, TQueryVisitor}

sealed case class SearchAlbumsInIntervalQuery(from: String, to: String,
                                              page: Int, amount: Int) extends AQuery[List[Album]] {
  @throws[ProcessException]
  override def acceptVisitor(visitor: TQueryVisitor): Unit =
    visitor.visitSearchAlbumsInIntervalQuery(this)
}
