import play.api._
import play.api.mvc._
import play.api.mvc.Results._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    Logger.info("Application has started")
  }

  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
  }
  override def onError(request: RequestHeader, ex: Throwable) = {
    Logger.error("InternalServerError!")
    InternalServerError("""{"status" : "error", "message" : "InternalServerError"}""")
  }

  override def onBadRequest(request: RequestHeader, error: String) = {
    Logger.error("Bad Request!")
    BadRequest("""{"status" : "error", "message" : "Bad Request. """ + error + """"}""")
  }

  override def onHandlerNotFound(request: RequestHeader): Result = {
    Logger.error("Not Found!")
    NotFound("""{"status" : "error", "message" : "NotFound"}""")
  }
}