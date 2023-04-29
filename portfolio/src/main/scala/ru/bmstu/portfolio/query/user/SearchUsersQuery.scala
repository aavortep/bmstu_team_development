package ru.bmstu.portfolio.query.user

import ru.bmstu.portfolio.dto.{ProcessException, UserPublicData}
import ru.bmstu.portfolio.query.{AQuery, TQueryVisitor}

sealed case class SearchUsersQuery(name: Option[String], country: Option[String], city: Option[String],
                                   prof: Option[String], page: Int, amount: Int) extends AQuery[List[UserPublicData]] {
  @throws[ProcessException]
  override def acceptVisitor(visitor: TQueryVisitor): Unit =
    visitor.visitSearchUsersQuery(this)
}
