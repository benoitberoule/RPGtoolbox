/*This frame is launched when the user use the  character display mode, it present the characters register 
 * in the file RPG/Characters*/
package gui.characterDisplay;

import toolBox.Module;
import warhammerCharacter.WarhammerCharacter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CharacterDisplayFrame extends JFrame{

	/*Attributes*/
	private static final long serialVersionUID = 7194591707991306732L;
	protected Dimension screenDimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	protected static Module module;
	protected static final File rpgFile = new File("./RPG/");
	protected ArrayList<String> categoryList;
	
	/*GUI elements*/
	protected JPanel characterPanel = new JPanel() ;
	protected JScrollPane characterScrollPanel = new JScrollPane(characterPanel);
	protected JComboBox<String> rpgSelectionComboBox;
	protected JComboBox<String> categorySelectionComboBox;
	
	/*Methods*/
	public CharacterDisplayFrame(Module _module) {
		module = _module;
		setSize((int)screenDimension.getWidth()/2, (int)(screenDimension.getHeight()*0.9));
		setResizable(true);
		setLayout(null);
		createFrame();
	}

	/*create and place the frame elements*/
	@SuppressWarnings("unchecked")
	private void createFrame() {
		getContentPane().removeAll();
		getContentPane().setLayout(null);
		
		/*rpg selection*/
		rpgSelectionComboBox = new JComboBox<String>();
		for(File f : rpgFile.listFiles())
		{
			rpgSelectionComboBox.addItem(f.getName());
		}
		rpgSelectionComboBox.setBounds((getWidth() - rpgSelectionComboBox.getPreferredSize().width)/4,
										getHeight()/50,
										rpgSelectionComboBox.getPreferredSize().width,
										rpgSelectionComboBox.getPreferredSize().height);
		
		/*category selection*/
		categorySelectionComboBox = new JComboBox<String>();

		categorySelectionComboBox.addItem("Toutes");
		
		
		File file = new File(rpgFile.getPath() + "/" + rpgSelectionComboBox.getSelectedItem()+ "/categories");
		if(file.exists())
		{
			try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
				try {
					categoryList = (ArrayList<String>) ois.readObject();
					ois.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		
			for(String str : categoryList)
			{
				categorySelectionComboBox.addItem(str);
			}
		}
		categorySelectionComboBox.setBounds(3*(getWidth() - categorySelectionComboBox.getPreferredSize().width)/4,
										getHeight()/50,
										categorySelectionComboBox.getPreferredSize().width,
										categorySelectionComboBox.getPreferredSize().height);
		
		add(rpgSelectionComboBox);
		
		categorySelectionComboBox.addActionListener(new RefreshListener(this));
		add(categorySelectionComboBox);
	
		repaint();
		
	}

	/*create the panel which display the character of the selected RPG*/
	public void displayCharacters() {		
		getContentPane().remove(characterPanel);
		getContentPane().remove(characterScrollPanel);
		characterPanel.removeAll();
		//characterPanel = new JPanel();
		characterPanel.setLayout(null);
		int i = 0;
		CharacterLabel charLabel = new CharacterLabel();
		for(File f : (new File(rpgFile.getName() + "/" + rpgSelectionComboBox.getSelectedItem() + "/Characters")).listFiles())
		{
			/*Checking the categories*/
			if(categorySelectionComboBox.getSelectedIndex() > 0)
			{
				String selectedCategory = categorySelectionComboBox.getSelectedItem().toString();
				String name = f.getName();
				while(name.contains(";"))
				{
					name = name.substring(name.indexOf(";") + 1);
					if(name.startsWith(selectedCategory + ";" )|| name.equals(selectedCategory) )
					{
						charLabel = new CharacterLabel(f);
						charLabel.setBounds(10,
											charLabel.getPreferredSize().height*(1 + 2*i) ,
											charLabel.getPreferredSize().width,
											charLabel.getPreferredSize().height);
						
						characterPanel.add(charLabel);
						++i;
					}
				}
			}else{
				
			charLabel = new CharacterLabel(f);
			charLabel.setBounds(10,
								charLabel.getPreferredSize().height*(1 + 2*i) ,
								charLabel.getPreferredSize().width,
								charLabel.getPreferredSize().height);
			
			characterPanel.add(charLabel);;
			++i;
			}
		}
		characterPanel.setPreferredSize(new Dimension(	getWidth()*9/10,
														charLabel.getPreferredSize().height*(3 + 2*i)));
		characterScrollPanel.removeAll();
		characterScrollPanel = new JScrollPane(characterPanel);
		characterScrollPanel.setBounds(getWidth()/20,
										getHeight()/25 + rpgSelectionComboBox.getPreferredSize().height,
										characterPanel.getPreferredSize().width,
										(getHeight() - getHeight()/25 + rpgSelectionComboBox.getPreferredSize().height)*9/10 );
		add(characterScrollPanel);
	}
	
	public void repaint()
	{
		displayCharacters();
		super.repaint();
	}
	
	/*This class is used to determine the name label behavior*/
	public class CharacterLabel extends JLabel implements MouseListener
	{
		
		private static final long serialVersionUID = -3736379588180399451L;
		private String text = "";
		private File characterFile;
		
		public CharacterLabel( File file) {		
			super();
			if(file.getName().contains(";"))
			{
				text = file.getName().substring(0,file.getName().indexOf(";"));			
			}else
			{
				text = file.getName();
			}
			
			setText(text);
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
			CharacterSheetFrame characterSheetFrame = new CharacterSheetFrame();
			if(characterFile.exists())
			{
				try {
				FileInputStream fis = new FileInputStream(characterFile);
				ObjectInputStream ois = new ObjectInputStream(fis);
					try {
						WarhammerCharacter cha = (WarhammerCharacter) ois.readObject();
						ois.close();
						CharacterSheetWarhammer csw = new CharacterSheetWarhammer(characterSheetFrame,cha);
						//JScrollPane scrollPane = new JScrollPane(csw);
						//scrollPane.setBounds(0, 0, csw.getWidth(), csw.getHeight());
						//scrollPane.setPreferredSize(csw.getPreferredSize());
						//characterSheetFrame.add(new JScrollPane(csw),BorderLayout.CENTER);
					//	characterSheetFrame.setSize(new Dimension(characterSheetFrame.getPreferredSize().width + 10,
					//												characterSheetFrame.getPreferredSize().height));
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
	
	/*the listener which refresh the displayed character depending on the selected RPG and DeprecatedCategory*/
	public class RefreshListener implements ActionListener
	{
		private CharacterDisplayFrame cdf;
		
		public RefreshListener(CharacterDisplayFrame _cdf)
		{
			cdf = _cdf;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cdf.repaint();
			cdf.revalidate();
		}
		
	}
	
}
