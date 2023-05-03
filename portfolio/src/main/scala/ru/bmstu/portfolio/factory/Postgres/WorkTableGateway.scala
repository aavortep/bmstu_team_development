package ru.bmstu.portfolio.factory.Postgres

import ru.bmstu.portfolio.command.work.{AddWorkCommand, DeleteWorkCommand}
import ru.bmstu.portfolio.dto.{CommandResult, Work}
import ru.bmstu.portfolio.factory.TWorkTableGateway
import ru.bmstu.portfolio.query.work.GetWorksByAlbumIdQuery

import java.sql.Connection

class WorkTableGateway(conenction : Connection) extends TWorkTableGateway{
  override def insertWork(command: AddWorkCommand): CommandResult = ???

  override def deleteWork(command: DeleteWorkCommand): CommandResult = ???

  override def getWorksByAlbumId(query: GetWorksByAlbumIdQuery): List[Work] = ???
}
