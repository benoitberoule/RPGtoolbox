package customCharacter;

/**
 * Field is like a field in a character sheet.
 * It extends of AbstractCategory.
 * It take either a String attribute or an int attribute. 
 * @author Renaud
 */
public class Field extends AbstractCategory {

	private int val_int;
	private String val_str;
	
	//Builder
	/**
	 * Int field builder
	 * @param name
	 * 		Future value of name.
	 * @param val
	 * 		Future value of val_int.
	 */
	public Field(String name, int val){
		this.name = new String(name);
		this.val_int = val;
		System.out.println("Build " + this.name + " | Integer val : " + this.val_int);
	}
	/**
	 * String field builder.
	 * @param name
	 * 		Future value of name.
	 * @param val
	 * 		Future value of val_str.
	 */
	public Field(String name, String val){
		this.name = new String(name);
		this.val_str = new String(val);
		System.out.println("Build " + this.name + " | String val : " + this.val_str);
	}
	
	//Getter & setter
	/**
	 * Get val_str.
	 * @return val_str
	 * 		String attribute
	 */
	public String getStr(){
		return this.val_str;
	}
	/**
	 * Set val_str value.
	 * @param val
	 * 		Future string attribute.
	 */
	public void setStr(String val){
		this.val_str = val;
	}
	/**
	 * Get val_int.
	 * @return val_int
	 * 		val_int attribute.
	 */
	public int getInt(){
		return this.val_int;
	}
	/**
	 * Set val_int.
	 * @param val
	 * 		Future val_int value.
	 */
	public void setInt(int val){
		this.val_int = val;
	}
	
	//Misc
	public String toString(){
		String str = new String("<html><br>Name : ");
		str += this.name;
		if(val_str == null){
			str += "<br>Integer : " + val_int + "<br></html>";
		}
		else {
			str += "<br>String : " + val_str + "<br></html>";
		}
		return str;
	}
}


