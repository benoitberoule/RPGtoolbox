/*This class represent the race the player may choose for it's character.
 * basicly he/she may choose between human, elf, dwarf and halfing*/
package warhammerCharacter;

import java.io.Serializable;
import java.util.ArrayList;

public class Race implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4054943817634742625L;
	/*attributes*/
	protected String name;
	protected String description;
	protected ArrayList<Skill> skills = new ArrayList<Skill>();
	protected ArrayList<Talent> talents = new ArrayList<Talent>();
	
	/*methods*/
	public Race(String _name)
	{
		name = _name;
	}
	
	public String toString()
	{
		return name;
	}
}
