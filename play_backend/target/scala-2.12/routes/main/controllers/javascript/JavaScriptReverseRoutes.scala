
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/matthes/Documents/DATEN/work/DFKI/projects/sd4w/server_version/play_backend/conf/routes
// @DATE:Fri Feb 23 16:41:34 CET 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers.javascript {

  // @LINE:2
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def save: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.save",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:4
    def getNER: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getNER",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getner"})
        }
      """
    )
  
  }


}
