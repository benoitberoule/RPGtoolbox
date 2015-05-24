/*The skillChoice class represent the choice the player have to make between two skills when creating a character*/
package warhammerCharacter;

public class SkillChoice extends Skill{
	
	private static final long serialVersionUID = 4529315233772471697L;
	/*attributes*/
	protected Skill skill1;
	protected Skill skill2;
	
	public SkillChoice(Skill _skill1, Skill _skill2)
	{
		super(_skill1.getName(),_skill1.getAssociatedCar());
		skill1 = _skill1;
		skill2 = _skill2;
	}

	
	/*getter & setters*/	
	
	public Skill getSkill1() {
		return skill1;
	}

	public void setSkill1(Skill skill1) {
		this.skill1 = skill1;
	}

	public Skill getSkill2() {
		return skill2;
	}

	public void setSkill2(Skill skill2) {
		this.skill2 = skill2;
	}
	

	
	
}
