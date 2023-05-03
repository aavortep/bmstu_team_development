package ru.bmstu.portfolio.command.album

import ru.bmstu.portfolio.command.{ACommand, TCommandVisitor}
import ru.bmstu.portfolio.db.Database
import ru.bmstu.portfolio.dto.{CommandResult, ProcessException}
import ru.bmstu.portfolio.handler.CommonHandler

import java.sql.ResultSet

sealed case class DeleteAlbumCommand(albumId: Int, userId: Int) extends ACommand[CommandResult] {
  @throws[ProcessException]
  override def acceptVisitor(visitor: TCommandVisitor): Unit = {
    visitor.visitDeleteAlbumCommand(this)
  }

}
