package ru.bmstu.portfolio.factory.provider

final class ConstProvider(value: String) extends TProvider {
  override def getValue(key: String): Option[String] =
    Some(this.value)
}
