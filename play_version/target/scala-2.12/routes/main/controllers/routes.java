
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/matthes/Downloads/play-scala-rest-api-example/conf/routes
// @DATE:Fri Feb 23 10:52:34 CET 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
