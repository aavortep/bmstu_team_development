package ru.bmstu.portfolio.query.user

import ru.bmstu.portfolio.dto.UserPublicData
import ru.bmstu.portfolio.query.{AQuery, TQueryVisitor}

sealed case class GetUserByIdQuery(userId: Int) extends AQuery[UserPublicData] {
  override def acceptVisitor(visitor: TQueryVisitor): Unit =
    visitor.visitGetUserByIdQuery(this)
}
