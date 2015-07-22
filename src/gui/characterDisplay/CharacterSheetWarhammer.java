/*This class represent the warhammer character sheet, it sum up every character details and each of them may be directly modify*/
package gui.characterDisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
			if(content instanceof JTextField && ((Character)(e.getKeyChar())).hashCode() == KeyEvent.VK_ENTER)
			{
				remove(content);
				content = new JLabel(((JTextField)content).getText());
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
