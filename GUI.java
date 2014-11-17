import java.awt.EventQueue;


public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.Color;


public class GUI {

	private JFrame Mainframe;
	private JTextField DealerHandvalue;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField PlayerHandValue;

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
		Mainframe.setBounds(200, 200, 900, 600);
		Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Mainframe.getContentPane().setLayout(new BorderLayout(0, 0));
		
		Panel South = new Panel();
		Mainframe.getContentPane().add(South, BorderLayout.SOUTH);
		South.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton button = new JButton("hit");
		button.setMinimumSize(new Dimension(20, 20));
		button.setMaximumSize(new Dimension(20, 20));
		button.setPreferredSize(new Dimension(100, 20));
		South.add(button);
		
		JButton button_1 = new JButton("Stand");
		South.add(button_1);
		
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
		
		JLabel lblDcard = new JLabel("DCard1");
		TOP.add(lblDcard);
		
		JLabel label = new JLabel("DCard2");
		TOP.add(label);
		
		JLabel lblDcard_1 = new JLabel("DCard3");
		TOP.add(lblDcard_1);
		
		JLabel lblDcard_2 = new JLabel("DCard4");
		TOP.add(lblDcard_2);
		
		JLabel lblDcard_3 = new JLabel("DCard5");
		TOP.add(lblDcard_3);
		
		JLabel lblDcard_4 = new JLabel("DCard6");
		TOP.add(lblDcard_4);
		
		JLabel lblDcard_5 = new JLabel("DCard7");
		TOP.add(lblDcard_5);
		
		Panel Bottom = new Panel();
		Center_Center.add(Bottom);
		
		JLabel lblCard_1 = new JLabel("Card1");
		Bottom.add(lblCard_1);
		
		JLabel lblCard_2 = new JLabel("Card2");
		Bottom.add(lblCard_2);
		
		JLabel lblCard_3 = new JLabel("Card3");
		Bottom.add(lblCard_3);
		
		JLabel lblCard_4 = new JLabel("Card4");
		Bottom.add(lblCard_4);
		
		JLabel lblCard_5 = new JLabel("Card5");
		Bottom.add(lblCard_5);
		
		JLabel lblCard_6 = new JLabel("Card6");
		Bottom.add(lblCard_6);
		
		JLabel lblCard_7 = new JLabel("Card7");
		Bottom.add(lblCard_7);
		
		Panel Center_south = new Panel();
		Center.add(Center_south, BorderLayout.SOUTH);
		
		PlayerHandValue = new JTextField();
		PlayerHandValue.setText("Hand Value");
		Center_south.add(PlayerHandValue);
		PlayerHandValue.setColumns(10);
		
		JRadioButton radioButton_2 = new JRadioButton("100");
		Center_south.add(radioButton_2);
		
		JRadioButton radioButton_1 = new JRadioButton("50");
		Center_south.add(radioButton_1);
		buttonGroup.add(radioButton_1);
		
		JRadioButton radioButton = new JRadioButton("10");
		Center_south.add(radioButton);
		radioButton.setSelected(true);
		buttonGroup.add(radioButton);
		
		JButton button_2 = new JButton("bet");
		Center_south.add(button_2);
		button_2.setVerticalAlignment(SwingConstants.BOTTOM);
		
		Panel Center_West = new Panel();
		Center.add(Center_West, BorderLayout.WEST);
		
		Panel Center_East = new Panel();
		Center.add(Center_East, BorderLayout.EAST);
		
		Panel Center_North = new Panel();
		Center.add(Center_North, BorderLayout.NORTH);
		
		DealerHandvalue = new JTextField();
		Center_North.add(DealerHandvalue);
		DealerHandvalue.setText("hand value");
		DealerHandvalue.setColumns(10);
	}

}

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
