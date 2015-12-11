/*This class represent the warhammer character sheet, it sum up every character details and each of them may be directly modify*/
package gui.characterDisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import warhammerCharacter.WarhammerCharacter;

public class CharacterSheetWarhammer extends CharacterSheet {

	/*attributes*/
	private static final long serialVersionUID = 3637174654061296591L;
	protected WarhammerCharacter character;
	protected JLabel sheet;
	protected int pageNumber;
	protected static final int pageMax = 2;

	/*Methods*/
	public CharacterSheetWarhammer(CharacterSheetFrame _originalFrame, WarhammerCharacter cha) {
		originalframe = _originalFrame;
	
		character = cha;
		ImageIcon characterSheetImage = new ImageIcon("./RPG/Warhammer/fichePerso.png");
		setSize(new Dimension(characterSheetImage.getIconWidth(),characterSheetImage.getIconHeight()));
		setPreferredSize(getSize());
		sheet = new JLabel(characterSheetImage);
		setPreferredSize(new Dimension(characterSheetImage.getIconWidth(),characterSheetImage.getIconHeight()));
		pageNumber = 1;
		originalframe.setSheet(this);
		createSheet();
	}
	
	/*draw the arrows need to change the page*/
/*	protected void drawArrows()
	{
		ArrowLabel rightArrowLabel = new ArrowLabel();
		rightArrowLabel.setBounds(sheet.getPreferredSize().width - 70, 20,
									rightArrowLabel.getPreferredSize().width, rightArrowLabel.getPreferredSize().height);
		
		add(rightArrowLabel);
		
		ArrowLabel leftArrowLabel = new ArrowLabel();
		leftArrowLabel.switchLeft();
		leftArrowLabel.setBounds(70 - leftArrowLabel.getPreferredSize().width, 20,
									leftArrowLabel.getPreferredSize().width, leftArrowLabel.getPreferredSize().height);
		
		add(leftArrowLabel);
	}*/
	
	
	@Override
	protected void createSheet() {
		setLayout(null);

		/*positioning the attributes*/
		
		/*Name*/
		createEditableLabel("name", 85, 80);
		createEditableLabel("race", 85, 95);
		createEditableLabel("currentCareer", 130, 110);
		createEditableLabel("age", 80, 183);
		createEditableLabel("eyeColor", 133, 198);
		createEditableLabel("hairColor", 145, 213);
		createEditableLabel("astralSign", 105, 228);
		createEditableLabel("sex", 245, 183);
		createEditableLabel("height", 242, 198);
		createEditableLabel("Weight", 242, 214);
		createEditableLabel("brotherAndSisterAmount", 322, 229);
		createEditableLabel("nativeLand", 140, 245);
		createEditableLabel("distinctSign", 140, 260);
		createEditableLabel("basic_CC", 120, 350);
		createEditableLabel("basic_CT", 151, 350);
		createEditableLabel("basic_F", 182, 350);
		createEditableLabel("basic_E", 214, 350);
		createEditableLabel("basic_Ag", 246, 350);
		createEditableLabel("basic_Int", 278, 350);
		createEditableLabel("basic_FM", 310, 350);
		createEditableLabel("basic_Soc", 342, 350);
		createEditableLabel("basic_A", 120, 435);
		createEditableLabel("basic_B", 151, 435);
		createEditableLabel("basic_BF", 182, 435);
		createEditableLabel("basic_BE", 214, 435);
		createEditableLabel("basic_M", 246, 435);
		createEditableLabel("basic_Mag", 278, 435);
		createEditableLabel("basic_PF", 310, 435);
		createEditableLabel("basic_PD", 342, 435);
		createEditableLabel("current_CC", 120, 385);
		createEditableLabel("current_CT", 151, 385);
		createEditableLabel("current_F", 182, 385);
		createEditableLabel("current_E", 214, 385);
		createEditableLabel("current_Ag", 246, 385);
		createEditableLabel("current_Int", 278, 385);
		createEditableLabel("current_FM", 310, 385);
		createEditableLabel("current_Soc", 342, 385);
		createEditableLabel("current_A", 120, 470);
		createEditableLabel("current_B", 151, 470);
		createEditableLabel("current_BF", 182, 470);
		createEditableLabel("current_BE", 214, 470);
		createEditableLabel("current_M", 246, 470);
		createEditableLabel("current_Mag", 278, 470);
		createEditableLabel("current_PF", 310, 470);
		createEditableLabel("current_PD", 342, 470);
		
		//drawArrows();
		
		sheet.setLocation(0, 0);
		sheet.setSize(sheet.getPreferredSize());
		add(sheet);

	//	add(new JLabel(character.toString()));
		setSize((int) sheet.getPreferredSize().getWidth(),(int) (sheet.getPreferredSize().getHeight()+20));	
		
	}
	
