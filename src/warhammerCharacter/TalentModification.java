/*This class is used to perfomr modification on the character profil or skills thanks to a talent*/
package warhammerCharacter;

import java.io.Serializable;

public class TalentModification implements Serializable {
	
	private static final long serialVersionUID = 2773998940142490965L;
	/*attributes*/
	protected String car; //the caracteristic to modify
	protected int bonus; //the bonus to apply
	
	/*methods*/
	public TalentModification(String _car, int _bonus)
	{
		car = _car;
		bonus = _bonus;
	}
	
	/*modify the character profil/skills depending on the talent*/
	public void modify(WarhammerCharacter charracter)
	{
		charracter.modifyBasicProfil(car, bonus);
	}

}
