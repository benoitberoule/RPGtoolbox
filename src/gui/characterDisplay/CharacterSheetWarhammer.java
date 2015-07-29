/*This class represent the warhammer character sheet, it sum up every character details and each of them may be directly modify*/
package gui.characterDisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import warhammerCharacter.Career;
import warhammerCharacter.Race;
import warhammerCharacter.WarhammerCharacter;

public class CharacterSheetWarhammer extends CharacterSheet {

	/*attributes*/
	private static final long serialVersionUID = 3637174654061296591L;
	protected WarhammerCharacter character;
	protected JLabel sheet;

	/*Methods*/
	public CharacterSheetWarhammer(JFrame _originalFrame, WarhammerCharacter cha) {
		originalframe = _originalFrame;
		character = cha;
		ImageIcon characterSheetImage = new ImageIcon("./RPG/Warhammer/fichePerso.png");
		sheet = new JLabel(characterSheetImage);
		setPreferredSize(new Dimension(characterSheetImage.getIconWidth(),characterSheetImage.getIconHeight()));
		createSheet();
	}

	@Override
	protected void createSheet() {
		setLayout(null);

		/*positioning the attributes*/
		
		/*Name*/
		EditableLabel nameLabel = new EditableLabel("name",this, new JLabel(character.getName() ));
		nameLabel.setLocation(sheet.getX()+ 85, sheet.getY()+80);
		nameLabel.setSize(nameLabel.getPreferredSize());
		add(nameLabel);
		
		/*Race*/
		EditableLabel raceLabel = new EditableLabel("race",this, new JLabel(character.getRace().toString() ));
		raceLabel.setLocation(sheet.getX()+ 85, sheet.getY()+95);
		raceLabel.setSize(raceLabel.getPreferredSize());
		add(raceLabel);	
		
		/*Current Career*/
		EditableLabel careerLabel = new EditableLabel("currentCareer",this, new JLabel(character.getCurrentCareer().getName()));
		careerLabel.setLocation(sheet.getX()+ 130, sheet.getY()+110);
		careerLabel.setSize(careerLabel.getPreferredSize());
		add(careerLabel);	
		
		/*Age*/
		EditableLabel ageLabel = new EditableLabel("age",this, new JLabel(Integer.toString(character.getAge()))     );
		ageLabel.setLocation(sheet.getX()+ 80, sheet.getY()+183);
		ageLabel.setSize(ageLabel.getPreferredSize());
		add(ageLabel);	
		
		/*EyeColor*/
		EditableLabel eyeColorLabel = new EditableLabel("eyeColor",this, new JLabel(character.getEyesColor())     );
		eyeColorLabel.setLocation(sheet.getX()+ 133, sheet.getY()+198);
		eyeColorLabel.setSize(eyeColorLabel.getPreferredSize());
		add(eyeColorLabel);		
		
		/*HairColor*/
		EditableLabel hairColorLabel = new EditableLabel("hairColor",this, new JLabel(character.getHairColor())     );
		hairColorLabel.setLocation(sheet.getX()+ 145, sheet.getY()+213);
		hairColorLabel.setSize(hairColorLabel.getPreferredSize());
		add(hairColorLabel);		
		
		/*AstralSign*/
		EditableLabel astralSignLabel = new EditableLabel("astralSign",this, new JLabel(character.getAstralSign())     );
		astralSignLabel.setLocation(sheet.getX()+ 105, sheet.getY()+228);
		astralSignLabel.setSize(astralSignLabel.getPreferredSize());
		add(astralSignLabel);		
		
		/*Sex*/
		EditableLabel sexLabel = new EditableLabel("sex",this, new JLabel(String.valueOf(character.getSex()))     );
		sexLabel.setLocation(sheet.getX()+ 245, sheet.getY()+183);
		sexLabel.setSize(sexLabel.getPreferredSize());
		add(sexLabel);		
		
		/*Height*/
		EditableLabel heightLabel = new EditableLabel("height",this, new JLabel(String.valueOf(character.getHeigth()))     );
		heightLabel.setLocation(sheet.getX()+ 242, sheet.getY()+198);
		heightLabel.setSize(heightLabel.getPreferredSize());
		add(heightLabel);		
		
		
		/*Weight*/
		EditableLabel weightLabel = new EditableLabel("weight",this, new JLabel(String.valueOf(character.getWeigth()))     );
		weightLabel.setLocation(sheet.getX()+ 242, sheet.getY()+214);
		weightLabel.setSize(weightLabel.getPreferredSize());
		add(weightLabel);			
		
		/*Brother and sister*/
		EditableLabel broAndSisLabel = new EditableLabel("broAndSis",this, new JLabel(String.valueOf(character.getBrotherAndSisterAmount()))     );
		broAndSisLabel.setLocation(sheet.getX()+ 322, sheet.getY()+229);
		broAndSisLabel.setSize(broAndSisLabel.getPreferredSize());
		add(broAndSisLabel);
		
		/*Native land*/
		EditableLabel nativeLandLabel = new EditableLabel("nativeLand",this, new JLabel(String.valueOf(character.getNativeLand()))     );
		nativeLandLabel.setLocation(sheet.getX()+ 140, sheet.getY()+245);
		nativeLandLabel.setSize(nativeLandLabel.getPreferredSize());
		add(nativeLandLabel);
		
		/*Distinct sign*/
		EditableLabel distinctSignLabel = new EditableLabel("distinctSign",this, new JLabel(String.valueOf(character.getDistinctSign()))     );
		distinctSignLabel.setLocation(sheet.getX()+ 140, sheet.getY()+260);
		distinctSignLabel.setSize(distinctSignLabel.getPreferredSize());
		add(distinctSignLabel);
		
		/*Basic profil*/
		EditableLabel basic_CCLabel = new EditableLabel("basic_CC",this, new JLabel(String.valueOf(character.getBasicProfil().get("CC")))     );
		basic_CCLabel.setLocation(sheet.getX()+ 120, sheet.getY()+350);
		basic_CCLabel.setSize(basic_CCLabel.getPreferredSize());
		add(basic_CCLabel);
		
		EditableLabel basic_CTLabel = new EditableLabel("basic_CT",this, new JLabel(String.valueOf(character.getBasicProfil().get("CT")))     );
		basic_CTLabel.setLocation(sheet.getX()+ 151, sheet.getY()+350);
		basic_CTLabel.setSize(basic_CTLabel.getPreferredSize());
		add(basic_CTLabel);
		
		EditableLabel basic_FLabel = new EditableLabel("basic_F",this, new JLabel(String.valueOf(character.getBasicProfil().get("F")))     );
		basic_FLabel.setLocation(sheet.getX()+ 182, sheet.getY()+350);
		basic_FLabel.setSize(basic_FLabel.getPreferredSize());
		add(basic_FLabel);
		
		EditableLabel basic_ELabel = new EditableLabel("basic_E",this, new JLabel(String.valueOf(character.getBasicProfil().get("E")))     );
		basic_ELabel.setLocation(sheet.getX()+ 214, sheet.getY()+350);
		basic_ELabel.setSize(basic_ELabel.getPreferredSize());
		add(basic_ELabel);
		
		EditableLabel basic_AgLabel = new EditableLabel("basic_Ag",this, new JLabel(String.valueOf(character.getBasicProfil().get("Ag")))     );
		basic_AgLabel.setLocation(sheet.getX()+ 246, sheet.getY()+350);
		basic_AgLabel.setSize(basic_AgLabel.getPreferredSize());
		add(basic_AgLabel);
		
		EditableLabel basic_IntLabel = new EditableLabel("basic_Int",this, new JLabel(String.valueOf(character.getBasicProfil().get("Int")))     );
		basic_IntLabel.setLocation(sheet.getX()+ 278, sheet.getY()+350);
		basic_IntLabel.setSize(basic_IntLabel.getPreferredSize());
		add(basic_IntLabel);
		
		EditableLabel basic_FMLabel = new EditableLabel("basic_FM",this, new JLabel(String.valueOf(character.getBasicProfil().get("FM")))     );
		basic_FMLabel.setLocation(sheet.getX()+ 310, sheet.getY()+350);
		basic_FMLabel.setSize(basic_FMLabel.getPreferredSize());
		add(basic_FMLabel);
		
		EditableLabel basic_SocLabel = new EditableLabel("basic_Soc",this, new JLabel(String.valueOf(character.getBasicProfil().get("Soc")))     );
		basic_SocLabel.setLocation(sheet.getX()+ 342, sheet.getY()+350);
		basic_SocLabel.setSize(basic_SocLabel.getPreferredSize());
		add(basic_SocLabel);
		
		/*------------------*/
		EditableLabel basic_ALabel = new EditableLabel("basic_A",this, new JLabel(String.valueOf(character.getBasicProfil().get("A")))     );
		basic_ALabel.setLocation(sheet.getX()+ 120, sheet.getY()+437);
		basic_ALabel.setSize(basic_ALabel.getPreferredSize());
		add(basic_ALabel);
		
		EditableLabel basic_BLabel = new EditableLabel("basic_B",this, new JLabel(String.valueOf(character.getBasicProfil().get("B")))     );
		basic_BLabel.setLocation(sheet.getX()+ 151, sheet.getY()+437);
		basic_BLabel.setSize(basic_BLabel.getPreferredSize());
		add(basic_BLabel);
		
		EditableLabel basic_BFLabel = new EditableLabel("basic_BF",this, new JLabel(String.valueOf(character.getBasicProfil().get("BF")))     );
		basic_BFLabel.setLocation(sheet.getX()+ 182, sheet.getY()+437);
		basic_BFLabel.setSize(basic_BFLabel.getPreferredSize());
		add(basic_BFLabel);
		
		EditableLabel basic_BELabel = new EditableLabel("basic_BE",this, new JLabel(String.valueOf(character.getBasicProfil().get("BE")))     );
		basic_BELabel.setLocation(sheet.getX()+ 214, sheet.getY()+437);
		basic_BELabel.setSize(basic_BELabel.getPreferredSize());
		add(basic_BELabel);
		
		EditableLabel basic_MLabel = new EditableLabel("basic_M",this, new JLabel(String.valueOf(character.getBasicProfil().get("M")))     );
		basic_MLabel.setLocation(sheet.getX()+ 246, sheet.getY()+437);
		basic_MLabel.setSize(basic_MLabel.getPreferredSize());
		add(basic_MLabel);
		
		EditableLabel basic_MagLabel = new EditableLabel("basic_Mag",this, new JLabel(String.valueOf(character.getBasicProfil().get("Mag")))     );
		basic_MagLabel.setLocation(sheet.getX()+ 278, sheet.getY()+437);
		basic_MagLabel.setSize(basic_MagLabel.getPreferredSize());
		add(basic_MagLabel);
		
		EditableLabel basic_PFLabel = new EditableLabel("basic_PF",this, new JLabel(String.valueOf(character.getBasicProfil().get("PF")))     );
		basic_PFLabel.setLocation(sheet.getX()+ 310, sheet.getY()+437);
		basic_PFLabel.setSize(basic_PFLabel.getPreferredSize());
		add(basic_PFLabel);
		
		EditableLabel basic_PDLabel = new EditableLabel("basic_PD",this, new JLabel(String.valueOf(character.getBasicProfil().get("PD")))     );
		basic_PDLabel.setLocation(sheet.getX()+ 342, sheet.getY()+437);
		basic_PDLabel.setSize(basic_PDLabel.getPreferredSize());
		add(basic_PDLabel);
		
		
		/*Current profil*/
		EditableLabel current_CCLabel = new EditableLabel("current_CC",this, new JLabel(String.valueOf(character.getCurrentProfil().get("CC")))     );
		current_CCLabel.setLocation(sheet.getX()+ 120, sheet.getY()+385);
		current_CCLabel.setSize(current_CCLabel.getPreferredSize());
		add(current_CCLabel);
		
		EditableLabel current_CTLabel = new EditableLabel("current_CT",this, new JLabel(String.valueOf(character.getCurrentProfil().get("CT")))     );
		current_CTLabel.setLocation(sheet.getX()+ 151, sheet.getY()+385);
		current_CTLabel.setSize(current_CTLabel.getPreferredSize());
		add(current_CTLabel);
		
		EditableLabel current_FLabel = new EditableLabel("current_F",this, new JLabel(String.valueOf(character.getCurrentProfil().get("F")))     );
		current_FLabel.setLocation(sheet.getX()+ 182, sheet.getY()+385);
		current_FLabel.setSize(current_FLabel.getPreferredSize());
		add(current_FLabel);
		
		EditableLabel current_ELabel = new EditableLabel("current_E",this, new JLabel(String.valueOf(character.getCurrentProfil().get("E")))     );
		current_ELabel.setLocation(sheet.getX()+ 214, sheet.getY()+385);
		current_ELabel.setSize(current_ELabel.getPreferredSize());
		add(current_ELabel);
		
		EditableLabel current_AgLabel = new EditableLabel("current_Ag",this, new JLabel(String.valueOf(character.getCurrentProfil().get("Ag")))     );
		current_AgLabel.setLocation(sheet.getX()+ 246, sheet.getY()+385);
		current_AgLabel.setSize(current_AgLabel.getPreferredSize());
		add(current_AgLabel);
		
		EditableLabel current_IntLabel = new EditableLabel("current_Int",this, new JLabel(String.valueOf(character.getCurrentProfil().get("Int")))     );
		current_IntLabel.setLocation(sheet.getX()+ 278, sheet.getY()+385);
		current_IntLabel.setSize(current_IntLabel.getPreferredSize());
		add(current_IntLabel);
		
		EditableLabel current_FMLabel = new EditableLabel("current_FM",this, new JLabel(String.valueOf(character.getCurrentProfil().get("FM")))     );
		current_FMLabel.setLocation(sheet.getX()+ 310, sheet.getY()+385);
		current_FMLabel.setSize(current_FMLabel.getPreferredSize());
		add(current_FMLabel);
		
		EditableLabel current_SocLabel = new EditableLabel("current_Soc",this, new JLabel(String.valueOf(character.getCurrentProfil().get("Soc")))     );
		current_SocLabel.setLocation(sheet.getX()+ 342, sheet.getY()+385);
		current_SocLabel.setSize(current_SocLabel.getPreferredSize());
		add(current_SocLabel);
		
		/*------------------*/
		EditableLabel current_ALabel = new EditableLabel("current_A",this, new JLabel(String.valueOf(character.getCurrentProfil().get("A")))     );
		current_ALabel.setLocation(sheet.getX()+ 120, sheet.getY()+470);
		current_ALabel.setSize(current_ALabel.getPreferredSize());
		add(current_ALabel);
		
		EditableLabel current_BLabel = new EditableLabel("current_B",this, new JLabel(String.valueOf(character.getCurrentProfil().get("B")))     );
		current_BLabel.setLocation(sheet.getX()+ 151, sheet.getY()+470);
		current_BLabel.setSize(current_BLabel.getPreferredSize());
		add(current_BLabel);
		
		EditableLabel current_BFLabel = new EditableLabel("current_BF",this, new JLabel(String.valueOf(character.getCurrentProfil().get("BF")))     );
		current_BFLabel.setLocation(sheet.getX()+ 182, sheet.getY()+470);
		current_BFLabel.setSize(current_BFLabel.getPreferredSize());
		add(current_BFLabel);
		
		EditableLabel current_BELabel = new EditableLabel("current_BE",this, new JLabel(String.valueOf(character.getCurrentProfil().get("BE")))     );
		current_BELabel.setLocation(sheet.getX()+ 214, sheet.getY()+470);
		current_BELabel.setSize(current_BELabel.getPreferredSize());
		add(current_BELabel);
		
		EditableLabel current_MLabel = new EditableLabel("current_M",this, new JLabel(String.valueOf(character.getCurrentProfil().get("M")))     );
		current_MLabel.setLocation(sheet.getX()+ 246, sheet.getY()+470);
		current_MLabel.setSize(current_MLabel.getPreferredSize());
		add(current_MLabel);
		
		EditableLabel current_MagLabel = new EditableLabel("current_Mag",this, new JLabel(String.valueOf(character.getCurrentProfil().get("Mag")))     );
		current_MagLabel.setLocation(sheet.getX()+ 278, sheet.getY()+470);
		current_MagLabel.setSize(current_MagLabel.getPreferredSize());
		add(current_MagLabel);
		
		EditableLabel current_PFLabel = new EditableLabel("current_PF",this, new JLabel(String.valueOf(character.getCurrentProfil().get("PF")))     );
		current_PFLabel.setLocation(sheet.getX()+ 310, sheet.getY()+470);
		current_PFLabel.setSize(current_PFLabel.getPreferredSize());
		add(current_PFLabel);
		
		EditableLabel current_PDLabel = new EditableLabel("current_PD",this, new JLabel(String.valueOf(character.getCurrentProfil().get("PD")))     );
		current_PDLabel.setLocation(sheet.getX()+ 342, sheet.getY()+470);
		current_PDLabel.setSize(current_PDLabel.getPreferredSize());
		add(current_PDLabel);

		
		
		sheet.setLocation(0, 0);
		sheet.setSize(sheet.getPreferredSize());
		add(sheet);

	//	add(new JLabel(character.toString()));
		setSize((int) sheet.getPreferredSize().getWidth(),(int) (sheet.getPreferredSize().getHeight()+20));
	
		
		
	}
	
