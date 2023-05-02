package ru.bmstu.portfolio.factory

import ru.bmstu.portfolio.query.work._
import ru.bmstu.portfolio.command.work._
import ru.bmstu.portfolio.dto.{CommandResult, ProcessException, Work}

trait TWorkTableGateway {
  @throws[ProcessException]
  def insertWork(command: AddWorkCommand): CommandResult
  @throws[ProcessException]
  def deleteWork(command: DeleteWorkCommand): CommandResult
  @throws[ProcessException]
  def getWorksByAlbumId(query: GetWorksByAlbumIdQuery): List[Work]
}
