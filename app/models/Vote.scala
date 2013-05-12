package models

import play.api.db._
import scala.util.parsing.json._
import scala.collection.mutable
import scala.collection.immutable

import anorm._
import play.api.Play.current
import anorm.SqlParser._

case class Vote(
  vid: Int,
  qid: Int,
  choice: Int,
  username: Option[String]) {

  def addData {
    DB.withConnection { implicit c =>
      val id: Int = SQL("insert into vote (qid, choice,username) values ({qid}, {choice},{username})").
        on('qid -> this.qid, 'choice -> this.choice, 'username -> this.username).executeUpdate()
    }
  }
}

object Vote {
  def getCountByQid(qid: Int, choice: Int): Int = {
    DB.withConnection { implicit c =>
      val count = SQL("Select count(*) from vote where qid = {qid} and choice = {choice}").on('qid -> qid, 'choice -> choice).as(scalar[Long].single)
      return count.toInt
    }
  }
}
