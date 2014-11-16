

class Person {
	int aces = 0; //for keeping track of aces
	CardTemplate[] hand = new CardTemplate[14];
	int place = 0; //the latest free space in the hand
	int total = 0; //Used to hold the total value of the cards drawn so far.
	//Puts a card in the person's hand.
	public void hit(CardTemplate c) {
		hand[place] = c;
		place++;
		total += c.getNumValue();
		
		//for handling ace double-value
		if(c.getNumValue() == 11)
			aces++;
		if(total > 21 && aces > 0) {
			total = total - 10;
			aces--;
		}
	}
	//Place holder for the stand method.
	public void stand(){
		
	}
	//Prints out the player or dealers hand.
	public void printHand(){
		for(int i = 0; i < place; i++){
			System.out.print(hand[i].getValue() + hand[i].getSuite() + " ");
		}
		System.out.print("\n");
	}
	//Returns the total of the person's hand.
	public int getTotal(){
		return total;
	}
	
	public CardTemplate[] getHand(){
		return hand;
	}
	
}



