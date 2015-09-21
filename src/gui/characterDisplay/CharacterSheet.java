/*This panel display the information concerning a particular character
 * its appearence depends on the concerning RPG*/

package gui.characterDisplay;

import javax.swing.JLabel;
import javax.swing.JPanel;

public  class CharacterSheet extends JPanel {
	
	/*Attributes*/
	protected static final long serialVersionUID = 4661453764681000497L;
	protected  Character character;
	protected CharacterSheetFrame originalframe;
	
	
	/*Methods*/
	
	public CharacterSheet(CharacterSheetFrame _originalFrame, Character cha)
	{
		character = cha;
		originalframe = _originalFrame;
	}
	
	public CharacterSheet()
	{
		
	}
	
	/*create the concrete character sheet*/
	protected  void createSheet()
	{
		add(new JLabel(character.toString()));
		setSize(getPreferredSize());
	}

}
