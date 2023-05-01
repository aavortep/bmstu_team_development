package ru.bmstu.portfolio.handler

import ru.bmstu.portfolio.dto.ProcessException
import ru.bmstu.portfolio.factory.TableGatewayFactory
import ru.bmstu.portfolio.query.TQueryVisitor
import ru.bmstu.portfolio.query.user._
import ru.bmstu.portfolio.query.work._
import ru.bmstu.portfolio.query.album._

class QueryHandlerVisitor extends TQueryVisitor {
  @throws[ProcessException]
  override def visitGetAlbumByIdQuery(query: GetAlbumByIdQuery): Unit =
    query.result = Some(TableGatewayFactory.instance.createAlbumTableGateway.getAlbumById(query))

  @throws[ProcessException]
  override def visitGetAlbumsByUserIdQuery(query: GetAlbumsByUserIdQuery): Unit =
    query.result = Some(TableGatewayFactory.instance.createAlbumTableGateway.getAlbumsByUserId(query))

  @throws[ProcessException]
  override def visitSearchAlbumsInIntervalQuery(query: SearchAlbumsInIntervalQuery): Unit =
    query.result = Some(TableGatewayFactory.instance.createAlbumTableGateway.searchAlbumsInInterval(query))

  @throws[ProcessException]
  override def visitSearchAlbumsQuery(query: SearchAlbumsQuery): Unit =
    query.result = Some(TableGatewayFactory.instance.createAlbumTableGateway.searchAlbums(query))

  @throws[ProcessException]
  override def visitGetUserByIdQuery(query: GetUserByIdQuery): Unit =
    query.result = Some(TableGatewayFactory.instance.createUserTableGateway.getUser(query))

  @throws[ProcessException]
  override def visitSearchUsersQuery(query: SearchUsersQuery): Unit =
    query.result = Some(TableGatewayFactory.instance.createUserTableGateway.searchUsers(query))

  @throws[ProcessException]
  override def visitGetWorksByAlbumIdQuery(query: GetWorksByAlbumIdQuery): Unit =
    query.result = Some(TableGatewayFactory.instance.createWorkTableGateway.getWorksByAlbumId(query))
}
