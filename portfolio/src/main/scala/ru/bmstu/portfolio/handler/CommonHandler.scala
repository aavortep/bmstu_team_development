package ru.bmstu.portfolio.handler

import ru.bmstu.portfolio.command.ACommand
import ru.bmstu.portfolio.dto.ProcessException
import ru.bmstu.portfolio.query.AQuery

class CommonHandler {
  @throws[ProcessException]
  def handle(command: ACommand[AnyRef]): Unit =
    command.acceptVisitor(new CommandHandlerVisitor)

  @throws[ProcessException]
  def handle(query: AQuery[AnyRef]): Unit =
    query.acceptVisitor(new QueryHandlerVisitor)
}
