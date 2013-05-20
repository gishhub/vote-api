package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import scala.util.parsing.json._

import models.Question
import models.Message

object GetQuestion extends Controller {

  var resultMessage = ""
  val form = Form("qid" -> text)

  // リクエスト処理
  def getQuestion = Action { implicit request =>
    val param = form.bindFromRequest.get
    val qid = param.toInt
    println("リクエスト" + qid)

    // qid判定
    val qidValidationResult = Question.checkQid(qid)
    if (qidValidationResult == true) {
      // 取得
      val question = Question.getByQid(qid)
      resultMessage = question.toString()
    } else {
      resultMessage = Message.warnMessage.toString()
    }
    Ok(resultMessage)
  }
}