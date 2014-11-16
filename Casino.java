public class Casino {
	public static void main(String[] args) {
		Deck deck = new Deck();
		for (int j = 0; j < 52; j++) {
			System.out
					.println(deck.shuffDeck.get(j).getValue() + " of " + deck.shuffDeck.get(j).getSuite());
		}
		
	}
}
