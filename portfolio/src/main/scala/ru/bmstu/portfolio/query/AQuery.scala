package ru.bmstu.portfolio.query

import ru.bmstu.portfolio.dto.ProcessException

abstract class AQuery[Result] {
  val result: Option[Result] = None

  @throws(classOf[ProcessException])
  def acceptVisitor(visitor: TQueryVisitor): Unit
}
