package ru.bmstu.portfolio.command

import ru.bmstu.portfolio.command.album._
import ru.bmstu.portfolio.command.user._
import ru.bmstu.portfolio.command.work._
import ru.bmstu.portfolio.dto.ProcessException

trait TCommandVisitor {
  @throws[ProcessException]
  def visitAddCoauthorCommand(command: AddCoauthorCommand): Unit

  @throws[ProcessException]
  def visitCreateAlbumCommand(command: CreateAlbumCommand): Unit

  @throws[ProcessException]
  def visitDeleteAlbumCommand(command: DeleteAlbumCommand): Unit

  @throws[ProcessException]
  def visitUpdateAlbumCommand(command: UpdateAlbumCommand): Unit


  @throws[ProcessException]
  def visitCreateUserCommand(command: CreateUserCommand): Unit

  @throws[ProcessException]
  def visitDeleteProfileCommand(command: DeleteProfileCommand): Unit

  @throws[ProcessException]
  def visitLoginUserCommand(command: LoginUserCommand): Unit

  @throws[ProcessException]
  def visitLogoutUserCommand(command: LogoutUserCommand): Unit

  @throws[ProcessException]
  def visitUpdateUserCommand(command: UpdateUserCommand): Unit


  @throws[ProcessException]
  def visitAddWorkCommand(command: AddWorkCommand): Unit

  @throws[ProcessException]
  def visitDeleteWorkCommand(command: DeleteWorkCommand): Unit
}
