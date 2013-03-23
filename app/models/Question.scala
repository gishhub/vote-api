package models

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._

import com.mongodb.casbah.Imports._

case class Choices(
  choice: String)

case class Question (
  title: String,
  text: String,
  choice1: String,
  choice2: String,
  choice3: String,
  choice4: String,
  choice5: String,
  username: String,
  password: String)
