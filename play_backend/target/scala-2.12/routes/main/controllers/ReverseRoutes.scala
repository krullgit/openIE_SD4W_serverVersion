
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/matthes/Downloads/play-scala-rest-api-example/conf/routes
// @DATE:Fri Feb 23 10:52:34 CET 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers {

  // @LINE:2
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def save(): Call = {
      
      Call("POST", _prefix)
    }
  
    // @LINE:4
    def getNER(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getner")
    }
  
  }


}
