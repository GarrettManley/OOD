import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;

import javax.swing.*;
import javax.sound.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.audio.*;

public class GUI {

	private JFrame Mainframe;
	
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();

	protected Dealer dealer = new Dealer();
	protected String dealerCards;
	protected Player player = new Player(10000);
	protected String playerCards;
	  protected JLabel DealerCard1 = new JLabel("");
	  protected JLabel DealerCard2 = new JLabel("");
	  protected	JLabel DealerCard3 = new JLabel("");
	  protected JLabel DealerCard4 = new JLabel("");
	  protected JLabel DealerCard5 = new JLabel("");
	  protected JLabel DealerCard6 = new JLabel("");
	  protected JLabel DealerCard7 = new JLabel("");
	  protected JLabel PlayerCard1 = new JLabel("");
	  protected JLabel PlayerCard2 = new JLabel("");
	  protected JLabel PlayerCard3 = new JLabel("");
	  protected JLabel PlayerCard4 = new JLabel("");
	  protected JLabel PlayerCard5 = new JLabel("");
	  protected JLabel PlayerCard6 = new JLabel("");
	  protected JLabel PlayerCard7 = new JLabel("");
	  protected JLabel DealerTemp = new JLabel("");
	  protected JLabel PlayerTemp = new JLabel("");
	protected JLabel lblDealerValue;
	protected JLabel label_Money;
	protected JTextField textField_Bet;
	protected JButton button_Bet;
	protected JButton button_Stand;
	protected JButton button_Hit;
	protected JLabel lblPlayerValue;
	protected JButton btnNewGame;
    
	
	

	
	
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
		button_Hit.setFont(new Font("SansSerif", button_Hit.getFont().getStyle(), 12));
		button_Hit.setAlignmentX(Component.RIGHT_ALIGNMENT);
		button_Hit.setAction(action_1);
		button_Hit.setMinimumSize(new Dimension(20, 20));
		button_Hit.setMaximumSize(new Dimension(20, 20));
		button_Hit.setPreferredSize(new Dimension(100, 23));
		South.add(button_Hit);

		button_Stand = new JButton("Stand");
		button_Stand.setFont(new Font("SansSerif", button_Hit.getFont().getStyle(), 12));
		button_Stand.setPreferredSize(new Dimension(100, 23));
		button_Stand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		button_Stand.setAction(action_2);
		South.add(button_Stand);
		
				btnNewGame = new JButton("NEW GAME");
				btnNewGame.setFont(new Font("SansSerif", button_Hit.getFont().getStyle(), 12));
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
		Center_Center.add(Top,BorderLayout.NORTH);
		
				JLabel lblDealerHandValueTag = new JLabel("Dealer Hand Value:");
				lblDealerHandValueTag.setFont(new Font("SansSerif", Font.PLAIN, 11));
				Top.add(lblDealerHandValueTag);
				lblDealerValue = new JLabel();
				lblDealerValue.setFont(new Font("SansSerif", Font.PLAIN, 11));
				Top.add(lblDealerValue);
				lblDealerValue.setText("0");

		Panel Bottom = new Panel();
		Center_Center.add(Bottom,BorderLayout.SOUTH);
		
				JLabel lblPlayerHandValueTag = new JLabel("Player Hand Value:");
				lblPlayerHandValueTag.setFont(new Font("SansSerif", Font.PLAIN, 11));
				Bottom.add(lblPlayerHandValueTag);
				
						lblPlayerValue = new JLabel("0");
						lblPlayerValue.setFont(new Font("SansSerif", Font.PLAIN, 11));
						Bottom.add(lblPlayerValue);
		
		Panel CardArea = new Panel();
		Center_Center.add(CardArea, BorderLayout.CENTER);
		CardArea.setLayout(new GridLayout(2, 1, 0, 0));
		
		Panel CardAreaTop = new Panel();
		CardArea.add(CardAreaTop);
		CardAreaTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		DealerTemp.setIcon(null);
		DealerTemp.setVisible(false);
		CardAreaTop.add(DealerTemp);
		

		DealerCard1.setIcon(new ImageIcon(GUI.class.getResource("/CardImages/blank.png"))); //THIS WILL NEED TO BE CHANGED!!!!!!!
		CardAreaTop.add(DealerCard1);
		
		
		DealerCard2.setIcon(new ImageIcon(GUI.class.getResource("/CardImages/blank.png"))); //THIS WILL NEED TO BE CHANGED!!!!!!!
		CardAreaTop.add(DealerCard2);
		
	;
		DealerCard3.setIcon(new ImageIcon(GUI.class.getResource("/CardImages/blank.png"))); //THIS WILL NEED TO BE CHANGED!!!!!!!
		CardAreaTop.add(DealerCard3);
		
		
		DealerCard4.setIcon(new ImageIcon(GUI.class.getResource("/CardImages/blank.png"))); //THIS WILL NEED TO BE CHANGED!!!!!!!
		CardAreaTop.add(DealerCard4);
		
		
		DealerCard5.setIcon(new ImageIcon(GUI.class.getResource("/CardImages/blank.png"))); //THIS WILL NEED TO BE CHANGED!!!!!!!
		CardAreaTop.add(DealerCard5);
		
	
		DealerCard6.setIcon(new ImageIcon(GUI.class.getResource("/CardImages/blank.png"))); //THIS WILL NEED TO BE CHANGED!!!!!!!
		CardAreaTop.add(DealerCard6);
		
		
		DealerCard7.setIcon(new ImageIcon(GUI.class.getResource("/CardImages/blank.png"))); //THIS WILL NEED TO BE CHANGED!!!!!!!
		CardAreaTop.add(DealerCard7);
		
