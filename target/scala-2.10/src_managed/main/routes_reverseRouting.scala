// @SOURCE:/Users/takadayuichi/work/vote-api/conf/routes
// @HASH:9d2174bf2fbd4a2f00d8dd4a3fcb837cd792bbe6
// @DATE:Sat Apr 13 15:28:39 JST 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:13
class ReverseAssets {
    

// @LINE:13
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:10
class ReverseGetList {
    

// @LINE:10
def getList(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "questions/get/list")
}
                                                
    
}
                          

// @LINE:8
class ReverseGet {
    

// @LINE:8
def get(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "questions/get")
}
                                                
    
}
                          

// @LINE:7
class ReversePost {
    

// @LINE:7
def post(): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "questions/post")
}
                                                
    
}
                          

// @LINE:9
class ReverseVote {
    

// @LINE:9
def vote(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "questions/vote")
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:13
class ReverseAssets {
    

// @LINE:13
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:10
class ReverseGetList {
    

// @LINE:10
def getList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GetList.getList",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "questions/get/list"})
      }
   """
)
                        
    
}
              

// @LINE:8
class ReverseGet {
    

// @LINE:8
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Get.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "questions/get"})
      }
   """
)
                        
    
}
              

// @LINE:7
class ReversePost {
    

// @LINE:7
def post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Post.post",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "questions/post"})
      }
   """
)
                        
    
}
              

// @LINE:9
class ReverseVote {
    

// @LINE:9
def vote : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Vote.vote",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "questions/vote"})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:13
class ReverseAssets {
    

// @LINE:13
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:10
class ReverseGetList {
    

// @LINE:10
def getList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GetList.getList(), HandlerDef(this, "controllers.GetList", "getList", Seq(), "GET", """""", _prefix + """questions/get/list""")
)
                      
    
}
                          

// @LINE:8
class ReverseGet {
    

// @LINE:8
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Get.get(), HandlerDef(this, "controllers.Get", "get", Seq(), "GET", """""", _prefix + """questions/get""")
)
                      
    
}
                          

// @LINE:7
class ReversePost {
    

// @LINE:7
def post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Post.post(), HandlerDef(this, "controllers.Post", "post", Seq(), "PUT", """""", _prefix + """questions/post""")
)
                      
    
}
                          

// @LINE:9
class ReverseVote {
    

// @LINE:9
def vote(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Vote.vote(), HandlerDef(this, "controllers.Vote", "vote", Seq(), "POST", """""", _prefix + """questions/vote""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
                  
      