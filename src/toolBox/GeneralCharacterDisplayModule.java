/*This class is used to list the warhammer character saved as Xml thanks to the "warhammer creation module"*/
package toolBox;

import gui.characterDisplay.CharacterDisplayFrame;

import java.awt.event.ActionEvent;
import java.util.ArrayList;



public class GeneralCharacterDisplayModule extends CharacterDisplayModule {

	/*Methods*/
	public GeneralCharacterDisplayModule()
	{
		super();
		charactersList = new ArrayList<Character>();
		name = "Liste de personnages";
		relatedRPG = "";
		
	}
	
//	private void readCharacterFromBinarie(String rpg)
//	{
//		File charactersFile = new File(getFilesPath(rpg));
//		
//		WarhammerCharacter temp ;
//		
//		for (File f : charactersFile.listFiles())
//		{
//			try {
//				FileInputStream fis = new FileInputStream(f);
//				ObjectInputStream ois = new ObjectInputStream(fis);
//				try {
//					temp = (WarhammerCharacter) ois.readObject();
//					ois.close();
//					fis.close();
//					charactersList.add(temp);					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}	
//		}
//	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		CharacterDisplayFrame cdf = new CharacterDisplayFrame(this);
		cdf.setVisible(true);
		
	}
}
