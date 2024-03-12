
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Scrabble {
/**
 * This class represents a scrabble board ('hand' of tiles, similar to 'hand' of cards), a collection of available tiles of a player during their turn. 
 * Various words can be made from the available tiles, with points awarded to each word based on its spelling.
 * @author Ria Haque - 251164501
*/
	
	
	
	
	/**
	 * Integer array representing the 7 tiles a player has 
	 */
	private Tile[] tiles;
	
	
	
	/**
	 * Default constructor, generates and assigns an integer array of 7 random letters from A to Z inclusive 
	 */
	public Scrabble() {
		Tile[] tileArray = new Tile[7];
		for (int i = 0; i < 7; ++i) {
			Tile pickupTile = new Tile();
			pickupTile.pickup();
			tileArray[i] = pickupTile;
		}
		tiles = tileArray;
	}

	
	/**
	 * Constructor that takes in an array of Tiles and creates a Scrabble board with those seven Tiles
	 * @param tileArray array of Tiles with values already assigned 
	 */
	public Scrabble(Tile[] tileArray) {
		tiles = tileArray;
	}
	
	public Tile[] getTiles() {
		return this.tiles;
	}
	
	
	
	/**
	 * Getter for the seven letters available to a player, in string form
	 * @return tileString the letter values of the seven Tiles, joined into one String 
	 */
	public String getLetters() {
		String tileString = "";
		for (int i = 0; i < this.tiles.length; ++i) {
			char indexChar = this.tiles[i].getValue();
			tileString = tileString + indexChar;
		}
		return tileString;
	}
	
	
	
	/**
	 * Checks if two scrabble boards have the exact same letters at the same frequency, disregarding order
	 * @param other the other scrabble board to be compared to
	 * @return true if  values of both are equal, even if in different order 
	 */
	public Boolean equals (Scrabble other) {
		boolean sameScrabble; 
		
		ArrayList<Character> scrabbleOne = new ArrayList<Character>();
		for (int i = 0; i<this.tiles.length; ++i) {
			scrabbleOne.add(this.tiles[i].getValue());
			}
		
		ArrayList<Character> scrabbleTwo = new ArrayList<Character>();
		for (int i = 0; i<other.tiles.length; ++i) {
			scrabbleTwo.add(other.tiles[i].getValue());
			}
		
		Collections.sort(scrabbleOne);
		Collections.sort(scrabbleTwo);
		sameScrabble = (scrabbleOne.equals(scrabbleTwo));
		return sameScrabble;
	}


	

	
	
	/**
	 * Uses the Collins Scrabble Words 2019 document to generate an ArrayList of all words that can be made using the letters in the scrabble board 
	 * @return ArrayList<String> of all possible words that can be made from the tiles, according to Collins Scrabble 2019
	 * @throws FileNotFoundException
	 */
	public ArrayList<String> getWords() throws FileNotFoundException {
		File myObj = new File("CollinsScrabbleWords2019.txt"); // open file of all possible words
		Scanner scanner = new Scanner(myObj);
		ArrayList<String> wordsSeven = new ArrayList<String>(); // stores words with 7 or less letters
		for (int i = 0; i<279496; ++i) {
			String word = scanner.next();
			if (word.length() < 8) {
				wordsSeven.add(word);
			}
		}
		scanner.close();
		
		
		ArrayList<Character> availableTiles = new ArrayList<Character>(); // stores string versions of tile values for a scrabble 
		for (int i = 0; i<7; ++i) {
			Tile letter = this.getTiles()[i];
			char letterString = letter.getValue();
			availableTiles.add(letterString);
		}
		
		ArrayList<String> wordsToRemove = new ArrayList<String>(); // creates arraylist of words that will be removed from the list of possible words
		
		for (String word: wordsSeven) { // iterate through words in list of possible words 
			ArrayList<Character>tempLetters = new ArrayList<Character>(); // temp arraylist of available tiles to add and remove from, resets each word
			for (char letter: availableTiles) {
				tempLetters.add(letter);
			}
			
			
			ArrayList<Character>wordToCheck = new ArrayList<Character>(); // makes arraylist of chars in word 
			for (int j = 0; j<word.length(); ++j) {
				wordToCheck.add(word.charAt(j));
			}
			
			for (char letter: wordToCheck) { // iterate through letters in arraylist of chars in word
				if (tempLetters.contains(letter)) {
					tempLetters.remove(Character.valueOf(letter)); // remove from temp arraylist of available tiles if found 
				}
				else {
					wordsToRemove.add(word); // add to a list of words that are not possible 
				}
			}
		}
		wordsSeven.removeAll(wordsToRemove); // remove list of not possible words from the word list 
		return wordsSeven;
		
	}
	
	
	
	
	/**
	 * Return an integer array of scores that can be won through all possible words from the Scrabble object's tiles, using Scrabble scoring system
	 * @return integer array of scores of all possible words that can be made, in ascending order
	 * @throws FileNotFoundException
	 */
	public int[] getScores() throws FileNotFoundException {
		HashMap<Character, Integer> points = new HashMap<Character, Integer>();
		points.put('A',1);
		points.put('B',3);
		points.put('C',3);
		points.put('D',2);
		points.put('E',1);
		points.put('F',4);
		points.put('G',2);
		points.put('H',4);
		points.put('I',1);
		points.put('J',8);
		points.put('K',5);
		points.put('L',1);
		points.put('M',3);
		points.put('N',1);
		points.put('O',1);
		points.put('P',3);
		points.put('Q',10);
		points.put('R',1);
		points.put('S',1);
		points.put('T',1);
		points.put('U',1);
		points.put('V',4);
		points.put('W',4);
		points.put('X',8);
		points.put('Y',4);
		points.put('Z',10);
		
		
		ArrayList<String> words = new ArrayList<String>();
		words = this.getWords();
		int[] scores = new int[words.size()];
		int i = 0;
		
		for (String word: words) { // iterate through list of possible words 
			int wordScore = 0;
			ArrayList<Character>wordToScore = new ArrayList<Character>();  // make arraylist of chars in word
			for (int j = 0; j<word.length(); ++j) {
				wordToScore.add(word.charAt(j));
			}
			for (char letter: wordToScore) {
				int tempScore = 0;
				tempScore = points.get(letter);
				wordScore = wordScore + tempScore;
				
			}
			scores[i] = wordScore;
			++i;
		}
		Arrays.sort(scores);
		return scores;
		
	}
	
	
	
	
	
	/**
	 * This is simply a test to ensure the class works
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String [] args) throws FileNotFoundException {
		Tile a = new Tile('a');
		Tile b = new Tile('a');
		Tile c = new Tile('a');
		Tile d = new Tile('a');
		Tile e = new Tile('B');
		Tile f = new Tile('C');
		Tile g = new Tile('H');
		Tile[] mytiles = {a, b, c, d, e, f, g};
		for (int i = 0; i <mytiles.length; ++i) {
			System.out.println(mytiles[i].getValue());
		}
		System.out.println("tile array initialized and assigned values\n");
		
		System.out.println("make my scrabble board using the premade tile array");
		Scrabble myscrabble = new Scrabble(mytiles);
		System.out.println(myscrabble.getLetters());
		
		System.out.println("\nmake a new scrabble board using randomly generated tile array\n");
		Scrabble otherscrabble = new Scrabble();
		System.out.println(otherscrabble.getLetters());
		
		System.out.println("check if the two boards are equal: " + myscrabble.getLetters() + " " + otherscrabble.getLetters());
		System.out.println(myscrabble.equals(otherscrabble));
		
		Tile[] reversetiles = {g, b, a, c, d, f, e};
		Scrabble reversescrabble = new Scrabble(reversetiles);
		System.out.println(myscrabble.getLetters() + " is equal to " + reversescrabble.getLetters());
		System.out.println(myscrabble.equals(reversescrabble));
		
		Scrabble copyscrabble = new Scrabble(mytiles);
		System.out.println(copyscrabble.getLetters() + " will create a copy using the same tile array");
		System.out.println(myscrabble.equals(copyscrabble));
		
	
		
		ArrayList<Character> scrabbleOne = new ArrayList<Character>();
		for (int i = 0; i<myscrabble.tiles.length; ++i) {
			scrabbleOne.add(myscrabble.tiles[i].getValue());
			}
		
		System.out.println("this is " + scrabbleOne);
		
	
	

		

	
		
		
		}
		
		
	
	}
	
	
	
	
	
	
	
	
	

