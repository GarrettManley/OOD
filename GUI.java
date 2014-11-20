import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.JButton;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.FlowLayout;

import javax.swing.JTextField;

import java.awt.Dimension;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class GUI {

	private JFrame Mainframe;

	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();

	protected Dealer dealer = new Dealer();
	protected String dealerCards;
	protected Player player = new Player(10000);
	protected String playerCards;

	protected JLabel lblDealerValue;
	protected JLabel label_Money;
	protected JTextField textField_Bet;
	protected JButton button_Bet;
	protected JButton button_Stand;
	protected JButton button_Hit;
	protected JLabel lblPlayerCards;
	protected JLabel lblDealerCards;
	protected JLabel lblPlayerValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.Mainframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Mainframe = new JFrame();
		Mainframe.setBackground(new Color(0, 128, 0));
		Mainframe.setBounds(200, 75, 900, 600);
		Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Mainframe.getContentPane().setLayout(new BorderLayout(0, 0));

		Panel South = new Panel();
		Mainframe.getContentPane().add(South, BorderLayout.SOUTH);
		South.setLayout(new GridLayout(1, 3, 0, 0));

		button_Hit = new JButton("hit");
		button_Hit.setVisible(false);
		button_Hit.setAction(action_1);
		button_Hit.setMinimumSize(new Dimension(20, 20));
		button_Hit.setMaximumSize(new Dimension(20, 20));
		button_Hit.setPreferredSize(new Dimension(100, 20));
		South.add(button_Hit);

		button_Stand = new JButton("Stand");
		button_Stand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_Stand.setAction(action_2);
		South.add(button_Stand);
		button_Stand.setVisible(false);

		Panel West = new Panel();
		Mainframe.getContentPane().add(West, BorderLayout.WEST);
		West.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Panel East = new Panel();
		Mainframe.getContentPane().add(East, BorderLayout.EAST);
		East.setLayout(new BorderLayout(0, 0));

		Panel North = new Panel();
		Mainframe.getContentPane().add(North, BorderLayout.NORTH);

		Panel Center = new Panel();
		Mainframe.getContentPane().add(Center, BorderLayout.CENTER);
		Center.setLayout(new BorderLayout(0, 0));
		Panel Center_Center = new Panel();
		Center.add(Center_Center, BorderLayout.CENTER);
		Center_Center.setLayout(new GridLayout(2, 1, 0, 0));

		Panel TOP = new Panel();
		Center_Center.add(TOP);
		lblDealerCards = new JLabel("DCard1");
		TOP.add(lblDealerCards);

		Panel Bottom = new Panel();
		Center_Center.add(Bottom);
		lblPlayerCards = new JLabel("Card1");
		Bottom.add(lblPlayerCards);

		Panel Center_south = new Panel();
		Center.add(Center_south, BorderLayout.SOUTH);

		// Bet Button
		button_Bet = new JButton("bet");
		button_Bet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JLabel lblPlayerHandValueTag = new JLabel("Player Hand Value:");
		Center_south.add(lblPlayerHandValueTag);

		lblPlayerValue = new JLabel("0");
		Center_south.add(lblPlayerValue);

		textField_Bet = new JTextField();
		textField_Bet.setText("0");
		Center_south.add(textField_Bet);
		textField_Bet.setColumns(10);
		button_Bet.setAction(action);
		Center_south.add(button_Bet);
		button_Bet.setVerticalAlignment(SwingConstants.BOTTOM);

		JLabel lblPlayerMoney = new JLabel("Player Money:");
		Center_south.add(lblPlayerMoney);

		label_Money = new JLabel("$$$");
		Center_south.add(label_Money);
		label_Money.setText("$" + Integer.toString(player.money));

		Panel Center_West = new Panel();
		Center.add(Center_West, BorderLayout.WEST);
		Panel Center_East = new Panel();
		Center.add(Center_East, BorderLayout.EAST);
		Panel Center_North = new Panel();
		Center.add(Center_North, BorderLayout.NORTH);

		JLabel lblDealerHandValueTag = new JLabel("Dealer Hand Value:");
		Center_North.add(lblDealerHandValueTag);
		lblDealerValue = new JLabel();
		Center_North.add(lblDealerValue);
		lblDealerValue.setText("0");
	}

	// Betting and starting the game
	@SuppressWarnings("serial")
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Bet");
			putValue(SHORT_DESCRIPTION, "Contols the start of the game");
		}

		public void actionPerformed(ActionEvent e) {
			// Enter the user's bet
			try {
				player.bet(Integer.parseInt(textField_Bet.getText()));
				label_Money.setText("$" + Integer.toString(player.money));
				textField_Bet.setVisible(false);
				button_Bet.setVisible(false);
				button_Hit.setVisible(true);
				button_Stand.setVisible(true);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,
						"Please enter an integer value!");
			}

			// Initialize the game by dealing initial cards
			dealer.deal(player);
			dealer.deal(dealer);
			dealer.deal(player);
			dealer.deal(dealer);

			playerCards = (player.hand.getCardString(0) + ", " + player.hand
					.getCardString(1));
			lblPlayerCards.setText(playerCards);
			dealerCards = ("Unknown, " + dealer.hand.getCardString(1));
			lblDealerCards.setText(dealerCards);

			lblPlayerValue
					.setText(Integer.toString(player.hand.getHandValue()));
			lblDealerValue.setText(Integer.toString(dealer.hand.getHandValue()
					- dealer.hand.getCard(0).getNumValue()));
		}
	}

	// Hitting for a new Card
	@SuppressWarnings("serial")
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Hit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			dealer.deal(player);
			playerCards += (", " + player.hand.getCardString((player.hand
					.numCardsInHand() - 1)));
			lblPlayerCards.setText(playerCards);
			lblPlayerValue
					.setText(Integer.toString(player.hand.getHandValue()));
			if (player.hand.isBust == true) {
				JOptionPane.showMessageDialog(null, "Player is bust");
				button_Hit.setVisible(false);
				button_Stand.setVisible(false);
			}
		}
	}

	// player Stands
	@SuppressWarnings("serial")
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Stand");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			button_Hit.setVisible(false);
			button_Stand.setVisible(false);

			dealerCards = (dealer.hand.getCardString(0) + ", " + dealer.hand
					.getCardString(1));
			lblDealerCards.setText(dealerCards);
			lblDealerValue
					.setText(Integer.toString(dealer.hand.getHandValue()));
			
			dealer.play();
		}
	}
}
