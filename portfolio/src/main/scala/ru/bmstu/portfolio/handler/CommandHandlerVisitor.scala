package ru.bmstu.portfolio.handler

import ru.bmstu.portfolio.command.TCommandVisitor
import ru.bmstu.portfolio.command.user._
import ru.bmstu.portfolio.command.work._
import ru.bmstu.portfolio.command.album._
import ru.bmstu.portfolio.dto.ProcessException
import ru.bmstu.portfolio.factory.TableGatewayFactory

class CommandHandlerVisitor extends TCommandVisitor {
  @throws[ProcessException]
  override def visitCreateAlbumCommand(command: CreateAlbumCommand): Unit =
    command.result = Some(TableGatewayFactory.instance.createAlbumTableGateway.insertAlbum(command))

  @throws[ProcessException]
  override def visitAddCoauthorCommand(command: AddCoauthorCommand): Unit =
    command.result = Some(TableGatewayFactory.instance.createAlbumTableGateway.updateCoauthor(command))

  @throws[ProcessException]
  override def visitDeleteAlbumCommand(command: DeleteAlbumCommand): Unit =
    command.result = Some(TableGatewayFactory.instance.createAlbumTableGateway.deleteAlbum(command))

  @throws[ProcessException]
  override def visitUpdateAlbumCommand(command: UpdateAlbumCommand): Unit =
    command.result = Some(TableGatewayFactory.instance.createAlbumTableGateway.updateAlbum(command))

  @throws[ProcessException]
  override def visitCreateUserCommand(command: CreateUserCommand): Unit =
    command.result = Some(TableGatewayFactory.instance.createUserTableGateway.insertUser(command))

  @throws[ProcessException]
  override def visitDeleteProfileCommand(command: DeleteProfileCommand): Unit =
    command.result = Some(TableGatewayFactory.instance.createUserTableGateway.deleteUser(command))

  @throws[ProcessException]
  override def visitLoginUserCommand(command: LoginUserCommand): Unit =
    command.result = Some(TableGatewayFactory.instance.createUserTableGateway.loginUser(command))

  @throws[ProcessException]
  override def visitLogoutUserCommand(command: LogoutUserCommand): Unit =
    command.result = Some(TableGatewayFactory.instance.createUserTableGateway.logoutUser(command))

  @throws[ProcessException]
  override def visitUpdateUserCommand(command: UpdateUserCommand): Unit =
    command.result = Some(TableGatewayFactory.instance.createUserTableGateway.updateUser(command))

  @throws[ProcessException]
  override def visitAddWorkCommand(command: AddWorkCommand): Unit =
    command.result = Some(TableGatewayFactory.instance.createWorkTableGateway.insertWork(command))

  @throws[ProcessException]
  override def visitDeleteWorkCommand(command: DeleteWorkCommand): Unit =
    command.result = Some(TableGatewayFactory.instance.createWorkTableGateway.deleteWork(command))
}
