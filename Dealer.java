
class Dealer extends Person {
	Deck d1 = new Deck();
	int deckPlace = 0;
	//dealer will not have to worry about money
	//Deals out two cards to each player, alternating which is being dealt the card so that they aren't given the same card.
	public void deal(Player p){
		for(int i = 0; i < 4; i++){
			if(i == 0 || i == 2)
			p.hit(dealHit());
			else
			this.hit(dealHit());
		}		
	}
	//Dealer will hit if the total is less than 17 and stand if it isn't. Also checks hand against the player's final hand.
	public void play(Player p){
		while(total < 17 && total < p.getTotal())
			hit(dealHit());
	}
	public CardTemplate dealHit(){
		CardTemplate ct = d1.shuffDeck.get(deckPlace);
		deckPlace++;
		return ct;
	}
}
