/**
 * 
 */
package customCharacter;

import java.util.ArrayList;
import java.util.Hashtable;

import toolBox.Character;

//TODO : Doc
//TODO : Complete Methode.
/**
 * @author renaud
 *
 */
public class CustomCharacterSheet extends Character {

	
	private ArrayList<AbstractCategory> content = new ArrayList<AbstractCategory>();
	/**
	 * Initialize the Custom
	 */
 	public CustomCharacterSheet(String relatedRPG) {
		this.relatedRPG = new String(relatedRPG);
	}
 	
	/* (non-Javadoc)
	 * @see toolBox.GUIParametrizable#getGUIInputs(java.util.Hashtable)
	 */
	@Override
	public void getGUIInputs(Hashtable<String, Object> ht) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see toolBox.Character#saveAsXml()
	 */
	@Override
	public void saveAsXml() {
		// TODO Auto-generated method stub

	}

}
