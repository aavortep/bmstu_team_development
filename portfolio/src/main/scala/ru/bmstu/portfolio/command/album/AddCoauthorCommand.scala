package ru.bmstu.portfolio.command.album

import ru.bmstu.portfolio.command.{ACommand, TCommandVisitor}
import ru.bmstu.portfolio.dto.{Album, ProcessException}

sealed case class AddCoauthorCommand(userId: Int, newUserId: Int, albumId: Int) extends ACommand[Album] {
  @throws[ProcessException]
  override def acceptVisitor(visitor: TCommandVisitor): Unit =
    visitor.visitAddCoauthorCommand(this)
}
