// @SOURCE:/Users/takadayuichi/work/vote-api/conf/routes
// @HASH:e343f55ef37ddfd1ddca17e4218d7b1a6b5f6d10
// @DATE:Sun Apr 07 16:36:51 JST 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Post_post1 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("questions/post"))))
        

// @LINE:8
private[this] lazy val controllers_Get_get2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("questions/get"))))
        

// @LINE:9
private[this] lazy val controllers_Get_getget3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("questions/getget"))))
        

// @LINE:12
private[this] lazy val controllers_Assets_at4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+"""))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """questions/post""","""controllers.Post.post"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """questions/get""","""controllers.Get.get"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """questions/getget""","""controllers.Get.getget"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Post_post1(params) => {
   call { 
        invokeHandler(controllers.Post.post, HandlerDef(this, "controllers.Post", "post", Nil,"PUT", """""", Routes.prefix + """questions/post"""))
   }
}
        

// @LINE:8
case controllers_Get_get2(params) => {
   call { 
        invokeHandler(controllers.Get.get, HandlerDef(this, "controllers.Get", "get", Nil,"GET", """""", Routes.prefix + """questions/get"""))
   }
}
        

// @LINE:9
case controllers_Get_getget3(params) => {
   call { 
        invokeHandler(controllers.Get.getget, HandlerDef(this, "controllers.Get", "getget", Nil,"GET", """""", Routes.prefix + """questions/getget"""))
   }
}
        

// @LINE:12
case controllers_Assets_at4(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        