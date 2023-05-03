package ru.bmstu.portfolio.handler

import ru.bmstu.portfolio.command.ACommand
import ru.bmstu.portfolio.dto.ProcessException
import ru.bmstu.portfolio.query.AQuery


class CommonHandler {
  @throws[ProcessException]
  def handleCommand(command: ACommand[_]): Unit =
    command.acceptVisitor(new CommandHandlerVisitor)

  @throws[ProcessException]
  def handleQuery(query: AQuery[_]): Unit =
    query.acceptVisitor(new QueryHandlerVisitor)
}
