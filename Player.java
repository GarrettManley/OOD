import javax.swing.JOptionPane;

class Player extends Person {
	protected int money;
	protected int bet;

	public Player(int m) {
		this.hand.addObserver(bo);
		this.money = m;
		this.personType = 1;
	}

	public void bet(int b) {
		this.bet = b;
		while (this.bet > this.money) {
			this.bet = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Please enter a bet amount less than $" + this.money,
					"Invalid Bet", 0));
		}
		this.money -= this.bet;
	}

	public void lose() {
		JOptionPane.showMessageDialog(null,"You Lose!");
	}

	public void win() {
		this.money += (2*this.bet);
		JOptionPane.showMessageDialog(null, "You Win!");
	}

}
