
public class WordLL {
	// This class represents a singly linked list of several Word objects that have already been guessed by the user
	
	private Word mysteryWord; // Word object that is the mystery word user is trying to guess
	private LinearNode<Word> history;
	
	
	// Constructor that sets mystery word to param Word mystery, initializes singly linked list with head node
	public WordLL(Word mystery) {
		mysteryWord = mystery;
		LinearNode<Word> history = new LinearNode<Word>();
	}
	
	
	// Takes in param Word guess that the user has guessed, decorates it with letter usage flags and adds it to the front 
	// of the singly linked list, returns true if user guessed correct word and false otherwise
	public boolean tryWord(Word guess) {
		guess.labelWord(this.mysteryWord);
		LinearNode<Word> newGuess = new LinearNode<Word>(guess);
		newGuess.setNext(history);
		history = newGuess;
		
		
		boolean correctWord = false;
		correctWord = guess.labelWord(this.mysteryWord);
		return correctWord;
	
	}
	
	
	// Returns string representation of history in reverse chronological order
	public String toString() {
		String printValue = "";
		LinearNode<Word> curNode = new LinearNode<Word>();
		curNode = history;
		while (curNode != null) {
			printValue += curNode.getElement().toString() +"\n";
			curNode = curNode.getNext();
		}
		return printValue;
	}

	// testing 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Word word1 = new Word(Letter.fromString("OBJECT"));
		Word word2 = new Word(Letter.fromString("CLASS"));
		word2.labelWord(word1);
		Word word3 = new Word(Letter.fromString("CODE"));
		word3.labelWord(word1);
		System.out.println(word1);
		System.out.println(word2);
		System.out.println(word3);
		System.out.println(word1.labelWord(word3));
		
		WordLL wll = new WordLL(new Word(Letter.fromString("OBJECT")));
		String[] arr = {"JOB","TESTING","OBJECTS"};
		for(int i=0;i<arr.length;i++) {
			wll.tryWord( new Word(Letter.fromString(arr[i])) );
		}
		System.out.println("wll: " + wll);
		


	}

}
