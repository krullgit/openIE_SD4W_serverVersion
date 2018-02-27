
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/matthes/Documents/DATEN/work/DFKI/projects/sd4w/server_version/play_backend/conf/routes
// @DATE:Fri Feb 23 16:41:34 CET 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
