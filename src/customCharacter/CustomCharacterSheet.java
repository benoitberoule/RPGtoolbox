/**
 * 
 */
package customCharacter;

import java.util.ArrayList;
import java.util.Hashtable;

import toolBox.Character;


/**
 * It's the standard Character Sheet for an unregistered RPG.
 * @author renaud
 */
public class CustomCharacterSheet extends Character {

	
	private ArrayList<AbstractCategory> content = new ArrayList<AbstractCategory>();
	
	private int find(String name){
		int index = 0;
		while(index < this.content.size()){
			if (this.content.get(index).name.compareTo(name) == 0){
				return index;
			}
			++index;
		}
		return -1;
	}
	
	//Builder
	/**
	 * Initialize the CustomCharacter Sheet.
	 * @param relatedRPG
	 * 		Name the RPG of this Sheet. 
	 */
 	public CustomCharacterSheet(String relatedRPG) {
		this.relatedRPG = new String(relatedRPG);
	}

	
	//Manipulation.
	/**
	 * Add a category to this sheet.
	 * @param name
	 * 		Name of the Category to add.
	 */
	public void addCategory(String name){
		content.add(new Category(name));
	}
	/**
	 * Add a String Field to the sheet.
	 * @param name
	 * 		Name of the Field.
	 * @param val
	 * 		Value of the Field.
	 */
	public void addField(String name, String val){
		content.add(new Field(name, val));
	}
	/**
	 * Add an integer field to the sheet.
	 * @param name
	 * 		Name of the field.
	 * @param val
	 * 		Value of the field.
	 */
	public void addField(String name, int val){
		content.add(new Field(name, val));
	}
	/**
	 * Delete a category.
	 * @param c
	 * 		Category to delete.
	 * @return 
	 * 		true if succed, false if not.
	 */
	public boolean deleteCategory(Category c){
		if(content.remove(c)) return true;
		else return false;
	}
	/**
	 * Delete a field.
	 * @param f
	 * 		Field to delete;
	 * @return
	 * 		true if succeed, false if not.
	 */
	public boolean deleteField(Field f){
		if(content.remove(f)) return true;
		else return false;
	}
	/**
	 * Delete the first AbstractCategory which has this name.
	 * @param name
	 * 		Name of the AbstractCategory to delete.
	 * @return
	 * 	true if succeed, false if not.
	 */
	public boolean delete(String name){
		try {
			if(content.remove(find(name)) != null) return true;
			else return false;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
		
	}
	
	//Misc.
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

	public void saveAsXml() {
		// TODO Auto-generated method stub

	}
}
