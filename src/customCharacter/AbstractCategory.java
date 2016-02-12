package customCharacter;
/**
 * customCategory is an abstract class used for field and category.
 * It has only have a name and a the getter and setter.
 * It create in order to use both Field and DeprecatedCategory in a collection.
 * @author Renaud
 */

public abstract class AbstractCategory {
	
	protected String name;
	
	//Getter & Setter
	/**
	 * Get name attribute.
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Set the name attribute.
	 * @param val
	 * 		The future value of val.
	 */
	public void setName(String val){
		this.name = val;
	}
	
}
