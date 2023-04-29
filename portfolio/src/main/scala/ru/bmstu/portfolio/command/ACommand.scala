package ru.bmstu.portfolio.command

import ru.bmstu.portfolio.dto.ProcessException

abstract class ACommand[Result] {
  val result: Option[Result] = None

  @throws[ProcessException]
  def acceptVisitor(visitor: TCommandVisitor): Unit
}
