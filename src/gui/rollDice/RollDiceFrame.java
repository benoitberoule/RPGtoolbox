package gui.rollDice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import rollDice.RollDice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RollDiceFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumberOfFace;
	private JTextField txtNumberOfDice;
	protected int[] listOfDice;
	protected RollDice calculResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RollDiceFrame frame = new RollDiceFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RollDiceFrame() {
		setResizable(false);
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		setBounds(100, 100, 432, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDiceToRoll = new JLabel("Dice to roll");
		lblDiceToRoll.setBounds(12, 23, 86, 15);
		contentPane.add(lblDiceToRoll);
		
		JButton button = new JButton("4");
		button.setBounds(12, 40, 42, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("6");
		button_1.setBounds(66, 40, 42, 25);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("8");
		button_2.setBounds(120, 40, 42, 25);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("10");
		button_3.setBounds(174, 40, 50, 25);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("12");
		button_4.setBounds(236, 40, 50, 25);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("20");
		button_5.setBounds(298, 40, 50, 25);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("100");
		button_6.setBounds(360, 40, 58, 25);
		contentPane.add(button_6);
		
		JLabel lblNewLabel = new JLabel("Custom Dice");
		lblNewLabel.setBounds(12, 77, 100, 15);
		contentPane.add(lblNewLabel);
		
		txtNumberOfFace = new JTextField();
		txtNumberOfFace.setText("Number of face");
		txtNumberOfFace.setBounds(66, 104, 114, 19);
		contentPane.add(txtNumberOfFace);
		txtNumberOfFace.setColumns(10);
		
		txtNumberOfDice = new JTextField();
		txtNumberOfDice.setText("Number of Dice");
		txtNumberOfDice.setBounds(192, 104, 114, 19);
		contentPane.add(txtNumberOfDice);
		txtNumberOfDice.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(231, 135, 117, 25);
		contentPane.add(btnAdd);
		
		JButton btnRoll = new JButton("Roll");
		btnRoll.setBounds(231, 280, 117, 25);
		contentPane.add(btnRoll);
		
		JLabel lblQuickRoll = new JLabel("Quick Roll");
		lblQuickRoll.setBounds(12, 402, 86, 15);
		contentPane.add(lblQuickRoll);
		
		JButton button_7 = new JButton("4");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listOfDice = new int[1];
				listOfDice[0]=4;
				
				calculResult =  new RollDice();
				listOfDice = calculResult.roll(listOfDice);
				System.out.println(listOfDice[0]);
				
			}
		});
		button_7.setBounds(12, 429, 42, 25);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("6");
		button_8.setBounds(66, 429, 42, 25);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("8");
		button_9.setBounds(120, 429, 42, 25);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("10");
		button_10.setBounds(174, 429, 50, 25);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("12");
		button_11.setBounds(236, 429, 50, 25);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("20");
		button_12.setBounds(298, 429, 50, 25);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("100");
		button_13.setBounds(360, 429, 58, 25);
		contentPane.add(button_13);
		
		JScrollPane diceToRoll = new JScrollPane();
		diceToRoll.setBounds(12, 175, 394, 93);
		contentPane.add(diceToRoll);
		
		JScrollPane result = new JScrollPane();
		result.setToolTipText("");
		result.setBounds(12, 323, 394, 67);
		contentPane.add(result);
		
		JLabel quickResult = new JLabel("");
		quickResult.setBounds(12, 466, 150, 15);
		contentPane.add(quickResult);
	}
}
