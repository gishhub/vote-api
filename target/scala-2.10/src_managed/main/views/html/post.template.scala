
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object post extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

<html>
<head>
<title>"""),_display_(Seq[Any](/*5.9*/message)),format.raw/*5.16*/("""</title>
</head>
<body>
<p>"""),_display_(Seq[Any](/*8.5*/message)),format.raw/*8.12*/("""</p>
</body>
</html>
"""))}
    }
    
    def render(message:String): play.api.templates.Html = apply(message)
    
    def f:((String) => play.api.templates.Html) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 24 18:21:35 JST 2013
                    SOURCE: /Users/takadayuichi/work/vote-api/app/views/post.scala.html
                    HASH: ff5f21c2983e35eeee0bf31c8faca97a7686396b
                    MATRIX: 504->1|598->18|656->42|684->49|746->77|774->84
                    LINES: 19->1|22->1|26->5|26->5|29->8|29->8
                    -- GENERATED --
                */
            