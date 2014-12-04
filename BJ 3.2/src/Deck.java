import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//Deck class created to hold a deck of cards that the player and call on during the game.
public class Deck {
	Card[] deck = new Card[52];
	List<Card> shuffDeck;
	int i = 0;
	int z = 0;
	/*Constructor method for the deck. It goes through and creates each
	card that should be located in the deck. At the end it uses the
	Collection.shuffle method to shuffle all of the cards in the deck.
	*/
	public Deck() {
		for (i = 0; i < 52; i++) {
			if (z >= 13)
				z = 0;
			if (i < 13) {
				Spades sCard = new Spades();
				sCard.makeCard(z);
				deck[i] = sCard;
				z++;
			}
			if (i >= 13 && i < 26) {
				Clubs sCard = new Clubs();
				sCard.makeCard(z);
				deck[i] = sCard;
				z++;
			}
			if (i >= 26 && i < 39) {
				Hearts sCard = new Hearts();
				sCard.makeCard(z);
				deck[i] = sCard;
				z++;
			}
			if (i >= 39 && i < 52) {
				Diamonds sCard = new Diamonds();
				sCard.makeCard(z);
				deck[i] = sCard;
				z++;
			}
		}
		List<Card> deckArrayList = Arrays.asList(deck);
		Collections.shuffle(deckArrayList);
		final List<Card> shuffledDeck = deckArrayList;
		shuffDeck = shuffledDeck;
	}
	
}
