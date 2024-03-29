/*
 * Copyright (C) 2008 Emweb bv, Herent, Belgium.
 * Author: Ria Haque
 * Description: main file used to start and run program
 * Date: October 3 2023
 */

#include <Wt/WApplication.h>
#include "WordleApplication.h"

int main(int argc, char **argv)
{
  /*
   * Your main method may set up some shared resources, but should then
   * start the server application (FastCGI or httpd) that starts listening
   * for requests, and handles all of the application life cycles.
   *
   * The last argument to WRun specifies the function that will instantiate
   * new application objects. That function is executed when a new user surfs
   * to the Wt application, and after the library has negotiated browser
   * support. The function should return a newly instantiated application
   * object.
   */




  // Wrun takes arguments and configures server (WServer), accepts connections, new connection return unique_ptr to WApplication
  //One instance of WApplication pers session 
  return Wt::WRun(argc, argv, [](const Wt::WEnvironment &env) {
    /*
     * You could read information from the environment to decide whether
     * the user has permission to start a new application
     */
    return std::make_unique<WorldeApplication>(env);
  });




}
