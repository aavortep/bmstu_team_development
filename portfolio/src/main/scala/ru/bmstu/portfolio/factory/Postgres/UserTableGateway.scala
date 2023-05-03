package ru.bmstu.portfolio.factory.Postgres

import ru.bmstu.portfolio.command.user.{CreateUserCommand, DeleteProfileCommand, LoginUserCommand, LogoutUserCommand, UpdateUserCommand}
import ru.bmstu.portfolio.db.Database.conn
import ru.bmstu.portfolio.dto.{AuthResult, CommandResult, UserPublicData}
import ru.bmstu.portfolio.factory.TUserTableGateway
import ru.bmstu.portfolio.query.user.{GetUserByIdQuery, SearchUsersQuery}

import java.sql.{Connection, ResultSet}

class UserTableGateway(connection : Connection) extends TUserTableGateway{
  override def insertUser(command: CreateUserCommand): CommandResult = ???

  override def deleteUser(command: DeleteProfileCommand): CommandResult =
    try {
      val stm = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

      val rs = stm.executeUpdate("Delete from users where id = " + command.userId)
      CommandResult(success = true, "Query changed " + rs)
    }
    finally {
      connection.close()
    }

  override def loginUser(command: LoginUserCommand): AuthResult = ???

  override def logoutUser(command: LogoutUserCommand): CommandResult = ???

  override def updateUser(command: UpdateUserCommand): UserPublicData = ???

  override def getUser(query: GetUserByIdQuery): UserPublicData = ???

  override def searchUsers(query: SearchUsersQuery): List[UserPublicData] = ???
}
