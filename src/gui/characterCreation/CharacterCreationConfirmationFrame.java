/*This Frame is used to allow the user to confirm the creation a character and to give it a category
 * The Users may select one or more categories in a list and/or add categories by writing in a text field*/
package gui.characterCreation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import toolBox.CharacterCreationModule;
import warhammerCharacter.WarhammerCharacter;

public class CharacterCreationConfirmationFrame extends JFrame{

	/*Attributes*/
	private static final long serialVersionUID = -3065801570560242066L;
	protected CharacterCreationModule module;
	protected ArrayList<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();
	protected ArrayList<JLabel> categoryLabelList = new ArrayList<JLabel>();
	protected ArrayList<FrameLabel> deleteCategoryLabelList = new ArrayList<FrameLabel>();
	
	protected FrameTextField addCategorytextfield = new FrameTextField(this);
	protected JPanel categoryPanel;
	
	protected JFrame originalFrame;
	
	
	/*Methods*/
	public CharacterCreationConfirmationFrame(JFrame _originalFrame,CharacterCreationModule _module)
	{
		module = _module;
		setTitle("Definir une catégorie");
		setSize(600,400);
		setResizable(false);
		createFrame();
		originalFrame = _originalFrame;
		originalFrame.setEnabled(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		originalFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setAlwaysOnTop(true);
	}


	/*The frame use no layout because all layouts suck */
	private void createFrame() {
		getContentPane().removeAll();
		getContentPane().setLayout(null); // You can't handle this bitch 
		
		/*description*/
		JLabel description = new JLabel("Souhaitez vous lier le personnage à une ou plusieurs catégories?");
		description.setBounds(50, 40, description.getPreferredSize().width, description.getPreferredSize().height);
		add(description);
		
		/*list of categories*/
		categoryPanel = new JPanel();
		categoryPanel.setLayout(null); //Because I have balls
		int xOffset = 5;
		int yOffset = 5;
		int categoryPanelWidth = 350;
		int categoryPanelHeigth = 200;
		categoryLabelList = new ArrayList<JLabel>();
		checkBoxList = new ArrayList<JCheckBox>();
		deleteCategoryLabelList = new ArrayList<FrameLabel>();
		for(int i = 0 ; i < module.getCategoriesList().size() ; ++i)
		{
			/*check box*/
			checkBoxList.add(new JCheckBox());
			checkBoxList.get(i).setBounds(xOffset,
										  yOffset + i*(yOffset+checkBoxList.get(i).getPreferredSize().height),
										  checkBoxList.get(i).getPreferredSize().width,
										  checkBoxList.get(i).getPreferredSize().height);
			categoryPanel.add(checkBoxList.get(i));
			
			/*categories*/
			categoryLabelList.add(new JLabel(module.getCategoriesList().get(i)));
			categoryLabelList.get(i).setBounds(xOffset*2 + checkBoxList.get(i).getPreferredSize().width,
												yOffset + i*(yOffset+checkBoxList.get(i).getPreferredSize().height) + 2,
												categoryLabelList.get(i).getPreferredSize().width,
												categoryLabelList.get(i).getPreferredSize().height);
			categoryPanel.add(categoryLabelList.get(i));
			
			/*delete buttons*/
			deleteCategoryLabelList.add(new FrameLabel("x",this,i));
			deleteCategoryLabelList.get(i).setBounds(   categoryPanelWidth - 30,
														yOffset + i*(yOffset+checkBoxList.get(i).getPreferredSize().height) + 2,
														deleteCategoryLabelList.get(i).getPreferredSize().width,
														deleteCategoryLabelList.get(i).getPreferredSize().height);
			categoryPanel.add(deleteCategoryLabelList.get(i));
		}
		if(module.getCategoriesList().size() > 0)
		{
			categoryPanel.setPreferredSize(new Dimension(categoryPanelWidth - 20,
														yOffset + module.getCategoriesList().size()*(yOffset+checkBoxList.get(0).getPreferredSize().height)));
		}else{
			
			JLabel noCategoryLabel = new JLabel("<html> <i> aucune categorie définie</i></html>");
			noCategoryLabel.setLocation(xOffset, yOffset);
			noCategoryLabel.setSize(noCategoryLabel.getPreferredSize());
			categoryPanel.add(noCategoryLabel);
		}
		
		JScrollPane categoryScrollPane = new JScrollPane(categoryPanel);	
		categoryScrollPane.setBounds((getSize().width - categoryPanelWidth)/2,
									 60 +description.getBounds().height,
									 categoryPanelWidth,
									 categoryPanelHeigth);
		add(categoryScrollPane);

		
		/*Text field to add categories*/
		addCategorytextfield = new FrameTextField(this);
		addCategorytextfield.setBounds(	(getSize().width - categoryPanelWidth)/2,
										categoryScrollPane.getY() + categoryPanelHeigth + 15,
										200,
										addCategorytextfield.getPreferredSize().height);
		add(addCategorytextfield);
		
		/*the button to add the category written in the JTextfield*/
		FrameButton addCategoryButton = new FrameButton("Ajouter",this);
		addCategoryButton.setBounds(addCategorytextfield.getX()+ addCategorytextfield.getWidth() + 20,
									addCategorytextfield.getY() + addCategorytextfield.getHeight()/2 - addCategoryButton.getPreferredSize().height/2,
									addCategoryButton.getPreferredSize().width,
									addCategoryButton.getPreferredSize().height);
		add(addCategoryButton);
		
		/*validation button*/
		FrameButton OkButton = new FrameButton("Valider",this);
		OkButton.setBounds(getWidth() - OkButton.getPreferredSize().width - 15,
							getHeight() - OkButton.getPreferredSize().height*2 - 15,
							OkButton.getPreferredSize().width,
							OkButton.getPreferredSize().height);
		
		add(OkButton);
		
		/*cancelButton*/
		FrameButton cancelButton = new FrameButton("Retour",this);
		cancelButton.setBounds(getWidth() - cancelButton.getPreferredSize().width - 30 - OkButton.getPreferredSize().width,
							getHeight() - cancelButton.getPreferredSize().height*2 -15,
							cancelButton.getPreferredSize().width,
							cancelButton.getPreferredSize().height);
		
		add(cancelButton);
		
		/*Create interactions between components*/
		
		/*The cancel button close the frame*/
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((FrameButton)e.getSource()).originalFrame.dispose();	
			}
		});
		
		/*The add button add a category*/
		addCategoryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!module.getCategoriesList().contains( ((FrameButton)e.getSource()).originalFrame.addCategorytextfield.getText() ))
				{
					//A category can't begin with a space character or contains nothing
					if(!((FrameButton)e.getSource()).originalFrame.addCategorytextfield.getText().startsWith(" ")
							&&!((FrameButton)e.getSource()).originalFrame.addCategorytextfield.getText().equals(""))
					{
					module.addCategory(((FrameButton)e.getSource()).originalFrame.addCategorytextfield.getText());
					((FrameButton)e.getSource()).originalFrame.createFrame();
					}
				}
				
			}
		});
		
		/*The OK button save the selected categories and close the window*/
		OkButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				toolBox.Character curCharacter = ((FrameButton)e.getSource()).originalFrame.module.getCurrentCharacter();
				
				//((CharacterCreationModule)((FrameButton)e.getSource()).originalFrame.module).getCurrentCharacter().removeCategories();
				((FrameButton)e.getSource()).originalFrame.module.newCharacter();
				for(int i = 0; i < ((FrameButton)e.getSource()).originalFrame.checkBoxList.size() ; ++i )
				{
					if(((FrameButton)e.getSource()).originalFrame.checkBoxList.get(i).isSelected())
					{
						curCharacter.addCategory(   ((FrameButton)e.getSource()).originalFrame.module.getCategoriesList().get(i));
					}
				}
				
				//((FrameButton)e.getSource()).originalFrame.module.getCurrentCharacter().saveAsXml();
				/*Serialize the character*/
				FileOutputStream fos;
				try {
					String name = curCharacter.getModule().getFilesPath()+ ((WarhammerCharacter)curCharacter).getName();
					for(String car : curCharacter.getCategories())
					{
						name += ";";
						name += car;
					}
					fos = new FileOutputStream(name);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				//	oos.writeObject(((FrameButton)e.getSource()).originalFrame.module.getCurrentCharacter());
					oos.writeObject(curCharacter);
					oos.flush();
					oos.close();
					fos.close();
				}catch(Exception ioe)
				{
					ioe.printStackTrace();
				}
				
				
				((FrameButton)e.getSource()).originalFrame.originalFrame.setEnabled(true);
				((FrameButton)e.getSource()).originalFrame.dispose();
				
			}
		});
		
		/*The delete category labels allow to delete the concern category*/
		
		for(int i = 0 ; i < deleteCategoryLabelList.size() ; ++i)
		{
			deleteCategoryLabelList.get(i).addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// do nothing
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// do nothing
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					((FrameLabel)e.getSource()).originalFrame.deleteCategoryLabelList.get(((FrameLabel)e.getSource()).index).setForeground(Color.BLACK);
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					((FrameLabel)e.getSource()).originalFrame.deleteCategoryLabelList.get(((FrameLabel)e.getSource()).index).setForeground(Color.RED);
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					((FrameLabel)e.getSource()).originalFrame.deleteCategory( ((FrameLabel)e.getSource()).index );
				}
			});
			
		}
		
		/*A listener allow the user to press "enter" when writing a category to add it */
		
		addCategorytextfield.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent ke) {
				if(((Character)(ke.getKeyChar())).hashCode() == KeyEvent.VK_ENTER
						&&  ! ((FrameTextField)(ke.getSource())).getText().equals("")
						&& !((FrameTextField)ke.getSource()).originalFrame.addCategorytextfield.getText().startsWith(" ")
						&& !((FrameTextField)ke.getSource()).originalFrame.addCategorytextfield.getText().equals("")
						&& !module.getCategoriesList().contains( ((FrameTextField)ke.getSource()).originalFrame.addCategorytextfield.getText() ))
				{
					module.addCategory(((FrameTextField)ke.getSource()).originalFrame.addCategorytextfield.getText());
					((FrameTextField)ke.getSource()).originalFrame.createFrame();
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// do  nothing
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// do nothing
				
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void  windowClosing(WindowEvent e)
			{
				originalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				originalFrame.setEnabled(true); 
			}
		
		});
		
		getContentPane().revalidate();
		getContentPane().repaint();
		repaint();
	
	}
	
	public void dispose(){
		originalFrame.setEnabled(true);
		originalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.dispose();
		
	}
	
	protected void deleteCategory(int index) {
		
		module.deleteCategory(index);
		createFrame();
		
	}

	private class FrameButton extends JButton
	{
		private static final long serialVersionUID = -1079273765278157078L;
		public CharacterCreationConfirmationFrame originalFrame;
		
		public FrameButton(String str,CharacterCreationConfirmationFrame _originalFrame)
		{
			super(str);
			originalFrame = _originalFrame;
		}
	}
	
	private class FrameLabel extends JLabel
	{

		private static final long serialVersionUID = 8051356833660612196L;
		public CharacterCreationConfirmationFrame originalFrame;
		public int index = -1;
		
		/*public FrameLabel(String str,CharacterCreationConfirmationFrame _originalFrame)
		{
			super(str);
			originalFrame = _originalFrame;
		}*/
		
		public FrameLabel(String str, CharacterCreationConfirmationFrame _origialFrame, int _index)
		{
			super(str);
			originalFrame = _origialFrame;
			index = _index;
		}
	}
	
	private class FrameTextField extends JTextField
	{
		
		private static final long serialVersionUID = 8051356833660612196L;
		public CharacterCreationConfirmationFrame originalFrame;
		
		public FrameTextField(CharacterCreationConfirmationFrame _originalframe)
		{
			super();
			originalFrame = _originalframe;
		}
		
	}
	

}
