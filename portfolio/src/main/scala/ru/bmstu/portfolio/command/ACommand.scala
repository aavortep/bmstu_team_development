package ru.bmstu.portfolio.command

import ru.bmstu.portfolio.dto.ProcessException

abstract class ACommand[Result] {
  var result: Option[Result] = None

  @throws[ProcessException]
  def acceptVisitor(visitor: TCommandVisitor): Unit
}
