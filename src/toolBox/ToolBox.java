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
 * -pemettre une generation al�atoire de perso
 * -coder la version non g�n�rique de la GUI
 * -faire une vrai fiche perso
 * -v�rifier que la  cr�ation de perszo est bien g�n�rique*/
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
		
		GeneralCharacterDisplayModule wcdm = new GeneralCharacterDisplayModule();
		moduleList.add(wcdm);
		
		MainMenu mainMenu = new MainMenu(moduleList);
		mainMenu.setVisible(true);

	}

}
