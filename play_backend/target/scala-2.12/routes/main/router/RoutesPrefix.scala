
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/matthes/Downloads/play-scala-rest-api-example/conf/routes
// @DATE:Fri Feb 23 10:52:34 CET 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
