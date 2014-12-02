//add to github

import java.util.Observable;
import java.util.Observer;

public class BustObserver implements Observer {

	BustObserver() {
	}

	// Need to call player win or dealer win and reset the GUI if either of
	// these goes bust.
	// Possibly implement a second observer within the GUI to watch for this and
	// call the new game when this happens

	@Override
	public void update(Observable obj, Object arg) {
		Hand hand = (Hand) obj;
		if (hand.getHandValue() > 21) {
			hand.isBust = true;
		}
	}

}
