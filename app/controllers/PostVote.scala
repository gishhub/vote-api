package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._

import models.Question
import models.Vote

object PostVote extends Controller {

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

    // 取得
    val question = Question.getByQid(qid)

    // ステータスコード
    // http://www.playframework-ja.org/documentation/2.0.2/ScalaActions
    Ok(question.toString())  }
}