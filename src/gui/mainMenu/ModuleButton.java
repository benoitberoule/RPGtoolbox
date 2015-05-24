/*This button is use to implement an action listener based on a module
 * It may be used to launch à module dependent GUI*/
package gui.mainMenu;

import javax.swing.JButton;

import toolBox.Module;

public class ModuleButton extends JButton {

	/*Attribute*/
	protected Module module;
	private static final long serialVersionUID = 7274315684787160008L;	
	
	/*Methods*/
	public ModuleButton()
	{
		super();
	}
	
	public ModuleButton(String _name)
	{
		super(_name);
	}
	
	public ModuleButton(String _name, Module _module)
	{
		super(_name);
		module = _module;
	}

	
	
	/*getter & setter*/
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	
	
}
