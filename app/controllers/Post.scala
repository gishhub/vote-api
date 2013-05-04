package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import com.mongodb.casbah.Imports._

object Post extends Controller {

  // MongoDB接続設定
  val conn = MongoConnection("gish.tokyo.jp", 27017)
  val db = conn("vote")
  db.authenticate("vote", "kein1980")
  val collection = db("question")

  // リクエスト処理
  def post = Action { request =>
    request.body.asJson.map { json =>
      // ログ
      println("リクエスト" + json)

      // ビルダーで順次項目をobjectに追加
      val builder = MongoDBObject.newBuilder
      (json \ "title").asOpt[String].map { title => builder += "title" -> title }
      (json \ "text").asOpt[String].map { text => builder += "text" -> text }
      (json \ "choice1").asOpt[String].map { choice1 => builder += "choice1" -> choice1 }
      (json \ "choice2").asOpt[String].map { choice2 => builder += "choice2" -> choice2 }
      (json \ "choice3").asOpt[String].map { choice3 => builder += "choice3" -> choice3 }
      (json \ "choice4").asOpt[String].map { choice4 => builder += "choice4" -> choice4 }
      (json \ "choice5").asOpt[String].map { choice5 => builder += "choice5" -> choice5 }
      (json \ "username").asOpt[String].map { username => builder += "username" -> username }
      (json \ "password").asOpt[String].map { password => builder += "password" -> password }
      val question = builder.result

      // mongodbへインサート
      collection += question

      Ok(question.toString)
    }.getOrElse {
      BadRequest("Expecting Json data")
    }
  }
}