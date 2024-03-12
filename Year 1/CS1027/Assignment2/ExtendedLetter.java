
public class ExtendedLetter extends Letter {
	// This class extends the Letter class and adds certain functionalities like being able to group letters together
	// author Ria Haque

	private String content;
	private int family;
	private boolean related;
	private final int SINGLETON = -1;
	
	
	//Constructor that sets char attribute letter to 'a' (not important which letter it is) =, String content to param 
	// String s, boolean related to false, and int family to SINGLETON (-1)
	public ExtendedLetter(String s) {
		super('a');
		content = s;
		related = false;
		family = SINGLETON;
		
	}
	
	//Constructor that sets char attribute letter to 'a' (not important which letter it is) =, String content to param 
	// String s, boolean related to false, and int family to param int fam
	public ExtendedLetter(String s, int fam) {
		super('a');
		content = s;
		related = false;
		family = fam;
		
	}
	
	//Checks if this ExtendedLetter object is equal to another, returns true if other object is an instance of ExtendedLetter
	// and they share the same value for content, sets this related attribute to true if they share the same value for family
	public boolean equals(Object other) {
		boolean same = false;
		if (other instanceof Letter) {
			ExtendedLetter otherExtended = (ExtendedLetter) other;
			if (this.family == otherExtended.family) this.related = true;
			if (this.content == otherExtended.content) same = true;
		}
		return same;
	}
	
	//returns string representation
	public String toString() {
		String printValue = "";
		if (this.isUnused() == true && this.related == true) {
			printValue += "."+this.content+".";
		}
		else {
			printValue += this.decorator()+this.content+this.decorator();
		}
		return printValue;
	}
	
	// Creates and returns a Letter/ExtendedLetter array that corresponds to param StringArray content
	// If optional param IntArray codes is provided, sets family values 
	public static Letter[] fromStrings(String[] content, int[] codes) {
		Letter[] letters = new Letter[content.length];
		if (codes == null) {
			for (int i = 0; i<content.length; i++) {
				letters[i] = new ExtendedLetter(content[i]);
			}
		}
		else {
			for (int i = 0; i<content.length; i++) {
				letters[i] = new ExtendedLetter(content[i], codes[i]);
			}
		}
		return letters;
	}
	
	
	//tests
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
