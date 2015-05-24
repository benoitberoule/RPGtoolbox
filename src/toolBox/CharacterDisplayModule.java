package toolBox;

import java.util.ArrayList;

public abstract class CharacterDisplayModule extends Module
{
	
	/*Attributes*/
	protected ArrayList<Character> charactersList = new ArrayList<Character>();
	
	/*Methods*/
	public CharacterDisplayModule()
	{
		type = "Character_display";
	}

	public String getFilesPath()
	{
		return "./RPG/"+relatedRPG+"/Characters/";
	}
	
	public String getFilesPath(String rpg)
	{
		return "./RPG/"+rpg+"/Characters/";
	}
}
