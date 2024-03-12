
import java.util.ArrayList;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		ArrayList<String> wordsSevent= new ArrayList<String>(); //create arraylist of possible words 
		wordsSevent.add("AA");
		wordsSevent.add("AAH");
		wordsSevent.add("AAHED");
		wordsSevent.add("AND");
		wordsSevent.add("BY");
		for (String word: wordsSevent) {
			System.out.print(word + ",");
		}
		
		
		ArrayList<Character> availableTilest = new ArrayList<Character>(); // stores char versions of tile values we can use 
		availableTilest.add('B');
		availableTilest.add('Y');
		availableTilest.add('R');
		availableTilest.add('A');
		availableTilest.add('H');
		System.out.println("\n these are the tiles we have made " + availableTilest);
		
	
		
		ArrayList<String> wordsToRemove = new ArrayList<String>(); // creates arraylist of words that will be removed from the list of possible words
		
		for (String word: wordsSevent) { // iterate through words in list of possible words 
			ArrayList<Character>tempLetters = new ArrayList<Character>(); // temp arraylist of available tiles to add and remove from, resets each word
			for (char letter: availableTilest) {
				tempLetters.add(letter);
			}
			
			
			
			System.out.println("\n\nword to check: " + word);
			ArrayList<Character>wordToCheck = new ArrayList<Character>(); // makes arraylist of chars in word 
			for (int j = 0; j<word.length(); ++j) {
				wordToCheck.add(word.charAt(j));
			}
			System.out.println(wordToCheck + " is the arraylist of chars we made for this word");
			
			
			
			for (char letter: wordToCheck) { // iterate through letters in arraylist of chars in word
				if (tempLetters.contains(letter)) {
					System.out.println("we have the tile " + letter);
					tempLetters.remove(Character.valueOf(letter)); // remove from temp arraylist of available tiles if found 
				}
				else {
					System.out.println("letter not found " + letter);
					wordsToRemove.add(word); // add to a list of words that are not possible 
				}
			}
			System.out.println("tiles we have left after going through this word: " + tempLetters);
		}
		
		wordsSevent.removeAll(wordsToRemove); // remove list of not possible words from the word list 
		System.out.println("final result for words you can make: " + wordsSevent);
		
		}
	}
