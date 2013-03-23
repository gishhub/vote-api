package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import models.Question
import com.mongodb.casbah.Imports._

object Post extends Controller {

  // フォームの値をQuestionクラスにマッピング
  val questionForm = Form(mapping(
    "title" -> text,
    "text" -> text,
    "choice1" -> text,
    "choice2" -> text,
    "choice3" -> text,
    "choice4" -> text,
    "choice5" -> text,
    "username" -> text,
    "password" -> text)(Question.apply)(Question.unapply))

  // MongoDB接続設定
  val conn = MongoConnection("mongo-takadayuichi-db-0.azva.dotcloud.net", 51406)
  val db = conn("vote")
  db.authenticate("vote", "kein1980")
  val collection = db("test")

  // リクエスト処理
  def post = Action { implicit request =>
    val question = MongoDBObject(
        "title" -> questionForm.bindFromRequest.get.title,
        "text" -> questionForm.bindFromRequest.get.text,
        "choice1" -> questionForm.bindFromRequest.get.choice1,
        "choice2" -> questionForm.bindFromRequest.get.choice2,
        "choice3" -> questionForm.bindFromRequest.get.choice3,
        "choice4" -> questionForm.bindFromRequest.get.choice4,
        "choice5" -> questionForm.bindFromRequest.get.choice5,
        "username" -> questionForm.bindFromRequest.get.username,
        "password" -> questionForm.bindFromRequest.get.password)

    // mongodbへインサート
    collection += question
    Ok(question.toString)
  }
}