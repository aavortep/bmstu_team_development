package ru.bmstu.portfolio.command.user

import ru.bmstu.portfolio.command.{ACommand, TCommandVisitor}
import ru.bmstu.portfolio.dto.{AuthResult, ProcessException}

sealed case class LoginUserCommand(email: String, password: String) extends ACommand[AuthResult] {
  @throws[ProcessException]
  override def acceptVisitor(visitor: TCommandVisitor): Unit =
    visitor.visitLoginUserCommand(this)
}
