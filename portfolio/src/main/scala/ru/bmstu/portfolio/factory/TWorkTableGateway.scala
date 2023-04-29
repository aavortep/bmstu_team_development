package ru.bmstu.portfolio.factory

import ru.bmstu.portfolio.query.work._
import ru.bmstu.portfolio.command.work._
import ru.bmstu.portfolio.dto.{CommandResult, Work}

trait TWorkTableGateway {
  def insertWork(command: AddWorkCommand): CommandResult
  def deleteWork(command: DeleteWorkCommand): CommandResult
  def getWorksByAlbumId(query: GetWorksByAlbumIdQuery): List[Work]
}
