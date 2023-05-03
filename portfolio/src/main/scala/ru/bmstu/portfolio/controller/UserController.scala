package ru.bmstu.portfolio.controller
import ru.bmstu.portfolio.command.user.DeleteProfileCommand
import ru.bmstu.portfolio.factory.Postgres.PostgresTableGateWay
import ru.bmstu.portfolio.factory.TableGatewayFactory
import ru.bmstu.portfolio.factory.provider.ConstProvider
import ru.bmstu.portfolio.handler.CommonHandler

class UserController {
def DeleteUser(user: Int): Unit = {
  TableGatewayFactory.registerFactory("postgres", PostgresTableGateWay)
  TableGatewayFactory.setProvider(new ConstProvider("postgres"))
  val command = DeleteProfileCommand(0, password = "hehe")

  new CommonHandler handleCommand(command)
  println(command.result.get)
  }

}
