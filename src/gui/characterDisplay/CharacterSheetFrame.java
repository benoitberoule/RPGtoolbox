/*This class is a frame needed to contains the character's sheet panel*/
package gui.characterDisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CharacterSheetFrame extends JFrame{

	/*Attributes*/
	private static final long serialVersionUID = 1L;
	CharacterSheet sheet;

	
	
	/*Methods*/
	
	
	private void build()
	{
		//setLayout(null);
		
		add(new JScrollPane(sheet),BorderLayout.CENTER);
		setSize(new Dimension(sheet.getPreferredSize().width + 10,
													sheet.getPreferredSize().height));
		System.out.println(getSize());
		
		
		drawArrows();
		
		repaint();
		validate();
	}
	
	
	protected void drawArrows()
	{
		JPanel arrowPanel = new JPanel();
		arrowPanel.setLayout(null);
		ArrowLabel rightArrowLabel = new ArrowLabel();
		rightArrowLabel.setBounds(sheet.getPreferredSize().width - 70, 20,
									rightArrowLabel.getPreferredSize().width, rightArrowLabel.getPreferredSize().height);
		
		arrowPanel.add(rightArrowLabel);
		
		ArrowLabel leftArrowLabel = new ArrowLabel();
		leftArrowLabel.switchLeft();
		leftArrowLabel.setBounds(70 - leftArrowLabel.getPreferredSize().width, 20,
									leftArrowLabel.getPreferredSize().width, leftArrowLabel.getPreferredSize().height);
		
		arrowPanel.add(leftArrowLabel);
		arrowPanel.setBackground(new Color(0,0,0,0));
		add(arrowPanel,BorderLayout.CENTER);
	}
	
	/*Getters & setters*/
	public CharacterSheet getSheet() {
		return sheet;
	}
	public void setSheet(CharacterSheet sheet) {
		this.sheet = sheet;
		build();
	}

	
	
	
	
	/*Class used to create the arrow label needed to change the pages*/
	public class ArrowLabel extends JLabel
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
	}
}
