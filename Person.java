

class Person {
	
	int personType=0;
	Hand hand = new Hand(personType);
	BustObserver bo = new BustObserver();	
	
	//Not used...  Hit analysis done by BustObserver
/*	public void hit(Card c) {
		Player p = (Player) this;
		hand.addCard(c);
		if(hand.isBust){
			if(personType == 1){
				p.lose();
			}
			else {
				p.win();
			}
		}
	}*/
	//Place holder for the stand method.
	public void stand(){
		//When all players stand, the game is then over and the victory is then assessed
	}
	
//	public Hand getHand(){
//		return this.hand.getHand();
//	}
	
}



