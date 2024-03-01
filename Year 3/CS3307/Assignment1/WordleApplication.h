/*
 * Copyright (C) 2008 Emweb bv, Herent, Belgium.
 * Author Ria Haque (251164501) 
 * Description: Header file for WordleApplication class - main class handling and displaying Wordle game
 * Date: October 3 2023
 */

#ifndef WORDLEAPPLICATION_H
#define WORDLEAPPLICATION_H

#include <string> //for strings
#include <algorithm> // for transform function
#include<ctype.h> //for isalpha function
#include <fstream> //read file
#include <iostream> //read file

#include <Wt/WApplication.h>
#include <Wt/WBreak.h>
#include <Wt/WContainerWidget.h>
#include <Wt/WLineEdit.h>
#include <Wt/WPushButton.h>
#include <Wt/WText.h>
#include <Wt/WColor.h> //for colors
#include <Wt/WText.h>       //  WText widget header
#include <Wt/WFont.h>       //  WFont class header

#endif

/*
 * A simple hello world application class which demonstrates how to react
 * to events, read input, and give feed-back.
 */

class WorldeApplication : public Wt::WApplication
{

public:
  WorldeApplication(const Wt::WEnvironment& env);
  ~WorldeApplication();

private:
  Wt::WLineEdit *userInput_;
  Wt::WText     *greeting_;
  Wt::WPushButton *button_;
  Wt::WContainerWidget *wordContainer_;
  int userGuesses; /* int representing number of guesses user has made*/
  std::string answer; /* string representing current answer */
  std::string word; /* string representing user's current entered word*/


  void handleError();
  bool isValid(std::string word);
  void seeResults();
  std::string decorateLetter(std::string letter, int pos);
  bool addWord(std::string word);
  void winGame();
  std::string generateAnswer();
  void resetGame();


};
