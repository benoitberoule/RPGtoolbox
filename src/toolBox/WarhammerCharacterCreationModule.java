/*This module is used to create a warhammer character, it contain an empty character that the user will create.
 * In this class, the possible Talents et skills are read from xml files*/
package toolBox;

import gui.characterCreation.CharacterCreationFrame;
import gui.mainMenu.ModuleButton;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import warhammerCharacter.Career;
import warhammerCharacter.Profil;
import warhammerCharacter.Skill;
import warhammerCharacter.SkillChoice;
import warhammerCharacter.Talent;
import warhammerCharacter.WarhammerCharacter;
import warhammerCharacter.TalentChoice;;

public class WarhammerCharacterCreationModule extends CharacterCreationModule {

	/*attributes*/
	protected Hashtable<Integer,Skill> skillList;
	protected Hashtable<Integer,Talent> talentList;
	protected Hashtable<Integer,Career> careerList;
	
	
	/*methods*/
	public WarhammerCharacterCreationModule()
	{
		super();
		name = "Création de personnages (Warhammer)";
		relatedRPG = "Warhammer";
		currentCharacter = new WarhammerCharacter(this);
		readSkillListFromXML();
		readTalentListFromXML();
		readCareerListFromXML();
		createFilePath();
		initializeCategories();

	}
	
	/*initialize a new character*/
	public void newCharacter()
	{
		currentCharacter = new WarhammerCharacter(this);
	}
	
