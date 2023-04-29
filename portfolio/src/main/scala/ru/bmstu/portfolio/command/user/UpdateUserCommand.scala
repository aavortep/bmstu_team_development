package ru.bmstu.portfolio.command.user

import ru.bmstu.portfolio.command.{ACommand, TCommandVisitor}
import ru.bmstu.portfolio.dto.{ProcessException, UserPublicData}

sealed case class UpdateUserCommand(userId: Int, data: UserPublicData) extends ACommand[UserPublicData] {
  @throws[ProcessException]
  override def acceptVisitor(visitor: TCommandVisitor): Unit =
    visitor.visitUpdateUserCommand(this)
}
