/*This class represent a skill a charachter may learn and use.
 * the possible bonuses are not implement here but directly in the character*/
package warhammerCharacter;

import java.io.Serializable;

public class Skill implements Cloneable,Serializable {

	
	/*attribute*/
	protected String name;
	protected String note; // additional element (ex: Language (Reikspiel))
	protected String associatedCar; //must correspond to one from the profil
	protected String description;
	private static final long serialVersionUID = -98897937569758580L;
	
	/*methods*/
	public Skill(String _name , String _associatedCar){
		name = _name;
		associatedCar = _associatedCar;
		note = "";
	}
	
	public Skill(String _name, String _note, String _associatedCar)
	{
		name = _name;
		associatedCar = _associatedCar;
		note = _note;
		
	}
	
	public Skill clone()
	{
		try {
			return (Skill) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/*Getters & Setters*/
	public String getName() {
		
		if(note.equals(""))
		{
			return name;
		}else{
			return name + " " + note;
		}
	
	}
	
	public void addNote(String _note )
	{
		note = _note;
	}

	public String getAssociatedCar() {
		return associatedCar;
	}
	
	public String getDescription(){
		return description;				
	}
	
	
	
}
