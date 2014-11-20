
class Dealer extends Person {
	
	private Deck deck = new Deck();
	private int deckPos = 0;
	
	Dealer(){
		this.personType = 2;
		this.hand.addObserver(bo);
	}
	
	public void deal(Person p){
		p.hand.addCard(deck.shuffDeck.get(this.deckPos));
		this.deckPos++;
	}
	
	//Dealer will hit if the total is less than 17 and stand if it isn't. Also checks hand against the player's final hand.
	public void play(){
		while(this.hand.getHandValue() < 17){
			this.deal(this);
		}
	}
	
}
