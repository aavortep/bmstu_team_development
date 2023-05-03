package ru.bmstu.portfolio.factory.Postgres

import jdk.nashorn.internal.runtime.Debug.id
import ru.bmstu.portfolio.command.album.{AddCoauthorCommand, CreateAlbumCommand, DeleteAlbumCommand, UpdateAlbumCommand}
import ru.bmstu.portfolio.db.Database
import ru.bmstu.portfolio.dto.{Album, CommandResult}
import ru.bmstu.portfolio.factory.TAlbumTableGateway
import ru.bmstu.portfolio.query.album.{GetAlbumByIdQuery, GetAlbumsByUserIdQuery, SearchAlbumsInIntervalQuery, SearchAlbumsQuery}

import java.sql.{Connection, DriverManager}

class AlbumTableGateway(conenction : Connection) extends TAlbumTableGateway {
  private val stm = conenction.createStatement()


  override def updateCoauthor(command: AddCoauthorCommand): Album = ???

  override def insertAlbum(command: CreateAlbumCommand): Album = ???

  override def deleteAlbum(command: DeleteAlbumCommand): CommandResult = ???

  override def updateAlbum(command: UpdateAlbumCommand): Album = ???

  override def getAlbumById(query: GetAlbumByIdQuery): Album = ???

  override def getAlbumsByUserId(query: GetAlbumsByUserIdQuery): List[Album] = ???

  override def searchAlbumsInInterval(query: SearchAlbumsInIntervalQuery): List[Album] = ???

  override def searchAlbums(query: SearchAlbumsQuery): List[Album] = ???
}
