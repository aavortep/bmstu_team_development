package ru.bmstu.portfolio.command.work

import ru.bmstu.portfolio.command.{ACommand, TCommandVisitor}
import ru.bmstu.portfolio.dto.{CommandResult, ProcessException, Work}

sealed case class AddWorkCommand(albumId: Int, userId: Int, workData: Work) extends ACommand[CommandResult] {
  @throws[ProcessException]
  override def acceptVisitor(visitor: TCommandVisitor): Unit =
    visitor.visitAddWorkCommand(this)
}
