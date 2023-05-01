package ru.bmstu.portfolio.query.album

import ru.bmstu.portfolio.dto.{Album, ProcessException}
import ru.bmstu.portfolio.query.{AQuery, TQueryVisitor}

sealed case class SearchAlbumsQuery(name: String, albumType: String, software: String) extends AQuery[List[Album]] {
  @throws[ProcessException]
  override def acceptVisitor(visitor: TQueryVisitor): Unit =
    visitor.visitSearchAlbumsQuery(this)
}
