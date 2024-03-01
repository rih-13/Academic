/*
 * Copyright (C) 2008 Emweb bv, Herent, Belgium.
 * Author: Ria Haque
 * Description: C file for WordleApplication class - main class handling and displaying Wordle game
 * Main application file, sets up and runs game
 * Date: October 3 2023
 */




#include <Wt/WApplication.h>
#include <Wt/WBreak.h>
#include <Wt/WContainerWidget.h>
#include <Wt/WLineEdit.h>
#include <Wt/WPushButton.h>
#include <Wt/WText.h>
#include "WordleApplication.h"
#define NUM_WORDS 16 /* Number of words in words.txt file*/




/**
 * Constructor for WordleApplication - initializes a new instance of the WordleApplication class, sets up game session
 * @param env A reference to the WEnvironment object that contains information about the new session.
 * @return   No value is returned.
 */
WorldeApplication::WorldeApplication(const Wt::WEnvironment& env)
  : WApplication(env)
{

  /* Initialize variables */
  word = "";
  userGuesses = 0;
  answer = generateAnswer();
  std::cout << "answer is " << answer << std::endl;
  

  /* Set up webpage design*/
  setTitle("Wordle");                            // application title
  root()->addWidget(std::make_unique<Wt::WText>("Enter your guess: ")); // add Widget with text to root 

  userInput_ = root()->addWidget(std::make_unique<Wt::WLineEdit>()); // add text input 
  userInput_->setFocus(); 
  userInput_->setMaxLength(5);

  button_ = root()->addWidget(std::make_unique<Wt::WPushButton>("Results"));  
  button_->setMargin(35, Wt::Side::Left);                   // add 35 pixels margin
  root()->addWidget(std::make_unique<Wt::WBreak>());    // insert a line break

  greeting_ = root()->addWidget(std::make_unique<Wt::WText>()); // add greeting (empty at start)
  wordContainer_ = root()->addWidget(std::make_unique<Wt::WContainerWidget>());


  /*
   * Connect signals with slots simple Wt-way: specify object and method
   */
  button_->clicked().connect(this, &WorldeApplication::seeResults);


  /*
   * - using an arbitrary function object, e.g. useful to bind values with std::bind() to the resulting method call
   */
  userInput_->enterPressed().connect(std::bind(&WorldeApplication::seeResults, this));

  /* if error in reading files, display error */
  if (answer == "error") {
    handleError();
  }

}

void WorldeApplication::handleError() {
  greeting_->setText("Error in accessing files.");
  userInput_->setText("");
  userInput_->setDisabled(false);
  button_->setText("Not available");
}

/**
 * Destructor for WorldeApplication.
 * @return No value is returned.
 */
WorldeApplication::~WorldeApplication() {

}


/**
 * isValid()  - checks if a given word is valid wordle input, ie. non-empty, alphabetic characters only, and 5 charcaters or less *
 * @param word The word to be validated as a string.
 * @return `true` if the word is valid; `false` otherwise.
 */
bool WorldeApplication::isValid(std::string word) {
  // If word containts numbers/symbols
  for (char character : word) {
    if (!isalpha(character)) {
      return false;
    }
  }
    //if no word entered
  if (word.empty()) {
      return false;
  }

    // If word is longer than 5
  if (word.length() > 5) {
    return false;
  }
  
  return true;

}

/** seeResults - process user input (in word) and display game result on webpage
* stores and retrieves user input, check validity, checks result of guess, displays webapge accordingly
* @return No value is returned.
*/
void WorldeApplication::seeResults()
{

  word = userInput_->text().toUTF8();
  transform(word.begin(), word.end(), word.begin(), ::tolower); //store lowercase
  bool gameWin;

  if (isValid(word) == false) {
    greeting_->setText("Invalid input. Please try again.");
      userInput_->setText("");
  }

  else {

    gameWin = addWord(word);
    if (gameWin) { //guess is right
      winGame();
    }
    
    else {//guess is wrong
      greeting_->setText("Your guess was " + word);
      userInput_->setText("");
      userGuesses++;

      if (userGuesses == 6) { //no tries left
        greeting_->setText("You lost. Thank you for playing!");
        button_->setText("Play Again");
        userInput_->setDisabled(true);
        button_->clicked().connect([=]() {
          resetGame();
          root()->doJavaScript("location.reload(true);");
        });  
      }

    }
    
  }

  
}

