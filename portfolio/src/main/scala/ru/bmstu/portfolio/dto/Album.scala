package ru.bmstu.portfolio.dto

sealed case class Album
(
  albumId: Option[Int],
  name: String,
  creator: UserRef,
  coauthors: Option[List[UserRef]],
  software: String,
  albumType: String,
  creationDate: String
) {
  def this(name: String, creator: UserRef, coauthors: Option[List[UserRef]],
           software: String, albumType: String, creationDate: String) =
    this(None, name, creator, coauthors, software, albumType, creationDate)
}