
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/matthes/Documents/DATEN/work/DFKI/projects/sd4w/server_version/play_backend/conf/routes
// @DATE:Fri Feb 23 16:41:34 CET 2018


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
