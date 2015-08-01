/*The main menu is the first menu showed when the application start
 * It display the list of each module sort by RPG.
 * each time you add a new type of module, you need to add it in the method "addActionListener"*/

package gui.mainMenu;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import toolBox.Module;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MainMenu extends JFrame{

	/*Attributes*/
	ArrayList<Module> moduleList;
	private static final long serialVersionUID = -6498068888785932773L;

	/*Methods*/
	public MainMenu(ArrayList<Module> _moduleList)
	{
		setTitle("Menu");
		setSize(400,600);
		moduleList = _moduleList;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildFrame();
	}
	
	/*Creation of the buttons corresponding to each module*/
	private void buildFrame()
	{
		ModuleButton curentButton;
		JPanel curentPanel;
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		
		/*module buttons*/
		for(int i = 0 ; i < moduleList.size() ; ++i)
		{
			curentPanel = new JPanel();
			curentPanel.setLayout(new BoxLayout(curentPanel, BoxLayout.LINE_AXIS));
			curentButton = new ModuleButton(moduleList.get(i).getName());
			addActionListener(curentButton,moduleList.get(i));
			curentPanel.add(curentButton);
			panel.add(curentPanel);

		}
		
		getContentPane().add(panel);
		
		repaint();
	}

	/*add to "button" the action listener which start the GUI corresponding to "module"*/
	private void addActionListener(ModuleButton button, Module module) {
		
		button.setModule(module);
		button.addActionListener(module);
		
		
	}
	
	
}
