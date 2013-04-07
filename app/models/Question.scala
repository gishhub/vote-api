package models

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json._

case class Choices(
  id: Int,
  choice: String,
  vote: Int)

case class Question(
  title: String,
  text: String,
  choices: List[Choices],
  username: String,
  password: String)
