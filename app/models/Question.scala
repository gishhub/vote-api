package models

import play.api.db._
import scala.util.parsing.json._
import scala.collection.mutable
import scala.collection.immutable

import anorm._
import play.api.Play.current
import anorm.SqlParser._

case class Question(
  qid: Int,
  title: Option[String],
  text: Option[String],
  choice1: Option[String],
  choice2: Option[String],
  choice3: Option[String],
  choice4: Option[String],
  choice5: Option[String],
  username: Option[String],
  password: Option[String]) {

  def addData: JSONObject = {
    DB.withConnection { implicit c =>
      val qid: Option[Long] = SQL("""
          INSERT INTO
          question (title, text,choice1,choice2,choice3,choice4,choice5,username,password)
          VALUES ({title}, {text},{choice1},{choice2},{choice3},{choice4},{choice5},{username},{password})
          """).
        on('title -> this.title, 'text -> this.text, 'choice1 -> this.choice1, 'choice2 -> this.choice2, 'choice3 -> this.choice3, 'choice4 -> this.choice4, 'choice5 -> this.choice5, 'username -> this.username, 'password -> this.password).executeInsert()

      val json = JSONObject(immutable.Map(
        "qid" -> qid.getOrElse()))
      return json
    }
  }
}

object Question {
  val data = {
    get[Int]("qid") ~
      get[Option[String]]("title") ~
      get[Option[String]]("text") ~
      get[Option[String]]("choice1") ~
      get[Option[String]]("choice2") ~
      get[Option[String]]("choice3") ~
      get[Option[String]]("choice4") ~
      get[Option[String]]("choice5") ~
      get[Option[String]]("username") ~
      get[Option[String]]("password") map {
        case qid ~ title ~ text ~ choice1 ~ choice2 ~ choice3 ~ choice4 ~ choice5 ~ username ~ password => Question(qid, title, text, choice1, choice2, choice3, choice4, choice5, username, password)
      }
  }

  def checkQid(qid: Int): Boolean = {
    var result = false
    DB.withConnection { implicit c =>
      val selectCount = SQL("""
          SELECT count(*) as num FROM question WHERE qid = {qid}
          """).on('qid -> qid).apply().head
      if (selectCount[Long]("num") == 1) {
        result = true
      }
    }
    return result
  }

  def getByQid(qid: Int): JSONObject = {
    DB.withConnection { implicit c =>
      val question = SQL("""
          SELECT
            qid,title,text,choice1,choice2,choice3,choice4,choice5,username,password
          FROM question
          WHERE qid = {qid}
          """).on('qid -> qid).as(Question.data.single)

      val vote1 = Vote.getCountByQid(qid, 1)
      val vote2 = Vote.getCountByQid(qid, 2)
      val vote3 = Vote.getCountByQid(qid, 3)
      val vote4 = Vote.getCountByQid(qid, 4)
      val vote5 = Vote.getCountByQid(qid, 5)

      var voteVal1 = 0L
      var voteVal2 = 0L
      var voteVal3 = 0L
      var voteVal4 = 0L
      var voteVal5 = 0L
      val voteAll = vote1 + vote2 + vote3 + vote4 + vote5
      if (voteAll != 0) {
        voteVal2 = vote2 * 100 / voteAll
        voteVal3 = vote3 * 100 / voteAll
        voteVal4 = vote4 * 100 / voteAll
        voteVal5 = vote5 * 100 / voteAll
        voteVal1 = 100 - voteVal2 - voteVal3 - voteVal4 - voteVal5
      }

      val choiceData1 = JSONObject(immutable.Map(
        "id" -> 1,
        "choice" -> question.choice1.getOrElse(""),
        "vote" -> voteVal1))

      val choiceData2 = JSONObject(immutable.Map(
        "id" -> 2,
        "choice" -> question.choice2.getOrElse(""),
        "vote" -> voteVal2))

      val choiceData3 = JSONObject(immutable.Map(
        "id" -> 3,
        "choice" -> question.choice3.getOrElse(""),
        "vote" -> voteVal3))

      val choiceData4 = JSONObject(immutable.Map(
        "id" -> 4,
        "choice" -> question.choice4.getOrElse(""),
        "vote" -> voteVal4))

      val choiceData5 = JSONObject(immutable.Map(
        "id" -> 5,
        "choice" -> question.choice5.getOrElse(""),
        "vote" -> voteVal5))

      var choicesList = List.empty[JSONObject]
      if (question.choice3.isEmpty) {
        choicesList = List(choiceData1, choiceData2)
      } else {
        if (question.choice4.isEmpty) {
          choicesList = List(choiceData1, choiceData2, choiceData3)
        } else {
          if (question.choice5.isEmpty) {
            choicesList = List(choiceData1, choiceData2, choiceData3, choiceData4)
          } else {
            choicesList = List(choiceData1, choiceData2, choiceData3, choiceData4, choiceData5)
          }
        }
      }

      val choices = JSONArray(choicesList)

      val json = JSONObject(immutable.Map(
        "qid" -> question.qid,
        "title" -> question.title.getOrElse(""),
        "text" -> question.text.getOrElse(""),
        "choices" -> choices,
        "username" -> question.username.getOrElse(""),
        "password" -> question.password.getOrElse("")))

      return json
    }
  }

  def getList(num: Int): JSONObject = {
    DB.withConnection { implicit c =>

      var resultList = List.empty[JSONObject]
      val list = SQL("Select * from question limit {num}").on('num -> num).as(Question.data *)

      list.foreach { question =>
        val qid = question.qid
        val title = question.title.getOrElse("")
        val text = question.text.getOrElse("")
        val choice1 = question.choice1.getOrElse("")
        val choice2 = question.choice2.getOrElse("")
        val choice3 = question.choice3.getOrElse("")
        val choice4 = question.choice4.getOrElse("")
        val choice5 = question.choice5.getOrElse("")
        val username = question.username.getOrElse("")
        val password = question.password.getOrElse("")

        val m = JSONObject(immutable.Map(
          "qid" -> qid,
          "title" -> title,
          "text" -> text,
          "username" -> username))

        resultList = m :: resultList
      }

      val posts = JSONArray(resultList)
      val json = JSONObject(immutable.Map(
        "posts" -> posts))

      return json
    }
  }
}