package ru.bmstu.portfolio.command.work

import ru.bmstu.portfolio.command.{ACommand, TCommandVisitor}
import ru.bmstu.portfolio.dto.CommandResult

sealed case class DeleteWorkCommand(userId: Int, albumId: Int, workId: Int) extends ACommand[CommandResult] {
  override def acceptVisitor(visitor: TCommandVisitor): Unit =
    visitor.visitDeleteWorkCommand(this)
}
