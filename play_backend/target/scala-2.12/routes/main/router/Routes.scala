
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/matthes/Downloads/play-scala-rest-api-example/conf/routes
// @DATE:Fri Feb 23 10:52:34 CET 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  HomeController_0: controllers.HomeController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    HomeController_0: controllers.HomeController
  ) = this(errorHandler, HomeController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix, """controllers.HomeController.save()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getner""", """controllers.HomeController.getNER()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val controllers_HomeController_save0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_save0_invoker = createInvoker(
    HomeController_0.save(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "save",
      Nil,
      "POST",
      this.prefix + """""",
      """GET  /         controllers.HomeController.index(doc1: String ?= "", doc2: String ?= "")""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_HomeController_getNER1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getner")))
  )
  private[this] lazy val controllers_HomeController_getNER1_invoker = createInvoker(
    HomeController_0.getNER(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getNER",
      Nil,
      "POST",
      this.prefix + """getner""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_HomeController_save0_route(params@_) =>
      call { 
        controllers_HomeController_save0_invoker.call(HomeController_0.save())
      }
  
    // @LINE:4
    case controllers_HomeController_getNER1_route(params@_) =>
      call { 
        controllers_HomeController_getNER1_invoker.call(HomeController_0.getNER())
      }
  }
}
