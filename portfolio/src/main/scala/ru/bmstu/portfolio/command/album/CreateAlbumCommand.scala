package ru.bmstu.portfolio.command.album

import ru.bmstu.portfolio.command.{ACommand, TCommandVisitor}
import ru.bmstu.portfolio.dto.Album

sealed case class CreateAlbumCommand(userId: Int, addUserId: Int, albumId: Int) extends ACommand[Album] {
  override def acceptVisitor(visitor: TCommandVisitor): Unit =
    visitor.visitCreateAlbumCommand(this)
}
