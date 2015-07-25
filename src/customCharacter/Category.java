package customCharacter;

import java.util.ArrayList;

/**
 * Category is a collection of abstractCategory.
 * It use for group field or more complex field.
 * @author Renaud
 *
 */
public class Category extends AbstractCategory{

	private ArrayList<AbstractCategory> content;
	
	//Utility
	/**
	 * Find the index of the AbstractCategory element which have name. Return -1 if it do not find anything.
	 * @param name
	 * 		The name research.
	 * @return index
	 * 		index of the element search.
	 */
	private int find(String name){
		int index = 0;
		while(index < content.size()){
			if (content.get(index).name == name) return index;
			++index;
		}
		return -1;
	}
	
	//Builder
	/**
	 * Build a void Category with its name.
	 * @param name
	 * 		NAme of the category.
	 */
	public Category(String name){
		this.name = new String(name);
		this.content = new ArrayList<AbstractCategory>();
	}

	/**
	 * Build a Category with a Name and an ArrayList of AbstractCategory.
	 * @param name
	 * 		Name of the Category.
	 * @param val
	 * 		ArrayList of AbstractCategory. The future contents of the category.
	 */
	public Category(String name, ArrayList<AbstractCategory> val){
		this.name = new String(name);
		this.content = new ArrayList<AbstractCategory>(val);
	}
	/**
	 * Build a Category with its and its contents.
	 * The content is a variable number of AbstractCategory Object.
	 * @param name
	 * 		Name of the category.
	 * @param elts
	 * 		The elements to add.
	 */
	public Category(String name, AbstractCategory...  elts){
		this.name = new String(name);
		this.content = new ArrayList<AbstractCategory>();
		for(AbstractCategory it : elts){
			this.content.add(it);
		}
	}
	
	//Getter & Setters
	/**
	 * Get the content of the category.
	 * @return content
	 * 		Content of the category.
	 */
	public ArrayList<AbstractCategory> getContent(){
		return this.content;
	}
	/**
	 * Set the content of the Category.
	 * @param content
	 * 		Content to set.
	 */
	public void setContent(ArrayList<AbstractCategory> content) {
		this.content = content;
	}

	//Manipulation
	/**
	 * Add a new element in the category
	 * @param elt
	 * 		Element to add.
	 */
	public void addElement(AbstractCategory elt){
		content.add(elt);
	}
	/**
	 * Remove an AbastractCategory element.
	 * @param elt
	 * 		Element to remove.
	 */
	public void deleteElement(AbstractCategory elt){
		content.remove(elt);
	}
	/**
	 * Delete the first AbstractCategory which have name as attribute.
	 * @param name
	 * 		Name of the AbstractCategory item to delete.
	 * @return boolean
	 * 		true if succeed. false if not.
	 */
	public boolean deleteElement(String name){
		if (content.remove(find(name)) != null) return true;
		else return false;
	}
	
}
