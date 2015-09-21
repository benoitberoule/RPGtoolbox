/*This module create a timer or a count down which is completely parametrizable by the user */

package toolBox;

import java.awt.event.ActionEvent;

import timer.TimerCreationWindow;


public class TimerModule extends Module {
	
	public TimerModule()
	{
		name = "Chronomètre/Compte à rebours";
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		TimerCreationWindow timerFrame = new TimerCreationWindow();
		timerFrame.setVisible(true);
	}

}
