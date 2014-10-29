/*
 * just a basic framework for how the classes should work,
 * not finished yet obviously. Just thought I'd try and
 * upload it to figure out how github works.
*/

class Person {
	Card[] hand = new Card[12]; //size 12 because 11 is the most you could have without busting
	int cards = 0;
	int total = 0; //Used to hold the total value of the cards drawn so far.
	
	public void hit() {
		hand[cards] = deck.drawCard();
		total =+ hand[cards].getValue();
		cards++;
	}
	//Place holder for the stand method.
	public void stand(){
		
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
	//Decides whether the dealer will hit or stand, depending on the value of the cards.
	public void play(){
		if(total < 17)
			hit();
		else
			stand();
	}
}

//card and deck classes just for place holders
class Card {
	int value;
	
	public int getValue(){
		return value;
	}	
}

class deck {
	public static Card drawCard() {
		return new Card();
	}
}
