// @SOURCE:/Users/takadayuichi/work/vote-api/conf/routes
// @HASH:900572cb1cc0186157e52f265290e526106ae5d5
// @DATE:Sun May 19 16:17:51 JST 2013


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
private[this] lazy val controllers_PostQuestion_postQuestion0 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("questions/post"))))
        

// @LINE:7
private[this] lazy val controllers_GetQuestion_getQuestion1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("questions/get"))))
        

// @LINE:8
private[this] lazy val controllers_GetQuestionList_getQuestionList2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("questions/get/list"))))
        

// @LINE:9
private[this] lazy val controllers_PostVote_PostVote3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("questions/vote"))))
        

// @LINE:12
private[this] lazy val controllers_Assets_at4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """questions/post""","""controllers.PostQuestion.postQuestion"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """questions/get""","""controllers.GetQuestion.getQuestion"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """questions/get/list""","""controllers.GetQuestionList.getQuestionList"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """questions/vote""","""controllers.PostVote.PostVote"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_PostQuestion_postQuestion0(params) => {
   call { 
        invokeHandler(controllers.PostQuestion.postQuestion, HandlerDef(this, "controllers.PostQuestion", "postQuestion", Nil,"PUT", """ Home page""", Routes.prefix + """questions/post"""))
   }
}
        

// @LINE:7
case controllers_GetQuestion_getQuestion1(params) => {
   call { 
        invokeHandler(controllers.GetQuestion.getQuestion, HandlerDef(this, "controllers.GetQuestion", "getQuestion", Nil,"GET", """""", Routes.prefix + """questions/get"""))
   }
}
        

// @LINE:8
case controllers_GetQuestionList_getQuestionList2(params) => {
   call { 
        invokeHandler(controllers.GetQuestionList.getQuestionList, HandlerDef(this, "controllers.GetQuestionList", "getQuestionList", Nil,"GET", """""", Routes.prefix + """questions/get/list"""))
   }
}
        

// @LINE:9
case controllers_PostVote_PostVote3(params) => {
   call { 
        invokeHandler(controllers.PostVote.PostVote, HandlerDef(this, "controllers.PostVote", "PostVote", Nil,"POST", """""", Routes.prefix + """questions/vote"""))
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
        