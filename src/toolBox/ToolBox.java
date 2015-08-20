/*RPGToolBox is a software which provide some support to game masters during 
 * a RPG session or it's preparation
 * Modules to develop:
 * -Character creation (warhammer) - coding
 * -Smart maps
 * -dice roll generator - coding
 * -name generator - coding
 * -générateur de plan
 * -générateur de batiment (genre un nom, une histoire, les habitants, le plan...)
 * -background generator
 * 
 * 
 * Regles à suivre
 * - Coder en anglais
 * - Respecter le design pattern Modele-Vue, séparer le modele et la GUI dans des packages à part
 * - Chaque classe doit commencer par une ou plusieurs lignes de commentaire détaillant son utilité
 * - Convention de nommage
 * 	* MaClasse
 * 	* maVariableDuSwag
 * 	* maFonctionDuSwag
 * 	* MA_VARIABLE_GLOBALE
 *  * monPackageDuSwag
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
		
		GeneralCharacterDisplayModule gcdm = new GeneralCharacterDisplayModule();
		moduleList.add(gcdm);
		
		TimerModule tm = new TimerModule();
		moduleList.add(tm);
		
		NameGeneratorModule ngm = new NameGeneratorModule();
		moduleList.add(ngm);
		
		MainMenu mainMenu = new MainMenu(moduleList);
		mainMenu.setVisible(true);		
		
	}

}
