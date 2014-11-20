import java.awt.EventQueue;

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

	 * Create the application.
	public GUI() {

	 * Initialize the contents of the frame.
	private void initialize() {
		button_Bet.addActionListener(new ActionListener() {

	// Betting and starting the game
	private class SwingAction extends AbstractAction {

	// Hitting for a new Card
	private class SwingAction_1 extends AbstractAction {

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
