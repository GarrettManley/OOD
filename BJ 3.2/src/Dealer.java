class Dealer extends Person {

	private Deck deck = new Deck(); // The dealer stores the deck that is in use
									// for the game being played
	private int deckPos = 0; // Keeps track of the position in the deck that has
								// been dealt to people

	Dealer() {
		this.hand.addObserver(bo);
	}

	// Deals a card from the current deck in use to the hand of the person being
	// passed into the
	public void deal(Person p) {
		p.hand.addCard(deck.shuffDeck.get(this.deckPos));
		this.deckPos++;
	}

	// Dealer will hit if the total is less than 17 and stand if it isn't. Also
	// checks hand against the player's final hand.
	public void play() {
		while (this.hand.getHandValue() < 17) {
			this.deal(this);
		}
	}

}
