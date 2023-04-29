package ru.bmstu.portfolio.query

import ru.bmstu.portfolio.dto.ProcessException

abstract class AQuery[Result] {
  var result: Option[Result] = None

  @throws[ProcessException]
  def acceptVisitor(visitor: TQueryVisitor): Unit
}
