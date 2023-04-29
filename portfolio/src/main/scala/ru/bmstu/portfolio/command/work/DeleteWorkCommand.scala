package ru.bmstu.portfolio.command.work

import ru.bmstu.portfolio.command.{ACommand, TCommandVisitor}
import ru.bmstu.portfolio.dto.{CommandResult, ProcessException}

sealed case class DeleteWorkCommand(userId: Int, albumId: Int, workId: Int) extends ACommand[CommandResult] {
  @throws[ProcessException]
  override def acceptVisitor(visitor: TCommandVisitor): Unit =
    visitor.visitDeleteWorkCommand(this)
}
