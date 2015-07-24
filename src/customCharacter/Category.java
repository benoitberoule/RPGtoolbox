package customCharacter;

import java.util.ArrayList;

/**
 * Category is a collection of abstractCategory.
 * It use for group field or more complex field.
 * @author Renaud
 *
 */
public class Category extends AbstractCategory{

	private ArrayList<AbstractCategory> val;
	
	/**
	 * Find the index of the AbstractCategory element which have name. Return -1 if it do not find anything.
	 * @param name
	 * 		The name research.
	 * @return index
	 * 		index of the element search.
	 */
	private int find(String name){
		int index = 0;
		while(index < val.size()){
			if (val.get(index).name == name) return index;
			++index;
		}
		return -1;
	}
	
	//Builder
	public Category(String name){
		this.name = new String(name);
	}
	
	public Category(String name, ArrayList<AbstractCategory> val){
		this.name = new String(name);
		this.val = new ArrayList<AbstractCategory>(val);
	}
	
	/**
	 * Add a new element in the category
	 * @param elt
	 * 		Element to add.
	 */
	public void addElement(AbstractCategory elt){
		val.add(elt);
	}
	
	/**
	 * Remove an AbastractCategory element.
	 * @param elt
	 * 		Element to remove.
	 */
	public void deleteElement(AbstractCategory elt){
		val.remove(elt);
	}
	/**
	 * Delete the first AbstractCategory which have name as attribute.
	 * @param name
	 * 		Name of the AbstractCategory item to delete.
	 * @return boolean
	 * 		true if succeed. false if not.
	 */
	public boolean deleteElement(String name){
		if (val.remove(find(name)) != null) return true;
		else return false;
	}
	
}
