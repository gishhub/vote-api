
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("質問投稿")/*1.14*/ {_display_(Seq[Any](format.raw/*1.16*/("""
<form action="questions/post" method="put">
	title:<input type="text" name="title"><br>
	text:<input type="text" name="text"><br>
	choice1:<input type="text" name="choice1"><br>
	choice2:<input type="text" name="choice2"><br>
	choice3:<input type="text" name="choice3"><br>
	choice4:<input type="text" name="choice4"><br>
	choice5:<input type="text" name="choice5"><br>
	username:<input type="text" name="username"><br>
	password:<input type="text" name="password"><br>
	<input type="submit" value="送信">
</form>
""")))})))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 24 18:21:34 JST 2013
                    SOURCE: /Users/takadayuichi/work/vote-api/app/views/index.scala.html
                    HASH: 87b285cb203464c50bfd70f4541bbf013d4459a6
                    MATRIX: 578->1|598->13|637->15
                    LINES: 22->1|22->1|22->1
                    -- GENERATED --
                */
            