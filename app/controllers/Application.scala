package controllers

import play.api._
import play.api.mvc._

import com.mongodb.casbah.Imports._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }
}
