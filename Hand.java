import java.util.ArrayList;
import java.util.Observable;


public class Hand extends Observable {

	private ArrayList<Card> hand = new ArrayList<Card>();
	protected int personType; // 1 = Player; 2 = Dealer
	protected boolean isBust = false;
	protected boolean hasAce = false;

	protected int aceIndex = 0;

	public Hand(int pt) {
		this.personType = pt;
	}

	// Not sure if this implementation will be used
	public Hand(int pt, ArrayList<Card> h) {
		this.personType = pt;
		this.hand = h;
	}

	// returns the ArrayList of cards in a Hand
	// public Hand getHand(){
	// return this.h;
	// }

	// Adds a new card to the hand the notifies the BustObserver which checks
	// to see if the new card makes the person go bust
	public void addCard(Card c) {
		this.hand.add(c);
		if (c.getValue() == "Ace") {
			aceIndex++;
			this.hasAce = true;
		}
		setChanged();
		notifyObservers();
	}

	// Empties the hand of a player
	public void clearHand() {
		this.hand.clear();
	}

	// returns an integer value associated to the cards in the hand
	public int getHandValue() {
		int value = 0;
		for (int i = 0; i < this.hand.size(); i++) {
			value += this.hand.get(i).getNumValue();
		}
		if(value > 21 && hasAce) {
			for(int i = 0; i < aceIndex; i++) {
				value = value - 10;
				if(value <= 21)
					break;
			}
			
		}
		return value;
	}

	public void getAceValue() {

	}
	
	public String getCardString(int i){
		return (hand.get(i).getValue() + " " + hand.get(i).getSuite()); 
	}

	public int numCardsInHand(){
		return hand.size();
	}
	
	public Card getCard(int i){
		return this.hand.get(i);
	}
}
