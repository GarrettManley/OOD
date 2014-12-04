
import javax.swing.JOptionPane;

class Player extends Person {
	protected int money;
	protected int bet;
	protected boolean validBet = true;

	public Player(int m) {
		this.hand.addObserver(bo);
		this.money = m;
	}

	public void bet(String b) {
		try {
			this.bet = Integer.parseInt(b);
		} catch (Exception e) {
			this.validBet = false;
		}

		while (this.money == 0) {
			JOptionPane
					.showMessageDialog(null,
							"Cannot bet, Out of money!\nRestart Program to play again!");
		}

		if (this.bet > this.money || this.bet <= 0) {
			this.validBet = false;
		}

		while (!this.validBet) {
			try {
				this.bet = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Please enter a positive integer bet amount that is less than $"
								+ this.money, "Invalid Bet", 0));
				if (this.bet > this.money || this.bet <= 0) {
					this.validBet = false;
				} else {
					this.validBet = true;
				}
			} catch (Exception e) {
				this.validBet = false;
			}
		}

		this.validBet = true;
		this.money -= this.bet;
	}

	public void lose() {
		JOptionPane.showMessageDialog(null, "You Lose!");
	}

	public void win() {
		this.money += (2 * this.bet);
		JOptionPane.showMessageDialog(null, "You Win!");
	}

}
