package customCharacter;

import java.util.ArrayList;

/**
 * DeprecatedCategory is a collection of abstractCategory.
 * It use for group field or more complex field.
 * @author Renaud
 *
 */
public class DeprecatedCategory extends AbstractCategory{

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
	 * Build a void DeprecatedCategory with its name.
	 * @param name
	 * 		NAme of the category.
	 */
	public DeprecatedCategory(String name){
		this.name = new String(name);
		this.content = new ArrayList<AbstractCategory>();
		
		System.out.println("Build " + this.name);
	}
	/**
	 * Build a DeprecatedCategory with a Name and an ArrayList of AbstractCategory.
	 * @param name
	 * 		Name of the DeprecatedCategory.
	 * @param val
	 * 		ArrayList of AbstractCategory. The future contents of the category.
	 */
	public DeprecatedCategory(String name, ArrayList<AbstractCategory> val){
		this.name = new String(name);
		this.content = new ArrayList<AbstractCategory>(val);
		
		System.out.println("Build " + this.name + "Content : " + content);
	}
	/**
	 * Build a DeprecatedCategory with its and its contents.
	 * The content is a variable number of AbstractCategory Object.
	 * @param name
	 * 		Name of the category.
	 * @param elts
	 * 		The elements to add.
	 */
	public DeprecatedCategory(String name, AbstractCategory...  elts){
		this.name = new String(name);
		this.content = new ArrayList<AbstractCategory>();
		for(AbstractCategory it : elts){
			this.content.add(it);
		}
		
		System.out.println("Name : " + this.name + " Content : " + content);
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
	 * Set the content of the DeprecatedCategory.
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
		int index = find(name);
		if (index != -1){
			this.content.remove(index);
			return true;
		}
		else return false;
	}

	
	//Misc
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeprecatedCategory [content=" + content + ", name=" + name + "]";
	}
	
}
