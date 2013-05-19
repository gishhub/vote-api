package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import models.Question

object GetQuestionList extends Controller {

  // リクエストパラメータのnumを取得
  val form = Form("num" -> text)

  // リクエスト処理
  def getQuestionList = Action { implicit request =>
    val param = form.bindFromRequest.get

    // ログ
    println("リクエスト" + param)

    val num = param.toInt

    val questions = Question.getList(num)

    Ok(questions.toString())
  }
}