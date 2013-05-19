// @SOURCE:/Users/takadayuichi/work/vote-api/conf/routes
// @HASH:900572cb1cc0186157e52f265290e526106ae5d5
// @DATE:Sun May 19 16:17:51 JST 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._
import java.net.URLEncoder

import play.api.mvc._


import Router.queryString


// @LINE:12
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:12
class ReverseAssets {
    

// @LINE:12
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:6
class ReversePostQuestion {
    

// @LINE:6
def postQuestion(): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "questions/post")
}
                                                
    
}
                          

// @LINE:7
class ReverseGetQuestion {
    

// @LINE:7
def getQuestion(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "questions/get")
}
                                                
    
}
                          

// @LINE:8
class ReverseGetQuestionList {
    

// @LINE:8
def getQuestionList(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "questions/get/list")
}
                                                
    
}
                          

// @LINE:9
class ReversePostVote {
    

// @LINE:9
def PostVote(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "questions/vote")
}
                                                
    
}
                          
}
                  


// @LINE:12
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:12
class ReverseAssets {
    

// @LINE:12
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReversePostQuestion {
    

// @LINE:6
def postQuestion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PostQuestion.postQuestion",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "questions/post"})
      }
   """
)
                        
    
}
              

// @LINE:7
class ReverseGetQuestion {
    

// @LINE:7
def getQuestion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GetQuestion.getQuestion",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "questions/get"})
      }
   """
)
                        
    
}
              

// @LINE:8
class ReverseGetQuestionList {
    

// @LINE:8
def getQuestionList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GetQuestionList.getQuestionList",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "questions/get/list"})
      }
   """
)
                        
    
}
              

// @LINE:9
class ReversePostVote {
    

// @LINE:9
def PostVote : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PostVote.PostVote",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "questions/vote"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:12
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:12
class ReverseAssets {
    

// @LINE:12
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:6
class ReversePostQuestion {
    

// @LINE:6
def postQuestion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PostQuestion.postQuestion(), HandlerDef(this, "controllers.PostQuestion", "postQuestion", Seq(), "PUT", """ Home page""", _prefix + """questions/post""")
)
                      
    
}
                          

// @LINE:7
class ReverseGetQuestion {
    

// @LINE:7
def getQuestion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GetQuestion.getQuestion(), HandlerDef(this, "controllers.GetQuestion", "getQuestion", Seq(), "GET", """""", _prefix + """questions/get""")
)
                      
    
}
                          

// @LINE:8
class ReverseGetQuestionList {
    

// @LINE:8
def getQuestionList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GetQuestionList.getQuestionList(), HandlerDef(this, "controllers.GetQuestionList", "getQuestionList", Seq(), "GET", """""", _prefix + """questions/get/list""")
)
                      
    
}
                          

// @LINE:9
class ReversePostVote {
    

// @LINE:9
def PostVote(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PostVote.PostVote(), HandlerDef(this, "controllers.PostVote", "PostVote", Seq(), "POST", """""", _prefix + """questions/vote""")
)
                      
    
}
                          
}
                  
      