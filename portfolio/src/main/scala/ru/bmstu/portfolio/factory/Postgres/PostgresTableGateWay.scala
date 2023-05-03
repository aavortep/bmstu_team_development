package ru.bmstu.portfolio.factory.Postgres

import ru.bmstu.portfolio.db.Database
import ru.bmstu.portfolio.factory.{TAlbumTableGateway, TUserTableGateway, TWorkTableGateway, TableGatewayFactory}

import java.sql.DriverManager

object PostgresTableGateWay extends TableGatewayFactory{
  val driver = "org.postgresql.Driver"
  val url = "jdbc:postgresql://localhost:5432/postgres?user=postgres"
  val username = "postgres"
  val password = "123"
  Class.forName(driver) // Load the driver
  // Make the connection


  override def createAlbumTableGateway: TAlbumTableGateway =
    new AlbumTableGateway(DriverManager.getConnection(url, username, password))

  override def createUserTableGateway: TUserTableGateway =
    new UserTableGateway(DriverManager.getConnection(url, username, password))

  override def createWorkTableGateway: TWorkTableGateway = ???
}
