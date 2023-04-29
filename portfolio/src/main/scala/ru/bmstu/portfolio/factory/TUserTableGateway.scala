package ru.bmstu.portfolio.factory

import ru.bmstu.portfolio.query.user._
import ru.bmstu.portfolio.command.user._
import ru.bmstu.portfolio.dto.{AuthResult, CommandResult, UserPublicData}

trait TUserTableGateway {
  def insertUser(command: CreateUserCommand): CommandResult
  def deleteUser(command: DeleteProfileCommand): CommandResult
  def loginUser(command: LoginUserCommand): AuthResult
  def logoutUser(command: LogoutUserCommand): CommandResult
  def updateUser(command: UpdateUserCommand): UserPublicData

  def getUser(query: GetUserByIdQuery): UserPublicData
  def searchUsers(query: SearchUsersQuery): List[UserPublicData]
}
