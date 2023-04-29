package ru.bmstu.portfolio.command.album

import ru.bmstu.portfolio.command.{ACommand, TCommandVisitor}
import ru.bmstu.portfolio.dto.{CommandResult, ProcessException}

sealed case class DeleteAlbumCommand(albumId: Int, userId: Int) extends ACommand[CommandResult] {
  @throws[ProcessException]
  override def acceptVisitor(visitor: TCommandVisitor): Unit =
    visitor.visitDeleteAlbumCommand(this)
}
