package ru.bmstu.portfolio.factory

import ru.bmstu.portfolio.query.album._
import ru.bmstu.portfolio.command.album._
import ru.bmstu.portfolio.dto.{Album, CommandResult, ProcessException}

trait TAlbumTableGateway {
  @throws[ProcessException]
  def updateCoauthor(command: AddCoauthorCommand): Album
  @throws[ProcessException]
  def insertAlbum(command: CreateAlbumCommand): Album
  @throws[ProcessException]
  def deleteAlbum(command: DeleteAlbumCommand): CommandResult
  @throws[ProcessException]
  def updateAlbum(command: UpdateAlbumCommand): Album

  @throws[ProcessException]
  def getAlbumById(query: GetAlbumByIdQuery): Album
  @throws[ProcessException]
  def getAlbumsByUserId(query: GetAlbumsByUserIdQuery): List[Album]
  @throws[ProcessException]
  def searchAlbumsInInterval(query: SearchAlbumsInIntervalQuery): List[Album]
  @throws[ProcessException]
  def searchAlbums(query: SearchAlbumsQuery): List[Album]
}
