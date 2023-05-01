package ru.bmstu.portfolio.command.user

import ru.bmstu.portfolio.command.{ACommand, TCommandVisitor}
import ru.bmstu.portfolio.dto.{CommandResult, ProcessException}

sealed case class CreateUserCommand(name: String, email: String, password: String) extends ACommand[CommandResult] {
  @throws[ProcessException]
  override def acceptVisitor(visitor: TCommandVisitor): Unit =
    visitor.visitCreateUserCommand(this)
}