		Panel CardAreaBottom = new Panel();
		CardArea.add(CardAreaBottom);
		CardAreaBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		PlayerTemp.setIcon(null);
		PlayerTemp.setVisible(false);
		CardAreaBottom.add(PlayerTemp);
		
		
		PlayerCard1.setIcon(new ImageIcon(GUI.class.getResource("/CardImages/blank.png"))); //THIS WILL NEED TO BE CHANGED!!!!!!!
		CardAreaBottom.add(PlayerCard1);
		
	
		PlayerCard2.setIcon(new ImageIcon(GUI.class.getResource("/CardImages/blank.png"))); //THIS WILL NEED TO BE CHANGED!!!!!!!
		CardAreaBottom.add(PlayerCard2);
		
		
		PlayerCard3.setIcon(new ImageIcon(GUI.class.getResource("/CardImages/blank.png"))); //THIS WILL NEED TO BE CHANGED!!!!!!!
		CardAreaBottom.add(PlayerCard3);
		
		
		PlayerCard4.setIcon(new ImageIcon(GUI.class.getResource("/CardImages/blank.png"))); //THIS WILL NEED TO BE CHANGED!!!!!!!
		CardAreaBottom.add(PlayerCard4);
		
		
		PlayerCard5.setIcon(new ImageIcon(GUI.class.getResource("/CardImages/blank.png"))); //THIS WILL NEED TO BE CHANGED!!!!!!!
		CardAreaBottom.add(PlayerCard5);
		
		
		PlayerCard6.setIcon(new ImageIcon(GUI.class.getResource("/CardImages/blank.png"))); //THIS WILL NEED TO BE CHANGED!!!!!!!
		CardAreaBottom.add(PlayerCard6);
		
		
		PlayerCard7.setIcon(new ImageIcon(GUI.class.getResource("/CardImages/blank.png"))); //THIS WILL NEED TO BE CHANGED!!!!!!!
		CardAreaBottom.add(PlayerCard7);

		Panel Center_south = new Panel();
		Center.add(Center_south, BorderLayout.SOUTH);
		
				// Bet Button
				button_Bet = new JButton("bet");
				button_Bet.setFont(new Font("SansSerif", button_Hit.getFont().getStyle(), 12));
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
		textField_Bet.setText("0");
		Center_south.add(textField_Bet);
		textField_Bet.setColumns(10);

		Panel Center_West = new Panel();
		Center.add(Center_West, BorderLayout.WEST);
		Panel Center_East = new Panel();
		Center.add(Center_East, BorderLayout.EAST);
		Panel Center_North = new Panel();
		Center.add(Center_North, BorderLayout.NORTH);
	}

	// Betting and starting the game
	@SuppressWarnings("serial")
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Bet");
			putValue(SHORT_DESCRIPTION, "Place a bet and start the game.  Bet must be a positive integer");
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
			dealer.deal(dealer);
			dealer.deal(player);
			dealer.deal(dealer);

			playerCards = (player.hand.getCardString(0) + ", " + player.hand
					.getCardString(1));
			//lblPlayerCards.setText(playerCards);
			dealerCards = ("Unknown, " + dealer.hand.getCardString(1));
			//lblDealerCards.setText(dealerCards);

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
			putValue(SHORT_DESCRIPTION, "Add a new card to player's hand");
		}

		public void actionPerformed(ActionEvent e) {
			dealer.deal(player);
			playerCards += (", " + player.hand.getCardString((player.hand
					.numCardsInHand() - 1)));
		//	lblPlayerCards.setText(playerCards);
			lblPlayerValue
					.setText(Integer.toString(player.hand.getHandValue()));
			if (player.hand.isBust == true) {
				// JOptionPane.showMessageDialog(null, "Player is bust");
				button_Hit.setVisible(false);
				button_Stand.setVisible(false);
				btnNewGame.setVisible(true);
				lblPlayerValue.setText((Integer.toString(player.hand.getHandValue()) + " - BUST!"));
				player.lose();
			}
		}
	}

	// player Stands
	@SuppressWarnings("serial")
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Stand");
			putValue(SHORT_DESCRIPTION, "Player is done drawing cards");
		}

		public void actionPerformed(ActionEvent e) {
			button_Hit.setVisible(false);
			button_Stand.setVisible(false);

			dealerCards = (dealer.hand.getCardString(0) + ", " + dealer.hand
					.getCardString(1));
			//lblDealerCards.setText(dealerCards);
			lblDealerValue
					.setText(Integer.toString(dealer.hand.getHandValue()));

			dealer.play();
			
			// update dealer information being displayed
			lblDealerValue
					.setText(Integer.toString(dealer.hand.getHandValue()));
			if(dealer.hand.isBust){
				lblDealerValue
				.setText(Integer.toString(dealer.hand.getHandValue()) + " - BUST!");
			}

			for (int i = 2; i < dealer.hand.numCardsInHand(); i++) {
				dealerCards += (", " + dealer.hand.getCardString(i));
			}

			//lblDealerCards.setText(dealerCards);

			if (dealer.hand.isBust != true && player.hand.isBust != true) {
				if (player.hand.getHandValue() > dealer.hand.getHandValue()) {
					player.win();
					label_Money.setText("$" + Integer.toString(player.money));
				} else {
					player.lose();
				}
			} else {
				if (dealer.hand.isBust) {
					player.win();
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
			btnNewGame.setVisible(false);
			player = new Player(player.money);
			dealer = new Dealer();
			textField_Bet.setVisible(true);
			button_Bet.setVisible(true);
			button_Hit.setVisible(false);
			button_Stand.setVisible(false);

			lblPlayerValue.setText("0");
			lblDealerValue.setText("0");
			//lblPlayerCards.setText("Player Cards");
			//lblDealerCards.setText("Dealer Cards");
			
			label_Money.setText(Integer.toString(player.money));
		}
	}
}