	private void createEditableLabel(String attributeName, int x, int y )
	{
		EditableLabel label = new EditableLabel(attributeName, this, new JLabel(character.getAttributeString(attributeName)));
		label.setLocation(sheet.getX() + x, sheet.getY() + y);
		label.setSize(label.getPreferredSize());
		add(label);
	}
	
	/*an editable label is a lablel use to display a character's attribute, if the user click on the label he can directly modidy the attribute */
	private class EditableLabel extends JPanel implements MouseListener, KeyListener, FocusListener
	{

		private static final long serialVersionUID = -8810040371147390711L;
		/*attributes*/
		JComponent content;
		JPanel originalPanel;
		String attributeName;
		JLabel formerLabel = new JLabel();
		
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
				formerLabel = (JLabel) content;
				content = new JTextField(((JLabel)content).getText());
				
				content.addKeyListener(this);
				content.addFocusListener(this);
				add(content);
				((JTextField)content).requestFocus();
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
					   ((JFormattedTextField)content).requestFocus();
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
					   ((JFormattedTextField)content).requestFocus();
					}
				
			}
			content.setSize(content.getPreferredSize());
			setSize(getPreferredSize());
			content.repaint();
			originalPanel.repaint();
			originalframe.validate();
           // originalframe.repaint();
			
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
			if((content instanceof JTextField  && !(content instanceof JFormattedTextField) && ((Character)(e.getKeyChar())).hashCode() == KeyEvent.VK_ENTER)
					|| ( content instanceof JFormattedTextField && ((JFormattedTextField)content).isEditValid() && ((Character)(e.getKeyChar())).hashCode() == KeyEvent.VK_ENTER ))
			{
                if(((JTextField)content).getText().equals("")){
					JOptionPane.showMessageDialog(this, "Le champ ne peut �tre vide","Champs vide", JOptionPane.WARNING_MESSAGE);
				}else{
					
					
					remove(content);
					
					if (content instanceof JFormattedTextField )
					{			
						content = new JLabel(   (((JFormattedTextField)content).getValue()).toString()  );						
					}else if(content instanceof JTextField )
					{
						content = new JLabel(((JTextField)content).getText());
					}
					add(content);
	
					
					/*register the new attribute value */
					character.setAttribute(attributeName, ((JLabel)content).getText());
					
					/*if(attributeName.equals("name"))
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
							}*/

                    content.setSize(content.getPreferredSize());
                    setSize(getPreferredSize());
                    originalPanel.repaint();
		        	originalframe.validate();
		        	originalframe.repaint();
				}	
			}
			content.setSize(content.getPreferredSize());
			setSize(getPreferredSize());
			originalPanel.repaint();
			/*originalframe.validate();
			originalframe.repaint();*/
		}

		@Override
		public void keyReleased(KeyEvent e) {
			//do nothing			
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			//do nothing			
		}

		@Override
		public void focusGained(FocusEvent arg0) {
			// do nothing
			
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			if (!(content instanceof JLabel))
			{
			remove(content);
			content = formerLabel;
			add(content);
			repaint();
			}
		}
		
	}
	/*Class used to create the arrow label needed to change the pages*/
/*	public class ArrowLabel extends JLabel
	{

		private static final long serialVersionUID = -8754630727746339583L;

		public ArrowLabel()
		{
			super(new ImageIcon("./img/arrow_right.png"));
		}
		
		public void  switchLeft()
		{
			setIcon(new ImageIcon("./img/arrow_left.png"));
		}
		
		public void switchRight()
		{
			setIcon(new ImageIcon("./img/arrow_right.png"));
		}
	}*/

}
