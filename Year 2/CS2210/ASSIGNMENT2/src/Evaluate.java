
public class Evaluate {
	
	private char gameboard[][];
	private int size;
	private int tilesToWin;
	private int maxLevels;
	
	public Evaluate (int size, int tilesToWin, int maxLevels) {
		this.size = size;
		this.tilesToWin = tilesToWin;
		this.maxLevels = maxLevels;
		gameboard = new char[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				gameboard[i][j] = 'e';
			}
		}
	}
	
	
	/* Creates and returns empty dictionary */
	public Dictionary createDictionary() {
		Dictionary dict = new Dictionary(9679); /* size of dictionary is prime number */
		return dict;
	}
	
	
	/* Stores a character in the gameboard at position row,col */
	public void storePlay(int row, int col, char symbol) {
		gameboard[row][col] = symbol;
	}
	
	
	/* Returns Boolean true if tile at row,col is empty */
	public boolean squareIsEmpty (int row, int col) {
		return Character.toString(gameboard[row][col]).equals("e"); /* convert gameboard position to string and compare to e*/
	}
	
	
	
	/* Returns Boolean true if tile at row,col is occupied by computer */
	public boolean tileOfComputer (int row, int col) {
		return Character.toString(gameboard[row][col]).equals("c"); /* convert gameboard position to string and compare  to c*/
	}
	
	
	
	/* Returns Boolean true if tile at row,col is occupied by human */
	public boolean tileOfHuman (int row, int col) {
		return Character.toString(gameboard[row][col]).equals("h"); /* convert gameboard position to string and compare to h*/
	}
	
	
	
	/* Converts a char[][] array into a String representing the game state top-bottom left-right, returns String */
	private String convertString(char gameboard[][]) {
		String gameString = new String("");
		for (int col = 0; col < size; col++) {
			for (int row = 0; row < size; row ++) {
				gameString = gameString + gameboard[row][col];
				
			}
		}
		return gameString;	
	}
	
	/* Converts gameboard array to String,if dictionary contains Record with key same as String returns Record, otherwise null */
	public Record repeatedState(Dictionary dict) {
		String key = convertString(gameboard);
		return dict.get(key);
	}
	
	/* Converts gameboard array to String, creates a Record object storing the String and parameters score and level
	 * Stores Record object in the dictionary, if the String is not already used as a key
	 */
	public void insertState(Dictionary dict, int score, int level) {
		String key = convertString(gameboard);
		if (dict.get(key) != null) { /* if the String is not already used as a key in the dictionary, create and store Record*/
			Record newRec = new Record(key, score, level);
			dict.put(newRec);
		}
	}
	
	/* Returns Boolean true if no tiles are empty in gameboard, else false */
	public boolean isDraw() {
		for (int col = 0; col < size; col++) {
			for (int row = 0; row < size; row ++) {
				if (gameboard[row][col] == 'e') return false; /* if empty tile exists return false */
				
			}
		}
		return true; /* if no empty tiles, returns true */
	}
	
	

	public boolean wins (char symbol) {
		
		boolean win = false;
		
		/* Win by making a horizontal row */
		for (int row = 0; row < size; row++) { /* go through each row at a time*/
			int count = 0; /* count tiles with winning char */
			for (int col = 0; col < size; col++) { /* check each tile in the row */
				if (gameboard[row][col] == symbol) count++;
				else count = 0; /* if streak of chars is interrupted by other symbol, start count over again */
				if (count == tilesToWin) return true;
			}	
		}
		
		/* Win by making a vertical row */
		for (int col = 0; col < size; col++) { /* go through each column at a time*/
			int count = 0; /* count tiles with winning char */
			for (int row = 0; row < size; row++) { /* check each tile in the column */
				if (gameboard[row][col] == symbol) count++;
				else count = 0; /* if streak of chars is interrupted by other symbol, start count over again */
				if (count == tilesToWin) return true;
			}	
		}
		
		/* Win by making diagonal row */ 
		int count = 0;
		for (int place = 0; place < size; place++) { /* row=col in diagonals, so move through each tile diagonally */
			if (gameboard[place][place] == symbol) count++;
			else count = 0; /* if streak of chars is interrupted by other symbol, start count over again */
			if (count == tilesToWin) return true;
		}
		
		
		/* Win by making anti diagonal */
		count = 0; /* restart count if win still not found */
		for (int row = 0; row < size; row++) { /* go through each row */
			if (gameboard[row][size -1 - row] == symbol) count++; /* move backwards one spot each row */
			else count = 0;
			if (count == tilesToWin) return true;
		}
		
		return false; /* if no wins found and true is not returned, return false */

	}
	
	public int evalBoard() {
		if (this.isDraw() == true) return 1; /* if draw return 2 */
		
		else if (this.wins('h') == true) return 0; /* if human has made winning streak, 0*/
		
		else if (this.wins('h') == true) return 0; /* if human has made winning streak, 3 */
		
		else return 1; /* if neither won and no draw, return 1 */
		
	}
	
	
	public static void main(String[] args) {
		Evaluate testEv = new Evaluate(3, 3, 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(testEv.gameboard[i][j]);
			}
		}
		String testString = testEv.convertString(testEv.gameboard);
		System.out.println("String is empty: " + testString);
		System.out.println("WIn? " + testEv.wins('h'));
		testEv.storePlay(0, 2, 'h');
		testEv.storePlay(1, 1, 'h');
		testEv.storePlay(2, 0, 'h');
		System.out.println("String is now: " + testEv.convertString(testEv.gameboard));
		System.out.println("WIn? " + testEv.wins('h'));
		}

	
	
	
}
