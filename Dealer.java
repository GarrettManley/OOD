//add to github

import java.util.Observable;
import java.util.Observer;

public class BustObserver implements Observer {

	BustObserver() {
	}

	@Override
	public void update(Observable obj, Object arg) {
		Hand hand = (Hand) obj;
		if (hand.hasAce = false) {
			if (hand.getHandValue() > 21) {
				hand.isBust = true;
			}
		} else {
			if (hand.getHandValue() > 21) {
				hand.isBust = true;
				int count = 1;
				for (int i = 0; i < hand.aceIndex.size(); i++) {
					if (hand.getHandValue() - (10 * count) < 21) {
						hand.isBust = false;
						break;
					}
				}
			}
		}

	}

}
