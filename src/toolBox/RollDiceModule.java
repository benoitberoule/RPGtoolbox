package toolBox;

import gui.rollDice.RollDiceFrame;

import java.awt.event.ActionEvent;

import rollDice.RollDice;

public class RollDiceModule extends Module{

	
	public RollDiceModule(){
		name = "Dice Simulator";
	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		RollDice rd = new RollDice();
		RollDiceFrame rdf = new RollDiceFrame();
		rdf.setVisible(true);
	}

}
