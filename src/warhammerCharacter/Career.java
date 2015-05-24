/*This class discribe a precise career of warhammer*/
package warhammerCharacter;

import java.io.Serializable;
import java.util.ArrayList;

import warhammerUniverse.Equipment;

public class Career implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2180816907964873846L;
	/*attributes*/
	protected String name;
	protected String description;
	protected String note; //to precise something
	protected Profil profil;
	protected ArrayList<Skill> skills = new ArrayList<Skill>();
	protected ArrayList<Talent> talents = new ArrayList<Talent>();
	protected ArrayList<Equipment> equipements = new ArrayList<Equipment>();
			
	/*methods*/
	public Career(String _name)
	{
		name =_name;
		profil = new Profil();
	}
	
	public Career(String _name, Profil _profil)
	{
		name = _name;
		profil = _profil;
	}

	/*Setters & Getters*/
	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public String getName() {
		return name;
	}
	
	public void addSkill(Skill sk)
	{
		skills.add(sk);
	}
	
	public void addSkillChoice(Skill sk1, Skill sk2)
	{
		skills.add(new SkillChoice(sk1, sk2));
	}
	
	public void addTalentChoice(Talent sk1, Talent sk2)
	{
		talents.add(new TalentChoice(sk1, sk2));
	}
	
	public void addTalent(Talent tl)
	{
		talents.add(tl);
	}
	
	public void addEquipement(Equipment eq)
	{
		equipements.add(eq);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	public ArrayList<Talent> getTalents() {
		return talents;
	}	
	
		



}

