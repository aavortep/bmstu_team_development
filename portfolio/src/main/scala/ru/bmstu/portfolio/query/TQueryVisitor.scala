package ru.bmstu.portfolio.query

import ru.bmstu.portfolio.dto.ProcessException
import ru.bmstu.portfolio.query.album._
import ru.bmstu.portfolio.query.user._
import ru.bmstu.portfolio.query.work._

trait TQueryVisitor {
  @throws[ProcessException]
  def visitGetAlbumByIdQuery(query: GetAlbumByIdQuery): Unit

  @throws[ProcessException]
  def visitGetAlbumsByUserIdQuery(query: GetAlbumsByUserIdQuery): Unit

  @throws[ProcessException]
  def visitSearchAlbumsInIntervalQuery(query: SearchAlbumsInIntervalQuery): Unit

  @throws[ProcessException]
  def visitSearchAlbumsQuery(query: SearchAlbumsQuery): Unit


  @throws[ProcessException]
  def visitGetUserByIdQuery(query: GetUserByIdQuery): Unit

  @throws[ProcessException]
  def visitSearchUsersQuery(query: SearchUsersQuery): Unit


  @throws[ProcessException]
  def visitGetWorksByAlbumIdQuery(query: GetWorksByAlbumIdQuery): Unit
}
