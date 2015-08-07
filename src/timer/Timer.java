/*This thread */

package timer;

import java.awt.Font;
import javax.swing.JLabel;


public class Timer extends Thread {

	/*Atributs*/
	private TimerWindow fen;
	private int secondes;
	private JLabel secondesLabel = new JLabel();
	private JLabel minutesLabel = new JLabel();
	private JLabel heuresLabel = new JLabel();
	private JLabel deuxPoint1 = new JLabel(":");
	private JLabel deuxPoint2 = new JLabel(":");

	
	
	/*Methodes*/
	public Timer(TimerWindow _fen,int _secondes)
	{
		fen=_fen;
			if(secondes<0)
			{
			secondes=0;
			}
		secondes=_secondes;
		secondesLabel.setText(String.valueOf(secondes%60));
		minutesLabel.setText(String.valueOf((secondes/60)%60));
		heuresLabel.setText(String.valueOf((secondes/3600)));
		
		secondesLabel.setFont(new Font(null,Font.BOLD,100));
		minutesLabel.setFont(new Font(null,Font.BOLD,100));
		heuresLabel.setFont(new Font(null,Font.BOLD,100));
		deuxPoint1.setFont(new Font(null,Font.BOLD,100));
		deuxPoint2.setFont(new Font(null,Font.BOLD,100));
				
		fen.add(this.getHeuresLabel());
		fen.add(deuxPoint1);
		fen.add(this.getMinutesLabel());
		fen.add(deuxPoint2);
		fen.add(this.getSecondesLabel());
		
		/*On centre les Jlabel*/
		secondesLabel.setHorizontalAlignment(JLabel.CENTER);
		minutesLabel.setHorizontalAlignment(JLabel.CENTER);
		heuresLabel.setHorizontalAlignment(JLabel.CENTER);
		deuxPoint1.setHorizontalAlignment(JLabel.CENTER);
		deuxPoint2.setHorizontalAlignment(JLabel.CENTER);
		
	}
	
	public void run()
	{
		while(true)
		{

			
			
			/*1 seconde d'attente*/
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				
			} 
			
			if(secondes>0)
			{
			secondes--;
			secondesLabel.setText(String.valueOf(secondes%60));
			minutesLabel.setText(String.valueOf((secondes/60)%60));
			heuresLabel.setText(String.valueOf((secondes/3600)));
			}
		}
	}
	
	public JLabel getSecondesLabel()
	{
		return (secondesLabel);
	}
	
	public JLabel getMinutesLabel()
	{
		return (minutesLabel);
	}
	
	public JLabel getHeuresLabel()
	{
		return (heuresLabel);
	}
}
