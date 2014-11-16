import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
	CardTemplate[] deck = new CardTemplate[52];
	List<CardTemplate> shuffDeck;
	int i = 0;
	int z = 0;

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
		List<CardTemplate> deckArrayList = Arrays.asList(deck);
		Collections.shuffle(deckArrayList);
		final List<CardTemplate> shuffledDeck = deckArrayList;
		shuffDeck = shuffledDeck;
	}
	
}
