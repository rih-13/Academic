import java.util.ArrayList;



public class Word {
	// This class represents a word, made of individual letters, that can be guessed by the user
	// author Ria Haque 
	
	private LinearNode<Letter> firstLetter;

	
	//Constructor that creates a singly linked list given param array of Letter objects
	public Word(Letter[] letters) {
		LinearNode<Letter> head = new LinearNode<Letter>();;
		firstLetter = head;
		LinearNode<Letter> curNode = head;
		for (int i = 0; i < letters.length; i++) {
			curNode.setElement(letters[i]);
			LinearNode<Letter> node = new LinearNode<Letter>();
			curNode.setNext(node);
			//System.out.println("node: " + curNode.getElement());
			curNode = node;	
		}
		
	}
	
	// Returns String representation of word
	public String toString() {
		String printValue = "Word: ";
		LinearNode<Letter> curNode = this.firstLetter;
		while (curNode.getElement() != null) {
			printValue += curNode.getElement() + " ";
			curNode = curNode.getNext();
		}
		return printValue;
	}
	
	//Given param Word mystery, compares to this Letter object and decorates it accordingly with the letter usage flags
	// Returns true if this Word object and other Word object represents the same word, false otherwise
	public boolean labelWord(Word mystery) {
		Letter[] myWord = new Letter[this.getSize()];
		int i = 0;
		LinearNode<Letter> curNode = this.firstLetter;
		while (curNode.getElement() != null) {
			myWord[i] = curNode.getElement();
			i++;
			curNode = curNode.getNext();
		}
		
		Letter[] mysteryArray = new Letter[mystery.getSize()];
		int h = 0;
		LinearNode<Letter> curNodeMystery = mystery.firstLetter;
		while (curNodeMystery.getElement() != null) {
			mysteryArray[h] = curNodeMystery.getElement();
			h++;
			curNodeMystery = curNodeMystery.getNext();
		}
		
		for (int inWord = 0; inWord < this.getSize(); inWord++) {
			Letter curLetter = myWord[inWord];
			curLetter.setUnused();
			for (int inMys = 0; inMys < mystery.getSize(); inMys++) {
				if (curLetter.equals(mysteryArray[inMys])) {
					curLetter.setUsed();
					if (inWord == inMys) curLetter.setCorrect();
				}
			}
		}
		
		
		boolean correctWord = false;
		if (mystery.getSize() == this.getSize()) {
			correctWord = true;
			for (int compareNum = 0; compareNum < mystery.getSize(); compareNum++) {
				if (myWord[compareNum].equals(mysteryArray[compareNum])) {
				}
				else {
					correctWord = false;
				}
			}
			
		}
		
		return correctWord;
	}



	// Private helper method, returns int representing the amount of elements in a Word object
	private int getSize() {
		int size = 0;
		LinearNode<Letter> curNode = this.firstLetter;
		while (curNode.getElement() != null) {
			size++;
			curNode = curNode.getNext();
		}
		return size;	
	}	
	
	
	// tests
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		Letter letter1 = new Letter('H');
		Letter letter2 = new Letter('E');
		Letter letter3 = new Letter('N');
		Letter[] letters = new Letter[3];
		letters[0] = letter1;
		letters[1] = letter2;
		//letters[2] = letter3;
		Word guess = new Word(letters);
		System.out.println(guess);
		
		
		Letter lettera = new Letter('H');
		Letter letterb = new Letter('E');
		Letter letterc = new Letter('N');
		Letter[] letters2 = new Letter[3];
		letters2[0] = lettera;
		letters2[1] = letterb;
		letters2[2] = letterc;
		Word mystery = new Word(letters2);
		System.out.println(mystery);
		
		System.out.println(guess.getSize());
		guess.labelWord(mystery);
		System.out.println(guess);
		System.out.println(mystery);
		System.out.println(guess.labelWord(mystery));
	}

}