bool WorldeApplication::addWord(std::string word) {
  Wt::WContainerWidget* characterContainer = root()->addWidget(std::make_unique<Wt::WContainerWidget>());
  int i = 0;
  int correctLetters = 0;
  for (char character : word) {
      Wt::WText *charWidget_;
      std::string charString;
      charString = word[i];
      std::string charResult = decorateLetter(charString, i);
      transform(charString.begin(), charString.end(), charString.begin(), ::toupper); //display uppercase
      charWidget_ = root()->addWidget(std::make_unique<Wt::WText>(charString));
      if (charResult == "used") {
        charWidget_->decorationStyle().setForegroundColor(Wt::WColor("red"));
      }
      else if (charResult == "correct") {
        charWidget_->decorationStyle().setForegroundColor(Wt::WColor("green"));
        correctLetters++;
      }
      else {
        charWidget_->decorationStyle().setForegroundColor(Wt::WColor("gray"));
      }
      i++;

  }
  if (correctLetters == 5) {
    return true;
  }
  return false;
}


/**
 * decorateLetter(string Letter, int pos) - display a word's characters on the screen with appropriate coloring
 * @param word The word to be displaye
 * @return `true` if word is correct; otherwise, `false`.
 */
std::string WorldeApplication::decorateLetter(std::string letter, int pos) {
  for (int answerPos = 0; answerPos < 5; answerPos++) {

    if (answer[answerPos] == letter[0]) {
      if (answer[pos] == word[pos]) {
        //cout << "answerPos is " << answerPos << " and answer[answerPOs] os " << answer[answerPos] << endl;
        //cout << "pos is " << pos << " and word[pos] is " << word[pos] << endl;
        return "correct";
      }
      else { return "used";}
    }
  }

  return "unused";
}

/** winGame() - displays webapge accordingly if user wins game 
 * displays message, disables further user input, connects the button to a function for resetting the game
 * @return No value is returned.
 */
void WorldeApplication::winGame() {
  greeting_->setText("Congratulations! You won");
  button_->setText("Play Again");
  userInput_->setDisabled(true);
  
  button_->clicked().connect([=]() {
    resetGame();
    root()->doJavaScript("location.reload(true);");
  });
  
}

/* generateAnswer() - generates random word from file and returns string containing it
if error in reading file, displays error message and returns string "error"
 @return returns string - randomly generated word if file reading is successful, error otherwise*/
std::string WorldeApplication::generateAnswer() {
    std::string newWord;
    std::ifstream inputFile("words.txt");
    std::vector<std::string> wordArray;

    if (!inputFile.is_open()) {
        std::cerr << "Error in accessing the text file." << std::endl;
        return "error"; 
    }
    while (std::getline(inputFile, newWord)) {
        wordArray.push_back(newWord); // Add each word
    }

    inputFile.close();

    for (int i = 0; i < NUM_WORDS ; i++) {
      std::cout << "word array[" << i << "] is " << wordArray[i] << std::endl;
    }

    int pos = rand() % NUM_WORDS + 1; //generate number from 1 to NUM-WORDS
    return wordArray[pos];
}

/* resetGame() - resets webpage to new game 
@return no values are returned*/
void WorldeApplication::resetGame() {
  generateAnswer(); // Reset the answer
  userGuesses = 0;
  greeting_->setText("");
  userInput_->setText("");
  userInput_->setDisabled(false);
  button_->setText("Results");
}