package ru.bmstu.portfolio.factory.provider

trait TProvider {
  def getValue(key: String): Option[String]
}
