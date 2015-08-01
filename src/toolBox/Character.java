/*This class represent a standard RPG character, it may be used to some RPG which have no specific CharacterCreationModule defined */
package toolBox;

import java.util.ArrayList;

public abstract class Character implements GUIParametrizable {

	
	/*Attributes*/
	protected ArrayList<String> categories = new ArrayList<String>();
	protected String relatedRPG = "";
	protected boolean createdByGenericGUI;
	

	
	public void removeCategories()
	{
		categories = new ArrayList<String>();
	}
	
	public void addCategory(String category)
	{
		categories.add(category);
	}
	
	
	public CharacterCreationModule getModule()
	{
		return null;
	}


	public ArrayList<String> getCategories() {
		return categories;
	}
}
