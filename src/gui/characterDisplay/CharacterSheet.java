/*This panel display the information concerning a particular character
 * its appearence depends on the concerning RPG*/

package gui.characterDisplay;

import javax.swing.JPanel;

public abstract class CharacterSheet extends JPanel {
	
	/*Attributes*/
	protected static final long serialVersionUID = 4661453764681000497L;
	protected  Character character;
	/*Methods*/
	
	public CharacterSheet(Character cha)
	{
		character = cha;
	}
	
	public CharacterSheet()
	{
		
	}
	
	/*create the concrete character sheet*/
	protected abstract void createSheet();

}
