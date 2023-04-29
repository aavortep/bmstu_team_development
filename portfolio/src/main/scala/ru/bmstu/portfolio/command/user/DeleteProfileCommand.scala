package ru.bmstu.portfolio.command.user

import ru.bmstu.portfolio.command.{ACommand, TCommandVisitor}
import ru.bmstu.portfolio.dto.CommandResult

sealed case class DeleteProfileCommand(userId: Int, password: String) extends ACommand[CommandResult] {
  override def acceptVisitor(visitor: TCommandVisitor): Unit =
    visitor.visitDeleteProfileCommand(this)
}
