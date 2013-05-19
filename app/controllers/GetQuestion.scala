package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import scala.util.parsing.json._

import models.Question

object GetQuestion extends Controller {

  val form = Form("qid" -> text)

  // リクエスト処理
  def getQuestion = Action { implicit request =>
    val param = form.bindFromRequest.get
    val qid = param.toInt
    println("リクエスト" + qid)

    // 取得
    val question = Question.getByQid(qid)

    Ok(question.toString())
  }
}