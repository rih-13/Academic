
public class Letter {
	// This class represents a single letter in a word, with two attributes: char letter and int label
	// auhthor Ria Haque
	
	private char letter;
	private int label;
	// unset = -1, unused = 0, used = 1, correct = 2
	
	private final int UNSET = -1;
	private final int UNUSED = 0;
	private final int USED = 1;
	private final int CORRECT = 2;
	
	//Constructor that takes in param char c and sets letter attribute to c, initializes label to unset
	public Letter(char c) {
		this.letter = c;
		this.label = UNSET;
	}
	
	// Checks if a Letter object has the same letter value of param other object (if it is also a letter object), returns true
	public boolean equals(Object otherObject) {
		boolean equals = false;
		if (otherObject instanceof Letter) {
			Letter letterObject = (Letter) otherObject;
			if (letterObject.letter == this.letter) {
				equals = true;
			}
		}
		return equals;
	}

	// Returns decorative flag that indicates the label of a letter
	public String decorator() {
		String flag ="";
		if (label == UNSET) flag = " ";
		if (label == UNUSED) flag = "-";
		if (label == USED) flag = "+";
		if (label == CORRECT) flag = "!";
		return flag;
	}
	
	// Returns String representation
	public String toString() {
		String printvalue = "";
		printvalue = this.decorator()+this.letter+this.decorator();
		return printvalue;
	}
	
	//Sets label int to unused
	public void setUnused() {
		label = UNUSED;
	}
	
	//Sets label int to used
	public void setUsed() {
		label = USED;
	}
	
	//Sets label int to correct
	public void setCorrect() {
		label = CORRECT;
	}
	
	//Returns true if Letter object's label attribute is set to unused, false otherwise
	public boolean isUnused() {
		boolean isUnused = false;
		if (label == UNUSED) isUnused = true;
		return isUnused;
	}
	
	//Creates array of Letter objects given param String
	public static Letter[] fromString(String s) {
		Letter[] letterArray = new Letter[s.length()];
		for (int i = 0; i < s.length(); i++) {
			Letter temp = new Letter(s.charAt(i));
			letterArray[i] = temp;
		}
		return letterArray;
	}
	
	
	// tests
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Letter mylet = new Letter('a');
		Letter copy = new Letter('a');
		Letter lettwo = new Letter('b');
		System.out.println("a = a?" + mylet.equals(copy));
		System.out.println("a = b?" + mylet.equals(lettwo));
		System.out.println(mylet);
		Letter[] myarray = Letter.fromString("hello");
		for (int i = 0; i < myarray.length; i++) {
			System.out.println(myarray[i]);
		
		

	}
	}
}
	
	
