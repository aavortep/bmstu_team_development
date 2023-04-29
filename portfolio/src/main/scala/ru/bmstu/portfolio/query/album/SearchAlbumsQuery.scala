package ru.bmstu.portfolio.query.album

import ru.bmstu.portfolio.dto.Album
import ru.bmstu.portfolio.query.{AQuery, TQueryVisitor}

sealed case class SearchAlbumsQuery(name: String, albumType: String, software: String) extends AQuery[List[Album]] {
  override def acceptVisitor(visitor: TQueryVisitor): Unit =
    visitor.visitSearchAlbumsQuery(this)
}
