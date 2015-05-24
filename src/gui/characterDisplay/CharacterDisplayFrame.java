/*This frame is launched when the user use the  character display mode, it present the characters register 
 * in the file RPG/Characters*/
package gui.characterDisplay;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import toolBox.Module;
import warhammerCharacter.WarhammerCharacter;

public class CharacterDisplayFrame extends JFrame{

	/*Attributes*/
	private static final long serialVersionUID = 7194591707991306732L;
	protected Dimension screenDimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	protected static Module module;
	protected static final File rpgFile = new File("./RPG/");
	protected JComboBox<String> rpgSelectionComboBox;
	/*GUI elements*/
	
	
	/*Methods*/
	public CharacterDisplayFrame(Module _module) {
		module = _module;
		setSize((int)screenDimension.getWidth()/2, (int)(screenDimension.getHeight()*0.9));
		setResizable(true);
		setLayout(null);
		createFrame();
	}

	/*create and place the frame elements*/
	private void createFrame() {
		getContentPane().removeAll();
		getContentPane().setLayout(null);
		
		/*rpg selection*/
		rpgSelectionComboBox = new JComboBox<String>();
		for(File f : rpgFile.listFiles())
		{
			rpgSelectionComboBox.addItem(f.getName());
		}
		rpgSelectionComboBox.setBounds((getWidth() - rpgSelectionComboBox.getPreferredSize().width)/2,
										getHeight()/50,
										rpgSelectionComboBox.getPreferredSize().width,
										rpgSelectionComboBox.getPreferredSize().height);
		add(rpgSelectionComboBox);
		
		displayCharacters();
		
	}

	/*create the panel which display the character of the selected RPG*/
	private void displayCharacters() {		
		
		JPanel characterPanel = new JPanel();
		characterPanel.setLayout(null);
		int i = 0;
		CharacterLabel charLabel = new CharacterLabel();
		for(File f : (new File(rpgFile.getName() + "/" + rpgSelectionComboBox.getSelectedItem() + "/Characters")).listFiles())
		{
			charLabel = new CharacterLabel(f);
			charLabel.setBounds(10,
								charLabel.getPreferredSize().height*(1 + 2*i) ,
								charLabel.getPreferredSize().width,
								charLabel.getPreferredSize().height);
			
			characterPanel.add(charLabel);
			++i;
		}
		characterPanel.setPreferredSize(new Dimension(	getWidth()*9/10,
														charLabel.getPreferredSize().height*(3 + 2*i)));
		JScrollPane characterScrollPanel = new JScrollPane(characterPanel);
		characterScrollPanel.setBounds(getWidth()/20,
										getHeight()/25 + rpgSelectionComboBox.getPreferredSize().height,
										characterPanel.getPreferredSize().width,
										(getHeight() - getHeight()/25 + rpgSelectionComboBox.getPreferredSize().height)*9/10 );
		add(characterScrollPanel);
		
	}
	
	public void repaint()
	{
		super.repaint();
		displayCharacters();
	}
	
	/*This class is used to determine the name label behavior*/
	public class CharacterLabel extends JLabel implements MouseListener
	{
		
		private static final long serialVersionUID = -3736379588180399451L;
		private String text = "";
		private File characterFile;
		
		public CharacterLabel( File file) {
			super(file.getName());
			text = file.getName();
			characterFile = file;
			addMouseListener(this);
		}		
		
		public CharacterLabel()
		{
			super();
			addMouseListener(this);
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			JFrame characterSheetFrame = new JFrame();
			
			if(characterFile.exists())
			{
				try {
				FileInputStream fis = new FileInputStream(characterFile);
				ObjectInputStream ois = new ObjectInputStream(fis);
					try {
						WarhammerCharacter cha = (WarhammerCharacter) ois.readObject();
						ois.close();
						
						characterSheetFrame.add(new CharacterSheetWarhammer(cha));
						characterSheetFrame.setSize(new Dimension(characterSheetFrame.getPreferredSize().width,
																	characterSheetFrame.getPreferredSize().height));
						characterSheetFrame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					fis.close();
					ois.close();
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			setText("<html><u>"+getText()+"</u></html>");
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			setText(text);
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}
		
	}
	
}
