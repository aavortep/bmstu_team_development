package ru.bmstu.portfolio.dto

case class Work
(
  workId: Option[Int],
  albumId: Int,
  name: String,
  image: Image,
  description: String,
) {
  def this(albumId: Int, name: String, image: Image, description: String) =
    this(None, albumId, name, image,  description)
}