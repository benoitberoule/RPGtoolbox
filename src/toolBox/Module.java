/*A Module is a feature of the soft, each module may be used by a GM to manage a precise point of the game*/
package toolBox;

import java.awt.event.ActionListener;

public abstract class Module implements ActionListener{

	/*Attributes*/
	protected String name;
	protected String relatedRPG; //name of the corresping RPG 
	protected String type; //use to start the right GUI (ex: character_creation, smart_plan)
	
	
	/*Methods*/
	
	/*getters & setters*/
	public  String getName()
	{
		return name;
	}


	public String getType() {
		return type;
	}


	public String getRelatedRPG() {
		return relatedRPG;
	}
		
	
	

}
