/*This class is used to display the timer*/

package timer;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class TimerWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*Atributs*/
	private JPanel panel = new JPanel();
	private JLabel secondesLabel = new JLabel("heures");
	private JLabel minutesLabel = new JLabel("minutes");
	private JLabel heuresLabel = new JLabel("secondes");
	
	/*methodes*/
	public TimerWindow()
	{
		build();
	}
	
	public void build()
	{
		this.setTitle("Chronometre");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		//setExtendedState(MAXIMIZED_BOTH);
		setSize(700,500);
		setContentPane(buildContentPanel());
		
		/*Taille de la fenettre*/
		Dimension d = new Dimension (1000,300);
		this.setSize(d);
		
		/*On centre les Jlabel*/
		secondesLabel.setHorizontalAlignment(JLabel.CENTER);
		minutesLabel.setHorizontalAlignment(JLabel.CENTER);
		heuresLabel.setHorizontalAlignment(JLabel.CENTER);
		
		/*Et on change leurs tailles*/
		secondesLabel.setFont(new Font(null,Font.BOLD,30));
		minutesLabel.setFont(new Font(null,Font.BOLD,30));
		heuresLabel.setFont(new Font(null,Font.BOLD,30));
		
		}
	
	public JPanel buildContentPanel(){
		
		panel.setLayout(new GridLayout(2,5));
		
		panel.add(secondesLabel);
		panel.add(new JLabel(""));
		panel.add(minutesLabel);
		panel.add(new JLabel(""));
		panel.add(heuresLabel);

		return panel;
	}
	

}
