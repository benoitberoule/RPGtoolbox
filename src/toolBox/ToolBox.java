/*RPGToolBox is a software which provide some support to game masters during 
 * a RPG session or it's preparation
 * Modules to develop:
 * -Character creation (warhammer) - coding
 * -Smart maps
 * -dice roll generator
 * -name generator
 * -background generator
 * 
 * 
 * TODO
 * ->Tacaisse
 * -pemettre une generation aléatoire de perso
 * -coder la version non générique de la GUI
 * -faire une vrai fiche perso
 * -vérifier que la  création de perszo est bien générique*/
package toolBox;

import gui.mainMenu.MainMenu;

import java.util.ArrayList;

public class ToolBox {

	/*attributes*/
	protected ArrayList<Module> moduleList = new ArrayList<Module>();
	
	/*methods*/
	public static void main(String[] args) {

		ArrayList<Module> moduleList = new ArrayList<Module>();
		
		WarhammerCharacterCreationModule wccm = new WarhammerCharacterCreationModule();
		moduleList.add(wccm);
		
		GeneralCharacterDisplayModule gcdm = new GeneralCharacterDisplayModule();
		moduleList.add(gcdm);
		
		MainMenu mainMenu = new MainMenu(moduleList);
		mainMenu.setVisible(true);

	}

}
