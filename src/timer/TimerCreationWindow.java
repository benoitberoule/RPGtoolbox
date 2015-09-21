/*This class is used to select the time the timer will reach or start on*/

package timer;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class TimerCreationWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*Attributes*/
	private JPanel panel = new JPanel();
	private JTextField selectionSecondes = new JTextField();
	private JTextField selectionMinutes = new JTextField();
	private JTextField selectionHeures = new JTextField();
	private JButton boutonStart = new JButton("start");
	ArrayList <Timer> tableauTimer = new ArrayList<Timer>();
	
	/* timer:count down selection*/
	ButtonGroup selectionGroup;
	JRadioButton timerRadioButton;
	JRadioButton countdownRadioButton;
	
	/*Methods*/
	public TimerCreationWindow()
	{
		build();
	}
	
	public void build()
	{
		this.setTitle("Cr�ation chronometre");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		//setExtendedState(MAXIMIZED_BOTH);
		setSize(700,500);
		setContentPane(buildContentPanel());
		Dimension d = new Dimension (500,150);
		this.setSize(d);

			boutonStart.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					pressStart();
				}
				
			});
			
		
			
				
			
		panel.setFocusable(true);
		panel.requestFocus();
			
	}
	
	
	public void pressStart() 
	{
		try {
			if(!(Integer.parseInt((selectionSecondes.getText()))>0))
			{
				selectionSecondes.setText("0");
			}
		} catch (NumberFormatException e) {
			selectionSecondes.setText("0");
		}

		try {
			if(!(Integer.parseInt((selectionMinutes.getText()))>0))
			{
				selectionMinutes.setText("0");
			}
		} catch (NumberFormatException e) {
			selectionMinutes.setText("0");
		}
		
		try {
			if(!(Integer.parseInt((selectionHeures.getText()))>0))
			{
				selectionHeures.setText("0");
			}
		} catch (NumberFormatException e) {
			selectionHeures.setText("0");
		}
		
		
	tableauTimer.add(new Timer(new TimerWindow(),
			Integer.parseInt((selectionSecondes.getText()))
			+Integer.parseInt((selectionMinutes.getText()))*60
			+Integer.parseInt((selectionHeures.getText()))*3600,
			timerRadioButton.isSelected()
			));
	tableauTimer.get(tableauTimer.size()-1).start();
	}
	
	
	
	public JPanel buildContentPanel(){
		
		/*selection radio button -> timer/count down*/
		selectionGroup = new ButtonGroup();
		timerRadioButton = new JRadioButton("Chronomètre");
		countdownRadioButton = new JRadioButton("Compte à rebours");
		timerRadioButton.setSelected(true);
		selectionGroup.add(timerRadioButton);
		selectionGroup.add(countdownRadioButton);
		JPanel selectionPanel = new JPanel();
		selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.PAGE_AXIS));
		selectionPanel.add(timerRadioButton);
		selectionPanel.add(countdownRadioButton);
		
		//panel.setLayout(new GridLayout(3,5));
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.weighty = 1;
		
		/*1st line*/
		c.gridx = 0;
		c.gridy = 0;
		panel.add(new JLabel("Heures"),c);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(new JLabel(""),c);
		c.gridx = 2;
		c.gridy = 0;
		panel.add(new JLabel("Minutes"),c);
		c.gridx = 3;
		c.gridy = 0;
		panel.add(new JLabel(""),c);
		c.gridx = 4;
		c.gridy = 0;
		panel.add(new JLabel("Secondes"),c);
		
		/*2nd line*/
		c.gridx = 0;
		c.gridy = 1;
		panel.add(selectionHeures,c);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(new JLabel (":"),c);
		c.gridx = 2;
		c.gridy = 1;
		panel.add(selectionMinutes,c);
		c.gridx = 3;
		c.gridy = 1;
		panel.add(new JLabel(":"),c);
		c.gridx = 4;
		c.gridy = 1;
		panel.add(selectionSecondes,c);
		
		/*3rd line*/
		c.gridx = 0;
		c.gridy = 2;
		panel.add(boutonStart,c);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 4;
		panel.add(selectionPanel,c);
		/*panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));*/
		
		panel.setFocusable(true);
		panel.requestFocus();
		
		return panel;
	}
	
	

}