	/*Create the careers list by reading the xml file career_XX.xml*/
	private void readCareerListFromXML()
	{
		careerList = new Hashtable<Integer,Career>();
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try{
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(new File("./xml/careers_FR.xml"));
			final NodeList nodeList = document.getDocumentElement().getChildNodes();
			
			for(int i = 0 ; i < nodeList.getLength(); ++i)
			{
				if(nodeList.item(i).getNodeType() == Node.ELEMENT_NODE)
				{
					final Element careerNode = (Element)nodeList.item(i);
					/*creating career*/
					Career career = new Career(((Element)(careerNode.getElementsByTagName("name").item(0))).getTextContent());
					/*add description*/
					career.setDescription(((Element)careerNode.getElementsByTagName("description").item(0)).getTextContent());
					/*add profil*/
					career.setProfil(new Profil(
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("CC").item(0)).getAttribute("val") ),
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("CT").item(0)).getAttribute("val")),
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("F").item(0)).getAttribute("val")),
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("E").item(0)).getAttribute("val")),
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("Ag").item(0)).getAttribute("val")),
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("Int").item(0)).getAttribute("val")),
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("FM").item(0)).getAttribute("val")),
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("Soc").item(0)).getAttribute("val")),
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("A").item(0)).getAttribute("val")),
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("B").item(0)).getAttribute("val")),
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("BF").item(0)).getAttribute("val")),
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("BE").item(0)).getAttribute("val")),
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("M").item(0)).getAttribute("val")),						
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("Mag").item(0)).getAttribute("val")),
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("PF").item(0)).getAttribute("val")),
							Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("profil").item(0)).getElementsByTagName("PD").item(0)).getAttribute("val"))));
					/*add skills*/
					for(int j = 0 ; j <  ((Element)careerNode.getElementsByTagName("skills").item(0)).getElementsByTagName("skill").getLength() ; ++j )
					{
						/*if there's a skill choice to make*/
						if( ! ((Element) ((Element)careerNode.getElementsByTagName("skills").item(0)).getElementsByTagName("skill").item(j)).getAttribute("or").equals("") ) 
						{
							
							career.addSkillChoice(
										skillList.get( Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("skills").item(0)).getElementsByTagName("skill").item(j)).getAttribute("id") ) ).clone()
									,  skillList.get( Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("skills").item(0)).getElementsByTagName("skill").item(j)).getAttribute("or") ) ).clone());
							/*add potential notes*/
							if(!((Element) ((Element)careerNode.getElementsByTagName("skills").item(0)).getElementsByTagName("skill").item(j)).getAttribute("note1").equals(""))
							{
								((SkillChoice)(career.getSkills().get(career.getSkills().size() - 1))).getSkill1().addNote(((Element) ((Element)careerNode.getElementsByTagName("skills").item(0)).getElementsByTagName("skill").item(j)).getAttribute("note1"));
							}
							
							if(!((Element) ((Element)careerNode.getElementsByTagName("skills").item(0)).getElementsByTagName("skill").item(j)).getAttribute("note2").equals(""))
							{
								((SkillChoice)(career.getSkills().get(career.getSkills().size() - 1))).getSkill2().addNote(((Element) ((Element)careerNode.getElementsByTagName("skills").item(0)).getElementsByTagName("skill").item(j)).getAttribute("note2"));
							}
							
						}else{
							
							career.addSkill(skillList.get( Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("skills").item(0)).getElementsByTagName("skill").item(j)).getAttribute("id") ) ).clone());
							
							/*Add potential note*/
							if(!((Element) ((Element)careerNode.getElementsByTagName("skills").item(0)).getElementsByTagName("skill").item(j)).getAttribute("note1").equals(""))
							{
								career.getSkills().get(career.getSkills().size() - 1).addNote(((Element) ((Element)careerNode.getElementsByTagName("skills").item(0)).getElementsByTagName("skill").item(j)).getAttribute("note1"));
							}
						}

					}
					
					/*add talent*/
					for(int j = 0 ; j <  ((Element)careerNode.getElementsByTagName("talents").item(0)).getElementsByTagName("talent").getLength() ; ++j )
					{
						/*if there's a talent choice to make*/
						if( ! ((Element) ((Element)careerNode.getElementsByTagName("talents").item(0)).getElementsByTagName("talent").item(j)).getAttribute("or").equals("") ) 
						{
							
							career.addTalentChoice(
										talentList.get( Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("talents").item(0)).getElementsByTagName("talent").item(j)).getAttribute("id") ) ).clone()
									,  talentList.get( Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("talents").item(0)).getElementsByTagName("talent").item(j)).getAttribute("or") ) ).clone());
							/*add potential notes*/
							if(!((Element) ((Element)careerNode.getElementsByTagName("talents").item(0)).getElementsByTagName("talent").item(j)).getAttribute("note1").equals(""))
							{
								((TalentChoice)(career.getTalents().get(career.getTalents().size() - 1))).getTalent1().addNote(((Element) ((Element)careerNode.getElementsByTagName("talents").item(0)).getElementsByTagName("talent").item(j)).getAttribute("note1"));
							}
							
							if(!((Element) ((Element)careerNode.getElementsByTagName("talents").item(0)).getElementsByTagName("talent").item(j)).getAttribute("note2").equals(""))
							{
								((TalentChoice)(career.getTalents().get(career.getTalents().size() - 1))).getTalent2().addNote(((Element) ((Element)careerNode.getElementsByTagName("talents").item(0)).getElementsByTagName("talent").item(j)).getAttribute("note2"));
							}
							
						}else{
							
							career.addTalent(talentList.get( Integer.parseInt( ((Element) ((Element)careerNode.getElementsByTagName("talents").item(0)).getElementsByTagName("talent").item(j)).getAttribute("id") ) ).clone());
							
							/*Add potential note*/
							if(!((Element) ((Element)careerNode.getElementsByTagName("talents").item(0)).getElementsByTagName("talent").item(j)).getAttribute("note1").equals(""))
							{
								career.getTalents().get(career.getTalents().size() - 1).addNote(((Element) ((Element)careerNode.getElementsByTagName("talents").item(0)).getElementsByTagName("talent").item(j)).getAttribute("note1"));
							}
						}

					}					
					
					
					careerList.put(Integer.parseInt( careerNode.getAttribute("id")), career);
				}
				
			}
			
		/*	for(Integer i : careerList.keySet())
			{
				System.out.println(careerList.get(i).getName() + "  id: " + i );
				System.out.println(careerList.get(i).getDescription());
				System.out.println("Profils");
				System.out.println(careerList.get(i).getProfil().getCaracTable());
				System.out.println("Skills");
				for(int j = 0 ; j < careerList.get(i).getSkills().size() ; ++j)
				{
					if(careerList.get(i).getSkills().get(j) instanceof SkillChoice)
					{
						System.out.println(((SkillChoice)(careerList.get(i).getSkills().get(j))).getSkill1().getName() + " or " + ((SkillChoice)(careerList.get(i).getSkills().get(j))).getSkill2().getName() );				
					}else if(careerList.get(i).getSkills().get(j) instanceof Skill){
						System.out.println(careerList.get(i).getSkills().get(j).getName());
					}
				}
				
				System.out.println("Talents");
				for(int j = 0 ; j < careerList.get(i).getTalents().size() ; ++j)
				{
					if(careerList.get(i).getTalents().get(j) instanceof TalentChoice)
					{
						System.out.println(((TalentChoice)(careerList.get(i).getTalents().get(j))).getTalent1().getName() + " or " + ((TalentChoice)(careerList.get(i).getTalents().get(j))).getTalent2().getName() );				
					}else if(careerList.get(i).getTalents().get(j) instanceof Talent){
						System.out.println(careerList.get(i).getTalents().get(j).getName());
					}
				}
				
			}*/
		
				
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*create the talents list by reading the xml file talent_XX.xml*/
	private void readTalentListFromXML()
	{
		talentList = new Hashtable<Integer,Talent>();
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try{
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(new File("./xml/talents_FR.xml"));
			final NodeList nodeList = document.getDocumentElement().getChildNodes();
			
			for(int i = 0 ; i < nodeList.getLength(); ++i)
			{
				if(nodeList.item(i).getNodeType() == Node.ELEMENT_NODE)
				{
					final Element talent = (Element) nodeList.item(i);
					talentList.put(Integer.parseInt( talent.getAttribute("id")), new Talent(talent.getAttribute("name")));
				}
				
			}
			
				
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*create the skills list by reading the xml file skill_XX.xml*/
	private void readSkillListFromXML()
	{
		skillList = new Hashtable<Integer,Skill>();
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try{
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(new File("./xml/skills_FR.xml"));
			final NodeList nodeList = document.getDocumentElement().getChildNodes();
			
			for(int i = 0 ; i < nodeList.getLength(); ++i)
			{
				if(nodeList.item(i).getNodeType() == Node.ELEMENT_NODE)
				{
					final Element skill = (Element) nodeList.item(i);
					skillList.put(Integer.parseInt( skill.getAttribute("id")), new Skill(skill.getAttribute("name"), skill.getAttribute("car")));
					
				}
				
			}

			
		}catch(Exception e){
			e.printStackTrace();
		}	
		
	}

	
	/*Setter & Getter*/
	
	public Hashtable<Integer, Skill> getSkillList() {
		return skillList;
	}

	public Hashtable<Integer, Talent> getTalentList() {
		return talentList;
	}

	public Hashtable<Integer, Career> getCareerList() {
		return careerList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CharacterCreationFrame ccf = new CharacterCreationFrame(  (CharacterCreationModule) ((ModuleButton)(e.getSource())).getModule()  );
		ccf.setVisible(true);
		
	}


}
