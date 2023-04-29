package ru.bmstu.portfolio.factory

import ru.bmstu.portfolio.dto.{EmptyOptionException, ProcessException}
import ru.bmstu.portfolio.factory.provider.TProvider

import scala.collection.mutable

trait TableGatewayFactory {
  @throws(classOf[ProcessException])
  def createAlbumTableGateway: TAlbumTableGateway
  @throws(classOf[ProcessException])
  def createUserTableGateway: TUserTableGateway
  @throws(classOf[ProcessException])
  def createWorkTableGateway: TWorkTableGateway
}

object TableGatewayFactory {
  private var provider: Option[TProvider] = None
  private val map = new mutable.HashMap[String, TableGatewayFactory]

  private lazy val factory: TableGatewayFactory = map.getOrElse(
    provider
      .getOrElse(throw new EmptyOptionException("Provider is not set"))
      .getValue("TableGatewayFactory")
      .getOrElse(throw new EmptyOptionException("No value for key in provider")),
    throw new EmptyOptionException("Factory is not registered"))

  def setProvider(provider: TProvider): Unit =
    this.provider = Some(provider)

  def registerFactory(name: String, factory: TableGatewayFactory): Unit =
    map.put(name, factory)

  @throws[EmptyOptionException]
  def instance: TableGatewayFactory = factory
}
