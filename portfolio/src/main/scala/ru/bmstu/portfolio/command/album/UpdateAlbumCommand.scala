package ru.bmstu.portfolio.command.album

import ru.bmstu.portfolio.command.{ACommand, TCommandVisitor}
import ru.bmstu.portfolio.dto.{Album, ProcessException}

sealed case class UpdateAlbumCommand(userId: Int, albumId: Int, albumData: Album) extends ACommand[Album] {
  @throws[ProcessException]
  override def acceptVisitor(visitor: TCommandVisitor): Unit =
    visitor.visitUpdateAlbumCommand(this)
}