	/*an editable label is a lablel use to display a character's attribute, if the user click on the label he can directly modidy the attribute */
	private class EditableLabel extends JPanel implements MouseListener, KeyListener
	{
		/*attributes*/
		JComponent content;
		JPanel originalPanel;
		String attributeName;
		
		/*Methods*/
		 public EditableLabel( String _attributeName,JPanel _originalPanel , JComponent _content) {
			 attributeName=_attributeName;
			 originalPanel = _originalPanel;
			 content = _content;
			 add(content);
			 addMouseListener(this);		
			 setSize(getPreferredSize());
			 setBackground(new Color(0, 0, 0, 0));
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(content instanceof JLabel)
			{
				remove(content);
				content = new JTextField(((JLabel)content).getText());
				 content.addKeyListener(this);
				add(content);

					if (attributeName.equals("height") || attributeName.equals("weight") || attributeName.equals("age") || attributeName.equals("broAndSis"))
					{
						NumberFormat format = NumberFormat.getInstance();
					    NumberFormatter formatter = new NumberFormatter(format);
					    formatter.setValueClass(Integer.class);
					    formatter.setMinimum(0);
					    formatter.setMaximum(Integer.MAX_VALUE);
					    // If you want the value to be committed on each keystroke instead of focus lost
					    formatter.setCommitsOnValidEdit(true);
					    remove(content);
					   String temp = ((JTextField)content).getText();
					   content = new JFormattedTextField(formatter);
					   ((JFormattedTextField)content).setText(temp);
					   ((JFormattedTextField)content).setColumns(5);
					   content.addKeyListener(this);
					   add(content);
					}else if (attributeName.contains("basic_") || attributeName.contains("current_"))
					{
						NumberFormat format = NumberFormat.getInstance();
					    NumberFormatter formatter = new NumberFormatter(format);
					    formatter.setValueClass(Integer.class);
					    formatter.setMinimum(0);
					    formatter.setMaximum(99);
					    // If you want the value to be committed on each keystroke instead of focus lost
					    formatter.setCommitsOnValidEdit(true);
					    remove(content);
					   String temp = ((JTextField)content).getText();
					   content = new JFormattedTextField(formatter);
					   ((JFormattedTextField)content).setText(temp);
					   ((JFormattedTextField)content).setColumns(2);
					   content.addKeyListener(this);
					   add(content);
					}
				
			}
			content.setSize(content.getPreferredSize());
			setSize(getPreferredSize());
			content.repaint();
			originalPanel.repaint();
			originalframe.validate();
			originalframe.repaint();
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			//do nothing
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			//do nothing
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			//do nothing
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			//do nothing			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if((content instanceof JTextField  && !(content instanceof JFormattedTextField) && ((Character)(e.getKeyChar())).hashCode() == KeyEvent.VK_ENTER) || ( content instanceof JFormattedTextField && ((JFormattedTextField)content).isEditValid() && ((Character)(e.getKeyChar())).hashCode() == KeyEvent.VK_ENTER ))
			{
				remove(content);
				
				if (content instanceof JFormattedTextField )
				{
			
					content = new JLabel(   (((JFormattedTextField)content).getValue()).toString()  );
					
				}else if(content instanceof JTextField )
				{
					content = new JLabel(((JTextField)content).getText());
					
				}
				add(content);

				
				/*register the new attribute value (with a very disgusting switch)*/
				if(attributeName.equals("name"))
						{
							character.setName(((JLabel)content).getText());
						}else if(attributeName.equals("race")){
							
							character.setRace(new Race(((JLabel)content).getText()));
						}else if(attributeName.equals("currentCareer")){
							
							character.setCurrentCareer(new Career(((JLabel)content).getText()));
						}else if(attributeName.equals("age")){
							
							character.setAge(Integer.parseInt(((JLabel)content).getText()));
						}else if(attributeName.equals("eyeColor")){
							
							character.setEyesColor(((JLabel)content).getText());
						}else if(attributeName.equals("hairColor")){
							
							character.setHairColor(((JLabel)content).getText());
						}else if(attributeName.equals("astralSign")){
							
							character.setAstralSign(((JLabel)content).getText());
						}else if(attributeName.equals("sex")){
							character.setSex( (((JLabel)content).getText().charAt(0)) );
							remove(content);
						   content = new JLabel(String.valueOf(  ((JLabel)content).getText().charAt(0))  );
							add(content);

						}else if(attributeName.equals("height")){
							character.setHeigth(Integer.parseInt(((JLabel)content).getText()));
							
						}else if(attributeName.equals("weight")){
							character.setWeigth(Integer.parseInt(((JLabel)content).getText()));
	
						}else if(attributeName.equals("broAndSis")){
							character.setBrotherAndSisterAmount(Integer.parseInt(((JLabel)content).getText()));
							
						}else if(attributeName.equals("nativeLand")){
							character.setNativeLand(((JLabel)content).getText());
							
						}else if(attributeName.equals("distinctSign")){
							character.setNativeLand(((JLabel)content).getText());
							
						}else if(attributeName.contains("basic_") || attributeName.contains("current_")){
							character.getBasicProfil().set(attributeName.substring(attributeName.length() - 2),
											Integer.parseInt(((JLabel)content).getText()));
						}
				
				
				
			}
			content.setSize(content.getPreferredSize());
			setSize(getPreferredSize());
			originalPanel.repaint();
			originalframe.validate();
			originalframe.repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			//do nothing			
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			//do nothing			
		}
		
	}

	

}
