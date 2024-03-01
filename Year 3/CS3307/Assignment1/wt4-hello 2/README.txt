RUNNING WORDLE 
Author: Ria Haque
Date: October 3 2023
-----------------------------------

The Worlde app can be built simply by executing in the assignment directory: 
  >  make

Afterwards, run the command:
  > ./hello --docroot . --http-listen 0.0.0.0:8080

You can then open the application by going to localhost:8080 in your browser. Instead of 8080, another port number can be used. 

The answer will be printed to the terminal if needed. 




TROUBLESHOOTING
-----------------------------------

It is configured to use the default Wt installation path, /usr/local.  If Wt has
been installed in a different folder, you can edit the Makefile and change
the WT_BASE variable to indicate where things are installed. 


If you would like to tailor things further, running:

  > ./hello --help

will report a full set of command line options for the application.