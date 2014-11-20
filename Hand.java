import java.util.ArrayList;
import java.util.Observable;


public class Hand extends Observable {

	private ArrayList<Card> hand = new ArrayList<Card>();
	protected int personType; // 1 = Player; 2 = Dealer
	protected boolean isBust = false;
	protected boolean hasAce = false;

	protected ArrayList<Integer> aceIndex = new ArrayList<Integer>();

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
			aceIndex.add(this.hand.size());
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
