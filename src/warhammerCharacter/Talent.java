/*This class represent the talents a character/monster may have*/
package warhammerCharacter;

import java.io.Serializable;

public class Talent implements Cloneable,Serializable{

	private static final long serialVersionUID = -7923984226790546987L;
	/*attributes*/
	protected String name;
	protected String description;
	protected String note;
	protected TalentModification modification;
	
	/*methods*/
	public Talent(String _name)
	{
		name = _name;
	}
	
	public Talent(String _name, String _note)
	{
		name = _name;
		note = _note;
		
	}
	
	public Talent clone()
	{
		try {
			return (Talent) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void addNote(String _note)
	{
		note = _note;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}
	
	

}

