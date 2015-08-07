/*This class is used to select the time the timer will reach or start on*/

package timer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class TimerCreationWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*Atributs*/
	private JPanel panel = new JPanel();
	private JTextField selectionSecondes = new JTextField();
	private JTextField selectionMinutes = new JTextField();
	private JTextField selectionHeures = new JTextField();
	private JButton boutonStart = new JButton("start");
	ArrayList <Timer> tableauTimer = new ArrayList<Timer>();
	
	/*methodes*/
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
		
		/*Taille de la fenettre*/
		Dimension d = new Dimension (500,150);
		this.setSize(d);
		
		/*Ecouteur du boutton start*/
			boutonStart.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					pressStart();
				}
				
			});
			
				
			
		panel.setFocusable(true);
		panel.requestFocus();
			
	}
	
	
	public void pressStart()  //action si strat est cliqu�
	{
		/*Si rien n'est �crit on remplace par "0"*/
		if(!(Integer.parseInt((selectionSecondes.getText()))>0))
		{
			selectionSecondes.setText("0");
		}
		if(!(Integer.parseInt((selectionMinutes.getText()))>0))
		{
			selectionMinutes.setText("0");
		}
		if(!(Integer.parseInt((selectionHeures.getText()))>0))
		{
			selectionHeures.setText("0");
		}
		
	tableauTimer.add(new Timer(new TimerWindow(),
			Integer.parseInt((selectionSecondes.getText()))
			+Integer.parseInt((selectionMinutes.getText()))*60
			+Integer.parseInt((selectionHeures.getText()))*3600
			
			));
	tableauTimer.get(tableauTimer.size()-1).start();
	}
	
	
	
	public JPanel buildContentPanel(){
		
		panel.setLayout(new GridLayout(3,5));
		
		/*1ere ligne*/
		panel.add(new JLabel("Heures"));
		panel.add(new JLabel(""));
		panel.add(new JLabel("Minutes"));
		panel.add(new JLabel(""));
		panel.add(new JLabel("Secondes"));
		
		/*2e ligne*/
		panel.add(selectionHeures);
		panel.add(new JLabel (":"));
		panel.add(selectionMinutes);
		panel.add(new JLabel(":"));
		panel.add(selectionSecondes);
		
		/*3e ligne*/
		panel.add(boutonStart);
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));

		panel.setFocusable(true);
		panel.requestFocus();
		
		return panel;
	}
	

}
