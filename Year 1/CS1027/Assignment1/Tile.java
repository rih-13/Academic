import java.util.Random;


public class Tile {
/**
 * This class represents a scrabble tile, which has a letter value that can be used to make words
 * @author Ria Haque - 251164501
 */
	
	
	/**
	 * Represents the letter value of the tile, from A to Z inclusive 
	 */
	private char value; 
	
	
	
	/**
	 * Default constructor
	 */
	public Tile() {
		value = ' ';
	}
	
	/**
	 * constructor builds tile with given letter value 
	 * @param userChar the value of the letter
	 */
	public Tile(char userChar) {
		value = Character.toUpperCase(userChar);
	}
	
	
	/**
	 * assigns random value from A to Z inclusive to tile
	 */
	public void pickup() {
		Random randomInt = new Random();
		char randomChar = (char) (97 + randomInt.nextInt(26));
		randomChar = Character.toUpperCase(randomChar);
		value = randomChar;
	}
	
	/**
	 * returns letter value of tile
	 * @return letter value of tile
	 */
	public char getValue() {
		return value;
	}
	
	/**
	 * checks if two tiles have the same letter value
	 * @param other the other tile to be compared two
	 * @return true if they share the same letter value, else false
	 */
	public Boolean equals (Tile other) {
		if (this.value == other.value) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * This is just a test to see if the class works
	 * @param args
	 */
	public static void main(String [] args) {
		System.out.println("Tile class runs");
		
		Tile word = new Tile();
		Tile character = new Tile('a');
		System.out.println(word.getValue());
		System.out.println(character.getValue());
		System.out.println("characters created ok");
		
		word.pickup();
		System.out.println(word.getValue());
		System.out.println(character.getValue());
		
		String testString = "hello my new character is ";
		testString = testString + word.getValue();
		System.out.println(testString);
		
		System.out.println(word.equals(character));
		
		Tile tileA = new Tile('a');
		Tile tileB = new Tile('b');
		Tile tileCapA = new Tile('A');
		System.out.println(tileA.equals(tileB));
		System.out.println(tileA.equals(tileCapA));
		System.out.println(tileCapA.getValue());
		
		
	}

}
