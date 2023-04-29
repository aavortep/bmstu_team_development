package ru.bmstu.portfolio.factory

import ru.bmstu.portfolio.query.user._
import ru.bmstu.portfolio.command.user._
import ru.bmstu.portfolio.dto.{AuthResult, CommandResult, ProcessException, UserPublicData}

trait TUserTableGateway {
  @throws[ProcessException]
  def insertUser(command: CreateUserCommand): CommandResult
  @throws[ProcessException]
  def deleteUser(command: DeleteProfileCommand): CommandResult
  @throws[ProcessException]
  def loginUser(command: LoginUserCommand): AuthResult
  @throws[ProcessException]
  def logoutUser(command: LogoutUserCommand): CommandResult
  @throws[ProcessException]
  def updateUser(command: UpdateUserCommand): UserPublicData

  @throws[ProcessException]
  def getUser(query: GetUserByIdQuery): UserPublicData
  @throws[ProcessException]
  def searchUsers(query: SearchUsersQuery): List[UserPublicData]
}
