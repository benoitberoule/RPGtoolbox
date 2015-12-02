/*The name generator module is used to randomly generate name for characters, city, monsters...*/
package toolBox;

import gui.nameGenerator.nameGeneratorFrame;

import java.awt.event.ActionEvent;

public class NameGeneratorModule extends Module {

	
	/*Methods*/
	public NameGeneratorModule()
	{
		name = "Générateur de noms";
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		nameGeneratorFrame.main(null);
	}

}
