
public class Card {
	
	private String suit; // Spades, Hearts, Diamonds, or Clubs
	private String rank; // Ace, 2, 3, ..., 10, Jack, Qeen), or Kng

	public Card (String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public String getSuit () {
		return suit;
	}
	
	public String getRank () {
		return rank;
	}
	
	public void setSuit (String suit) {
		this.suit = suit;
	}
	
	public void setRank (String rank) {
		this.rank = rank;
	}
	
	public String toString () {
		return rank + " of " + suit;
	}

}
