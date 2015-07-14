package gui.characterDisplay;

import javax.swing.JLabel;

import warhammerCharacter.WarhammerCharacter;

public class CharacterSheetWarhammer extends CharacterSheet {

	/*attributes*/
	private static final long serialVersionUID = 3637174654061296591L;
	protected WarhammerCharacter character;

	/*Methods*/
	public CharacterSheetWarhammer(WarhammerCharacter cha) {
		character = cha;
		createSheet();
	}

	@Override
	protected void createSheet() {
		add(new JLabel(character.toString()));
	//	setSize(getPreferredSize().width + 30, getPreferredSize().height);
		
		
	}

	

}
