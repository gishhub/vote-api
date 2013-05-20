package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._

import models.Question
import models.Vote
import models.Message

object PostVote extends Controller {

  var resultMessage = ""
  // リクエストパラメータのqid,choice,usernameを取得
  val form = Form( tuple("qid" -> number, "choice" -> number, "username" -> optional(text)) )

  // リクエスト処理
  def PostVote = Action { implicit request =>
    val param = form.bindFromRequest.get

    // ログ
    println("リクエスト" + param.toString)

    val qid = param._1
    val choice = param._2
    val username = param._3

    var vote = Vote(0,qid,choice,username)

    // インサート
    vote.addData

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