
import javax.swing.JOptionPane;
//Player class represents the user and it's used mainly for betting and displaying if the player wins or loses.
class Player extends Person {
	//Variables used for betting.
	protected int money;
	protected int bet;
	protected boolean validBet = true;
	//Constructor for Player that takes an int which is their amount of money. It also adds a bustObserver to this hand.
	public Player(int m) {
		this.hand.addObserver(bo);
		this.money = m;
	}
	//Method that provides error checking for betting and removes the bet amount from the money.
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
	//Displays a message if the player loses.
	public void lose() {
		JOptionPane.showMessageDialog(null, "You Lose!");
	}
	//Displays a message if the player wins and multiplies their bet by 2 and adds it to their money.
	public void win() {
		this.money += (2 * this.bet);
		JOptionPane.showMessageDialog(null, "You Win!");
	}

}
