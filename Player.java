
class Player extends Person {
	int money;
	//player starts with $500
	public Player() {
		money = 500;
	}
	//Mutator method to set the player's hand.
	public void setHand(CardTemplate[] hand){
		this.hand = hand;
	}
}
