package toolBox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public abstract class CharacterCreationModule extends Module {

	/*Attributes*/
	protected Character currentCharacter;
	protected ArrayList<String> categorysList;

	/*Methods*/
	public CharacterCreationModule()
	{
		categorysList = new ArrayList<String>();
		type = "Character_creation";
	}
	
	/*initialize a new character*/
	public abstract void newCharacter();
	
	/*Create the directories used to register the characters*/
	protected void createFilePath()
	{
		/*create the path file*/
		File file = new File("./RPG");
		if(!file.exists())
		{
			file.mkdir();
		}
		
		file = new File(file.getAbsolutePath()+"/"+relatedRPG);
		
		if(!file.exists())
		{
			file.mkdir();
		}
		
		file = new File(file.getAbsolutePath()+"/"+"Characters/");
		
		if(!file.exists())
		{
			file.mkdir();
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	protected void initializeCategories()
	{
		File file = new File("./RPG/"+relatedRPG+"/categories");
		if(file.exists())
		{
			try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
				try {
					categorysList = (ArrayList<String>) ois.readObject();
					ois.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	/*getters & Setters*/
	public Character getCurrentCharacter() {
		return currentCharacter;
	}


	public ArrayList<String> getCategoriesList() {
		return categorysList;
	}
	
	public void addCategory (String category)
	{
		categorysList.add(category);
		
		saveCategoryList();
		
	}


	public void deleteCategory(int index) {
		
		for(int i = index ; i < categorysList.size() - 1 ; ++i)
		{
			categorysList.set(i, categorysList.get(i + 1));
		}
		categorysList.remove(categorysList.size() - 1);
		saveCategoryList();
		
	}
	
	protected void saveCategoryList()
	{
		File file = new File("./RPG/"+relatedRPG+"/categories");
		
		if(file.exists())
		{
			file.delete();
		}
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file.getAbsolutePath());
		ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(categorysList);
			oos.flush();
			oos.close();
			fos.close();
		}catch(Exception ioe)
		{
			ioe.printStackTrace();
		}
	}

	
	public String getFilesPath()
	{
		return "./RPG/"+relatedRPG+"/Characters/";
	}
	
	
}
