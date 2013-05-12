package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._

import models.Question

object Post extends Controller {

  // リクエスト処理
  def post = Action { request =>
    request.body.asJson.map { json =>
      // ログ
      println("リクエスト" + json)

      var question = Question(
        0,
        (json \ "title").asOpt[String],
        (json \ "text").asOpt[String],
        (json \ "choice1").asOpt[String],
        (json \ "choice2").asOpt[String],
        (json \ "choice3").asOpt[String],
        (json \ "choice4").asOpt[String],
        (json \ "choice5").asOpt[String],
        (json \ "username").asOpt[String],
        (json \ "password").asOpt[String])

      val qid = question.addData

      Ok(qid.toString())
    }.getOrElse {
      BadRequest("Expecting Json data")
    }
  }
}