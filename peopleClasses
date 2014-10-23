/*
 * just a basic framework for how the classes should work,
 * not finished yet obviously. Just thought I'd try and
 * upload it to figure out how github works.
*/

class Person {
	Card[] hand = new Card[12]; //size 12 because 11 is the most you could have without busting
	int cards = 0;
	
	public void hit() {
		hand[cards] = deck.drawCard();
		cards++;
	}
	
}

class Player extends Person {
	int money;
	//player starts with $500
	public Player() {
		money = 500;
	}
}

class Dealer extends Person {
	//dealer will not have to worry about money
}

//card and deck classes just for place holders
class Card {
	
}

class deck {
	public static Card drawCard() {
		return new Card();
	}
}
