package ru.bmstu.portfolio.factory

import ru.bmstu.portfolio.query.album._
import ru.bmstu.portfolio.command.album._
import ru.bmstu.portfolio.dto.{Album, CommandResult}

trait TAlbumTableGateway {
  def updateCoauthor(command: AddCoauthorCommand): Album
  def insertAlbum(command: CreateAlbumCommand): Album
  def deleteAlbum(command: DeleteAlbumCommand): CommandResult
  def updateAlbum(command: UpdateAlbumCommand): Album

  def getAlbumById(query: GetAlbumByIdQuery): Album
  def getAlbumsByUserId(query: GetAlbumsByUserIdQuery): List[Album]
  def searchAlbumsInInterval(query: SearchAlbumsInIntervalQuery): List[Album]
  def searchAlbums(query: SearchAlbumsQuery): List[Album]
}
