/*This thread */

package timer;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;


public class Timer extends Thread implements KeyListener{

	/*Atributs*/
	private TimerWindow fen;
	private int secondes;
	private JLabel secondesLabel = new JLabel();
	private JLabel minutesLabel = new JLabel();
	private JLabel heuresLabel = new JLabel();
	private JLabel deuxPoint1 = new JLabel(":");
	private JLabel deuxPoint2 = new JLabel(":");
	private boolean timer; //timer = true (timer)   timer = false (count down)
	private boolean pause = false;

	
	
	/*Methodes*/
	public Timer(TimerWindow _fen,int _secondes, boolean _timer)
	{
		timer = _timer;
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
		
		fen.addKeyListener(this);
		
		/*labels centering*/
		secondesLabel.setHorizontalAlignment(JLabel.CENTER);
		minutesLabel.setHorizontalAlignment(JLabel.CENTER);
		heuresLabel.setHorizontalAlignment(JLabel.CENTER);
		deuxPoint1.setHorizontalAlignment(JLabel.CENTER);
		deuxPoint2.setHorizontalAlignment(JLabel.CENTER);
		
	}
	
	public void run()
	{
		boolean running = true;
		while(running)
		{
			if(!pause)
			{				
				if(secondes>=0)
				{
					if(timer)
					{
						secondes++; //timer
					}else{
						secondes--; //count down
					}
				secondesLabel.setText(String.valueOf(secondes%60));
				minutesLabel.setText(String.valueOf((secondes/60)%60));
				heuresLabel.setText(String.valueOf((secondes/3600)));
				}else{
					running = false;
				}
				
				/*wait 1 seconds*/
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					
				} 
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

	
	@Override
	public void keyPressed(KeyEvent arg0) {
		//do nothing
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// do nothing
		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if(((Character)(ke.getKeyChar())).hashCode() == KeyEvent.VK_SPACE)
		{
			pause = !pause;
		}
		
	}
}
