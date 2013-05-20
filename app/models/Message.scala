package models

import scala.util.parsing.json._
import scala.collection.immutable

object Message {
  val warnMessage = JSONObject(immutable.Map(
    "status" -> "warn",
    "message" -> "存在しないqidがリクエストされました"))
}