import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class GUI {

	private JFrame Mainframe;

	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();

	protected Dealer dealer = new Dealer();
	protected Player player = new Player(10000);

	protected JLabel lblDealerValue;
	protected JLabel label_Money;
	protected JTextField textField_Bet;
	protected JButton button_Bet;
	protected JButton button_Stand;
	protected JButton button_Hit;
	protected JLabel lblPlayerValue;
	protected JButton btnNewGame;

	protected JLabel DealerCard1 = new JLabel("");
	protected JLabel DealerCard2 = new JLabel("");
	protected JLabel DealerCard3 = new JLabel("");
	protected JLabel DealerCard4 = new JLabel("");
	protected JLabel DealerCard5 = new JLabel("");
	protected JLabel DealerCard6 = new JLabel("");
	protected JLabel DealerCard7 = new JLabel("");
	protected JLabel DealerCard8 = new JLabel("");
	protected JLabel DealerCard9 = new JLabel("");
	protected JLabel DealerCard10 = new JLabel("");
	protected JLabel DealerCard11 = new JLabel("");
	protected JLabel PlayerCard1 = new JLabel("");
	protected JLabel PlayerCard2 = new JLabel("");
	protected JLabel PlayerCard3 = new JLabel("");
	protected JLabel PlayerCard4 = new JLabel("");
	protected JLabel PlayerCard5 = new JLabel("");
	protected JLabel PlayerCard6 = new JLabel("");
	protected JLabel PlayerCard7 = new JLabel("");
	protected JLabel PlayerCard8 = new JLabel("");
	protected JLabel PlayerCard9 = new JLabel("");
	protected JLabel PlayerCard10 = new JLabel("");
	protected JLabel PlayerCard11 = new JLabel("");
	protected JLabel PlayerTemp = new JLabel("");

	JLabel[] PCards = new JLabel[11];

	JLabel[] DCards = new JLabel[11];
	private final JLayeredPane layeredPane = new JLayeredPane();
	private final JLabel label = new JLabel("");
	private final JLayeredPane layeredPane_1 = new JLayeredPane();

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
		Mainframe.getContentPane().setBackground(new Color(50, 205, 50));
		Mainframe.setBackground(new Color(0, 128, 0));
		Mainframe.setBounds(200, 75, 720, 450);
		Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Mainframe.getContentPane().setLayout(new BorderLayout(0, 0));

		Panel South = new Panel();
		Mainframe.getContentPane().add(South, BorderLayout.SOUTH);
		South.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		button_Hit = new JButton("hit");
		button_Hit.setVisible(false);
		button_Hit.setFont(new Font("SansSerif", button_Hit.getFont()
				.getStyle(), 12));
		button_Hit.setAlignmentX(Component.RIGHT_ALIGNMENT);
		button_Hit.setAction(action_1);
		button_Hit.setMinimumSize(new Dimension(20, 20));
		button_Hit.setMaximumSize(new Dimension(20, 20));
		button_Hit.setPreferredSize(new Dimension(100, 23));
		South.add(button_Hit);

		button_Stand = new JButton("Stand");
		button_Stand.setFont(new Font("SansSerif", button_Hit.getFont()
				.getStyle(), 12));
		button_Stand.setPreferredSize(new Dimension(100, 23));
		button_Stand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		button_Stand.setAction(action_2);
		South.add(button_Stand);

		btnNewGame = new JButton("NEW GAME");
		btnNewGame.setFont(new Font("SansSerif", button_Hit.getFont()
				.getStyle(), 12));
		South.add(btnNewGame);
		btnNewGame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnNewGame.setPreferredSize(new Dimension(100, 23));
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewGame.setAction(action_3);
		btnNewGame.setVisible(false);
		button_Stand.setVisible(false);

		Panel West = new Panel();
		Mainframe.getContentPane().add(West, BorderLayout.WEST);
		West.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Panel East = new Panel();
		Mainframe.getContentPane().add(East, BorderLayout.EAST);
		East.setLayout(new BorderLayout(0, 0));

		Panel North = new Panel();
		Mainframe.getContentPane().add(North, BorderLayout.NORTH);

		JLabel lblPlayerMoney = new JLabel("Player Money:");
		lblPlayerMoney.setFont(new Font("SansSerif", Font.BOLD, 13));
		North.add(lblPlayerMoney);

		label_Money = new JLabel("$$$");
		label_Money.setFont(new Font("SansSerif", Font.BOLD, 13));
		North.add(label_Money);
		label_Money.setText("$" + Integer.toString(player.money));

		Panel Center = new Panel();
		Mainframe.getContentPane().add(Center, BorderLayout.CENTER);
		Center.setLayout(new BorderLayout(0, 0));
		Panel Center_Center = new Panel();
		Center.add(Center_Center, BorderLayout.CENTER);
		Center_Center.setLayout(new BorderLayout(0, 0));

		Panel Top = new Panel();
		Center_Center.add(Top, BorderLayout.NORTH);

		JLabel lblDealerHandValueTag = new JLabel("Dealer Hand Value: ");
		lblDealerHandValueTag.setHorizontalAlignment(SwingConstants.LEFT);
		lblDealerHandValueTag.setBackground(new Color(255, 255, 0));
		lblDealerHandValueTag.setFont(new Font("SansSerif", Font.PLAIN, 11));
		Top.add(lblDealerHandValueTag);
		lblDealerValue = new JLabel();
		lblDealerValue.setBackground(new Color(255, 255, 0));
		lblDealerValue.setFont(new Font("SansSerif", Font.PLAIN, 11));
		Top.add(lblDealerValue);
		lblDealerValue.setText("0");

		Panel Bottom = new Panel();
		Center_Center.add(Bottom, BorderLayout.SOUTH);

		JLabel lblPlayerHandValueTag = new JLabel("Player Hand Value:");
		lblPlayerHandValueTag.setFont(new Font("SansSerif", Font.PLAIN, 11));
		Bottom.add(lblPlayerHandValueTag);

		lblPlayerValue = new JLabel("0");
		lblPlayerValue.setFont(new Font("SansSerif", Font.PLAIN, 11));
		Bottom.add(lblPlayerValue);

		Panel CardArea = new Panel();
		Center_Center.add(CardArea, BorderLayout.CENTER);
		CardArea.setLayout(new GridLayout(2, 1, 0, 0));

		CardArea.add(layeredPane_1);
		layeredPane_1.setLayout(null);

		DCards[10] = DealerCard11;
		DealerCard11.setVisible(false);
		DealerCard11.setBounds(new Rectangle(0, 0, 72, 96));
		DealerCard11.setSize(new Dimension(72, 96));
		DealerCard11.setBounds(539, 22, 72, 96);
		layeredPane_1.add(DealerCard11);
		DealerCard11.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));

		DCards[9] = DealerCard10;
		DealerCard10.setVisible(false);
		DealerCard10.setBounds(new Rectangle(0, 0, 72, 96));
		DealerCard10.setSize(new Dimension(72, 96));
		DealerCard10.setBounds(507, 22, 72, 96);
		layeredPane_1.add(DealerCard10);
		DealerCard10.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));

		DCards[8] = DealerCard9;
		DealerCard9.setVisible(false);
		DealerCard9.setBounds(469, 22, 72, 96);
		layeredPane_1.add(DealerCard9);
		DealerCard9.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));

		DCards[7] = DealerCard8;
		DealerCard8.setVisible(false);
		DealerCard8.setBounds(new Rectangle(0, 0, 72, 96));
		DealerCard8.setSize(new Dimension(72, 96));
		DealerCard8.setBounds(437, 22, 72, 96);
		layeredPane_1.add(DealerCard8);
		DealerCard8.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));

		DCards[6] = DealerCard7;
		DealerCard7.setVisible(false);
		DealerCard7.setBounds(new Rectangle(0, 0, 72, 96));
		DealerCard7.setSize(new Dimension(72, 96));
		DealerCard7.setBounds(405, 22, 72, 96);
		layeredPane_1.add(DealerCard7);
		DealerCard7.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));

		DCards[5] = DealerCard6;
		DealerCard6.setVisible(false);
		DealerCard6.setBounds(new Rectangle(0, 0, 72, 96));
		DealerCard6.setSize(new Dimension(72, 96));
		DealerCard6.setBounds(371, 22, 72, 96);
		layeredPane_1.add(DealerCard6);
		DealerCard6.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));

		DCards[4] = DealerCard5;
		DealerCard5.setVisible(false);
		DealerCard5.setBounds(new Rectangle(0, 0, 72, 96));
		DealerCard5.setSize(new Dimension(72, 96));
		DealerCard5.setBounds(337, 22, 72, 96);
		layeredPane_1.add(DealerCard5);
		DealerCard5.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));

		DCards[3] = DealerCard4;
		DealerCard4.setVisible(false);
		DealerCard4.setBounds(new Rectangle(0, 0, 72, 96));
		DealerCard4.setSize(new Dimension(72, 96));
		DealerCard4.setBounds(307, 22, 72, 96);
		layeredPane_1.add(DealerCard4);
		DealerCard4.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));

		DCards[2] = DealerCard3;
		DealerCard3.setVisible(false);
		DealerCard3.setBounds(new Rectangle(0, 0, 72, 96));
		DealerCard3.setSize(new Dimension(72, 96));
		DealerCard3.setBounds(269, 22, 72, 96);
		layeredPane_1.add(DealerCard3);
		DealerCard3.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));

		DCards[1] = DealerCard2;
		DealerCard2.setBounds(new Rectangle(0, 0, 72, 96));
		DealerCard2.setSize(new Dimension(72, 96));
		DealerCard2.setBounds(237, 22, 72, 96);
		layeredPane_1.add(DealerCard2);
		DealerCard2.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));

		DCards[0] = DealerCard1;
		DealerCard1.setBounds(new Rectangle(0, 0, 72, 96));
		DealerCard1.setSize(new Dimension(72, 96));
		DealerCard1.setBounds(202, 22, 72, 96);
		layeredPane_1.add(DealerCard1);
		DealerCard1.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));

		CardArea.add(layeredPane);
		layeredPane.setLayout(null);
		PlayerTemp.setBounds(0, 64, 0, 0);
		layeredPane.add(PlayerTemp);

		PlayerTemp.setIcon(null);

		PCards[10] = PlayerCard11;
		PlayerCard11.setVisible(false);
		PlayerCard11.setLocation(541, 2);
		PlayerCard11.setSize(new Dimension(72, 96));
		layeredPane.add(PlayerCard11);
		PlayerCard11.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/5Spade.png")));

		PCards[9] = PlayerCard10;
		PlayerCard10.setVisible(false);
		PlayerCard10.setLocation(508, 2);
		PlayerCard10.setSize(new Dimension(72, 96));
		layeredPane.add(PlayerCard10);
		PlayerCard10.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/3Spade.png")));

		PCards[8] = PlayerCard9;
		PlayerCard9.setVisible(false);
		PlayerCard9.setLocation(471, 2);
		PlayerCard9.setSize(new Dimension(72, 96));
		layeredPane.add(PlayerCard9);
		PlayerCard9.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/2Heart.png")));

		PCards[7] = PlayerCard8;
		PlayerCard8.setVisible(false);
		PlayerCard8.setLocation(437, 2);
		PlayerCard8.setSize(new Dimension(72, 96));
		layeredPane.add(PlayerCard8);
		PlayerCard8.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/QueenDiamond.png")));

		PCards[6] = PlayerCard7;
		PlayerCard7.setVisible(false);
		PlayerCard7.setLocation(403, 2);
		PlayerCard7.setSize(new Dimension(72, 96));
		layeredPane.add(PlayerCard7);
		PlayerCard7.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/JackClub.png")));

		PCards[5] = PlayerCard6;
		PlayerCard6.setVisible(false);
		PlayerCard6.setLocation(372, 2);
		PlayerCard6.setSize(new Dimension(72, 96));
		layeredPane.add(PlayerCard6);
		PlayerCard6.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/6Diamond.png")));

		PCards[4] = PlayerCard5;
		PlayerCard5.setVisible(false);
		PlayerCard5.setLocation(338, 2);
		PlayerCard5.setSize(new Dimension(72, 96));
		layeredPane.add(PlayerCard5);
		PlayerCard5.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/10Club.png")));

		PCards[3] = PlayerCard4;
		PlayerCard4.setVisible(false);
		PlayerCard4.setLocation(307, 2);
		PlayerCard4.setSize(new Dimension(72, 96));
		layeredPane.add(PlayerCard4);
		PlayerCard4.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/7Heart.png")));
		layeredPane.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { PlayerTemp, PlayerCard11, PlayerCard10,
						PlayerCard9, PlayerCard8, PlayerCard6, PlayerCard7,
						PlayerCard5, PlayerCard4, PlayerCard3, PlayerCard2,
						PlayerCard1, label }));

		PCards[2] = PlayerCard3;
		PlayerCard3.setVisible(false);
		PlayerCard3.setLocation(271, 2);
		PlayerCard3.setSize(new Dimension(72, 96));
		layeredPane.add(PlayerCard3);
		PlayerCard3.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/6Heart.png")));

		PCards[1] = PlayerCard2;
		PlayerCard2.setLocation(238, 2);
		PlayerCard2.setBorder(null);
		PlayerCard2.setSize(new Dimension(72, 96));
		layeredPane.add(PlayerCard2);
		PlayerCard2.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));

		PCards[0] = PlayerCard1;
		PlayerCard1.setLocation(202, 2);
		PlayerCard1.setBorder(null);
		PlayerCard1.setSize(new Dimension(72, 96));
		layeredPane.add(PlayerCard1);
		PlayerCard1.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));
		label.setSize(new Dimension(72, 96));
		label.setBounds(602, 20, 72, 96);
		label.setSize(new Dimension(72, 96));
		label.setBounds(602, 20, 72, 96);

		layeredPane.add(label);
		PlayerTemp.setVisible(false);

		Panel Center_south = new Panel();
		Center.add(Center_south, BorderLayout.SOUTH);

		// Bet Button
		button_Bet = new JButton("bet");
		button_Bet.setFont(new Font("SansSerif", button_Hit.getFont()
				.getStyle(), 12));
		button_Bet.setPreferredSize(new Dimension(100, 23));
		button_Bet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_Bet.setAction(action);
		Center_south.add(button_Bet);
		button_Bet.setVerticalAlignment(SwingConstants.BOTTOM);

		textField_Bet = new JTextField();
		textField_Bet.setFont(new Font("SansSerif", Font.PLAIN, 11));
		textField_Bet.setText("100");
		Center_south.add(textField_Bet);
		textField_Bet.setColumns(10);

		Panel Center_West = new Panel();
		Center.add(Center_West, BorderLayout.WEST);
		Panel Center_East = new Panel();
		Center.add(Center_East, BorderLayout.EAST);
		Panel Center_North = new Panel();
		Center.add(Center_North, BorderLayout.NORTH);
	}

	public void end() {
		DealerCard1.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));
		DealerCard2.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));
		DealerCard3.setVisible(false);
		DealerCard4.setVisible(false);
		DealerCard5.setVisible(false);
		DealerCard6.setVisible(false);
		DealerCard7.setVisible(false);
		DealerCard8.setVisible(false);
		DealerCard9.setVisible(false);
		DealerCard10.setVisible(false);
		DealerCard11.setVisible(false);

		PlayerCard1.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));
		PlayerCard2.setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/Hidden.png")));

		PlayerCard3.setVisible(false);
		PlayerCard4.setVisible(false);
		PlayerCard5.setVisible(false);
		PlayerCard6.setVisible(false);
		PlayerCard7.setVisible(false);
		PlayerCard8.setVisible(false);
		PlayerCard9.setVisible(false);
		PlayerCard10.setVisible(false);
		PlayerCard11.setVisible(false);

		lblPlayerValue.setText("0");
		lblDealerValue.setText("0");
	}

	public void showDealerCard(int i){
		DCards[i].setIcon(new ImageIcon(GUI.class
				.getResource("/CardImages/"
						+ dealer.hand.getCardString(i) + ".png")));
		DCards[i].setVisible(true);
	}
	
	// Betting and starting the game
	@SuppressWarnings("serial")
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Bet");
			putValue(SHORT_DESCRIPTION,
					"Place a bet and start the game.  Bet must be a positive integer");
		}

		public void actionPerformed(ActionEvent e) {
			// Enter the user's bet

			player.bet(textField_Bet.getText());

			label_Money.setText("$" + Integer.toString(player.money));
			textField_Bet.setVisible(false);
			button_Bet.setVisible(false);
			button_Hit.setVisible(true);
			button_Stand.setVisible(true);

			// Initialize the game by dealing initial cards
			dealer.deal(player);
			PCards[player.hand.numCardsInHand() - 1].setIcon(new ImageIcon(
					GUI.class.getResource("/CardImages/"
							+ player.hand.getCardString(player.hand
									.numCardsInHand() - 1) + ".png")));
			dealer.deal(dealer);

			dealer.deal(player);
			PCards[player.hand.numCardsInHand() - 1].setIcon(new ImageIcon(
					GUI.class.getResource("/CardImages/"
							+ player.hand.getCardString(player.hand
									.numCardsInHand() - 1) + ".png")));
			dealer.deal(dealer);

			// look at card suite and value, then assign the appropriate image
			// to the appropriate area
			DCards[dealer.hand.numCardsInHand() - 1].setIcon(new ImageIcon(
					GUI.class.getResource("/CardImages/"
							+ dealer.hand.getCardString(dealer.hand
									.numCardsInHand() - 1) + ".png")));
			PCards[player.hand.numCardsInHand() - 1].setIcon(new ImageIcon(
					GUI.class.getResource("/CardImages/"
							+ player.hand.getCardString(player.hand
									.numCardsInHand() - 1) + ".png")));

			lblPlayerValue
					.setText(Integer.toString(player.hand.getHandValue()));
			
			lblDealerValue.setText(Integer.toString(dealer.hand.getHandValue()
					- dealer.hand.getCard(0).getNumValue()));

			DCards[dealer.hand.numCardsInHand() - 1].setIcon(new ImageIcon(
					GUI.class.getResource("/CardImages/"
							+ dealer.hand.getCardString(dealer.hand
									.numCardsInHand() - 1) + ".png")));

			if (player.hand.getHandValue() == 21) {
				player.win();
				end();
				newGame();
			}
		}
	}

	public void newGame() {
		btnNewGame.setVisible(false);
		player = new Player(player.money);
		dealer = new Dealer();
		textField_Bet.setVisible(true);
		button_Bet.setVisible(true);
		button_Hit.setVisible(false);
		button_Stand.setVisible(false);
		lblPlayerValue.setText("0");
		lblDealerValue.setText("0");
		label_Money.setText(Integer.toString(player.money));
	}

	// Hitting for a new Card
	@SuppressWarnings("serial")
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {

			putValue(NAME, "Hit");
			putValue(SHORT_DESCRIPTION, "Add a new card to player's hand");
		}

		public void actionPerformed(ActionEvent e) {
			dealer.deal(player);
			PCards[player.hand.numCardsInHand() - 1].setIcon(new ImageIcon(
					GUI.class.getResource("/CardImages/"
							+ player.hand.getCardString(player.hand
									.numCardsInHand() - 1) + ".png")));
			PCards[player.hand.numCardsInHand() - 1].setVisible(true);

			lblPlayerValue
					.setText(Integer.toString(player.hand.getHandValue()));
			if (player.hand.isBust == true) {
				// show the hidden card and update the shown value of the
				// dealers hand.
				lblDealerValue.setText(Integer.toString(dealer.hand
						.getHandValue()));
				DCards[0].setIcon(new ImageIcon(GUI.class
						.getResource("/CardImages/"
								+ dealer.hand.getCardString(0) + ".png")));

				button_Hit.setVisible(false);
				button_Stand.setVisible(false);
				btnNewGame.setVisible(true);
				lblPlayerValue.setText((Integer.toString(player.hand
						.getHandValue()) + " - BUST!"));

				player.lose();

				// reseting board after game
				end();

			}
		}
	}

	// player Stands, go to dealer turn
	@SuppressWarnings("serial")
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Stand");
			putValue(SHORT_DESCRIPTION, "Player is done drawing cards");
		}

		public void actionPerformed(ActionEvent e) {
			button_Hit.setVisible(false);
			button_Stand.setVisible(false);

			lblDealerValue
					.setText(Integer.toString(dealer.hand.getHandValue()));

			dealer.play();
			
			//shows the cards added to the dealer's hand through dealer.play()
			for (int i = 0; i < dealer.hand.numCardsInHand(); i++) {
				showDealerCard(i);
			}

			// update dealer information being displayed
			lblDealerValue
					.setText(Integer.toString(dealer.hand.getHandValue()));
			if (dealer.hand.isBust) {
				lblDealerValue.setText(Integer.toString(dealer.hand
						.getHandValue()) + " - BUST!");
			}

			if (dealer.hand.isBust != true && player.hand.isBust != true) {
				if (player.hand.getHandValue() > dealer.hand.getHandValue()) {
					// show the hidden card and update the shown value of the
					// dealers hand.
					lblDealerValue.setText(Integer.toString(dealer.hand
							.getHandValue()));

					player.win();

					end();

					label_Money.setText("$" + Integer.toString(player.money));
				} else {

					lblDealerValue.setText(Integer.toString(dealer.hand
							.getHandValue()));

					player.lose();

					end();
				}
			} else {
				if (dealer.hand.isBust) {

					// show the hidden card and update the shown value of the
					// dealers hand.

					lblDealerValue.setText(Integer.toString(dealer.hand
							.getHandValue()) + " - BUST!");

					player.win();

					end();

					label_Money.setText("$" + Integer.toString(player.money));
				}
			}
			btnNewGame.setVisible(true);
		}
	}

	// new Game
	@SuppressWarnings("serial")
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "New Game");
			putValue(SHORT_DESCRIPTION, "Start a new game");
		}

		public void actionPerformed(ActionEvent e) {
			newGame();
		}
	}
}
