/*The talentChoice class represent the choice the player have to make between two talents when creating a character*/
package warhammerCharacter;

public class TalentChoice extends Talent{
	
	private static final long serialVersionUID = -2602856224871952447L;
	/*attributes*/
	protected Talent talent1;
	protected Talent talent2;
	
	public TalentChoice(Talent _talent1, Talent _talent2)
	{
		super(_talent1.getName());
		talent1 = _talent1;
		talent2 = _talent2;
	}

	
	/*getter & setters*/	
	
	public Talent getTalent1() {
		return talent1;
	}

	public void setTalent1(Talent talent1) {
		this.talent1 = talent1;
	}

	public Talent getTalent2() {
		return talent2;
	}

	public void setTalent2(Talent talent2) {
		this.talent2 = talent2;
	}
	
}