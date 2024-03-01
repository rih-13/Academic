
/* Class: Record
 * Author: Ria Haque 251164501
 * Purpose: This class represents a record of a game that was played, including the board, level, and score.
 * 
 */



public class Record {
	private String key;
	private int score;
	private int level;
	
	public Record(String key, int score, int level) {
		this.key = key;
		this.score = score;
		this.level = level;
	}
	
	
	public String getKey() {
		return this.key;
	}
	
	public int getScore() {
		return this.score;
	}

	public int getLevel() {
		return this.level;
	}
	
	 public static void main(String[] args) {
		 /* FOR TESTING */
		 
		 Record r1 = new Record("eeeeeeeeeeeeeeee", 1, 3);
		 System.out.println(r1.getKey());
		 System.out.println(r1.getScore());
		 System.out.println(r1.getLevel());
		 
		 
		 
	    }

}
