package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import scala.util.parsing.json._
import scala.collection.immutable
import com.mongodb.casbah.Imports._

object Vote extends Controller {

  // リクエストパラメータのqid,choiceを取得
  val form = Form( tuple("qid" -> text, "choice" -> number) )

  // MongoDB接続設定
  val conn = MongoConnection("mongo-takadayuichi-db-0.azva.dotcloud.net", 51406)
  val db = conn("vote")
  db.authenticate("vote", "kein1980")
  val collection = db("vote_test")

  // リクエスト処理
  def vote = Action { implicit request =>
    val param = form.bindFromRequest.get

    // ログ
    println("リクエスト" + param.toString)

    // ビルダーで順次項目をobjectに追加
    val builder = MongoDBObject.newBuilder
    builder += "qid" -> param._1
    builder += "choice" -> param._2
    val vote = builder.result

    // mongodbへインサート
    collection += vote

    Ok(vote.toString)
  }
}