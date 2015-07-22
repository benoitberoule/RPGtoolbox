/*This is the generic frame used to create a character, it may be used for any RPG.
 * To used this frame with a specific RPG an XML file must be write to details all the characteristic of the character and save it in the file CharacterCreation then register the name of the file in the variable "xmlFileName".
 * You can create a specific character creation frame by extending this one and naming it "NameOfTheGameChareacterCreationFrame.java",
 * it's file may contains Strings,int,char,selectable,StringList and table*/
package gui.characterCreation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;




import toolBox.CharacterCreationModule;

public class CharacterCreationFrame extends JFrame {
	
	/*Attributes*/
	private static final long serialVersionUID = -4012986214616489462L;
	protected Dimension screenDimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	protected CharacterCreationModule module;
	protected String xmlFilePath;
	protected Hashtable<String, Object> characterAttributeComponentTable; // Use to register the values given by the user via the GUI
	protected ArrayList<String> mandatoryCharacterAttributeComponentTable; // Use to register the attributes the user must enter
	protected Hashtable<String, StringListFrame> stringListFrameTable; //Use to register the StringListFrame linked to each StringList attribute
	protected Hashtable<String, String> translationTable;
	
	/*Methods*/
	public CharacterCreationFrame(CharacterCreationModule _module)
	{
		module = _module;
		setTitle("Création de personnage (" + module.getRelatedRPG() + ") - Interface générique");
		xmlFilePath = "./xml/CharacterCreation/"+module.getRelatedRPG()+"_FR.xml";
		characterAttributeComponentTable = new Hashtable<String, Object>();
		mandatoryCharacterAttributeComponentTable = new ArrayList<String>();
		stringListFrameTable = new Hashtable<String, StringListFrame>();
		translationTable = new Hashtable<String,String>();
		setSize((int)screenDimension.getWidth()/2, (int)(screenDimension.getHeight()*0.9));
		setResizable(true);
		createFrame();
		setSize((int)screenDimension.getWidth()/2, (int)(screenDimension.getHeight()*0.9));

	}

	/*create the gui components by reading the xml file*/
	private void createFrame() 
	{
		//Container panel = getContentPane();
		JPanel panel = new JPanel();
		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);
		
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		JLabel previousLabel = null; //To locate the following label
		Component previousComponent = null;
		Component currentComponent = null;
		JLabel label = null;
		int lastComponentY = 0;
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(new File(xmlFilePath));
			final Element root = document.getDocumentElement();	
			final NodeList rootNodes =root.getChildNodes();
			final int rootNodesLength = rootNodes.getLength();
			
				for (int i = 0; i<rootNodesLength; i++) {
					if(rootNodes.item(i).getNodeType() == Node.ELEMENT_NODE)
					{
						final Element currentElement = (Element) rootNodes.item(i);
						previousLabel = label;
						previousComponent = currentComponent;
						
						/*Add the corresponding component depending of it's type*/
						
						/*String*/
						if(currentElement.getAttribute("type").equals("String"))
						{	
							label = new JLabel(currentElement.getAttribute("name")+" :");
							currentComponent = new JTextField(Integer.parseInt(currentElement.getAttribute("size")));
						}
						
						/*Int*/
						if(currentElement.getAttribute("type").equals("int"))
						{	
							label = new JLabel(currentElement.getAttribute("name")+" :");
							/*prevent from typing char*/
							NumberFormat format = NumberFormat.getInstance();
						    NumberFormatter formatter = new NumberFormatter(format);
						    formatter.setValueClass(Integer.class);
						    formatter.setMinimum(0);
						    formatter.setMaximum(Integer.MAX_VALUE);
						    // If you want the value to be committed on each keystroke instead of focus lost
						    formatter.setCommitsOnValidEdit(true);
						    currentComponent = new JFormattedTextField(formatter);
						    ((JFormattedTextField)currentComponent).setColumns(5);
							
						}
						
						/*Selectable*/
						if(currentElement.getAttribute("type").equals("selectable"))
						{	
							label = new JLabel(currentElement.getAttribute("name")+" :");
							JComboBox<String> comboBox = new JComboBox<String>();
							for(int j = 0 ; j < currentElement.getElementsByTagName("choice").getLength() ; ++j)
							{
								if(((Element)((Element)currentElement.getElementsByTagName("choice").item(j))).getNodeType() == Node.ELEMENT_NODE )
								{
									comboBox.addItem( ((Element)((Element)currentElement.getElementsByTagName("choice").item(j))).getAttribute("val") );
								}
							}
							currentComponent = comboBox;
						}
						
						/*Stringlist*/
						if(currentElement.getAttribute("type").equals("StringList"))
						{	
							label = new JLabel(currentElement.getAttribute("name")+" :");
							stringListFrameTable.put(currentElement.getNodeName(), new StringListFrame(currentElement.getAttribute("name"), Integer.parseInt( currentElement.getAttribute("size")), this));
							currentComponent = new StringListButton("Editer",this,currentElement.getAttribute("name"),stringListFrameTable.get(currentElement.getNodeName()),Integer.parseInt( currentElement.getAttribute("size")) );
							((JButton)currentComponent).addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									StringListButton slb= (StringListButton) e.getSource();
									slb.stringListFrame.setVisible(true);
								}
							});
						}
						
						/*Table*/
						if(currentElement.getAttribute("type").equals("table"))
						{
							label = new JLabel(currentElement.getAttribute("name")+" :");
							currentComponent = createTable(currentElement);
							
						}
						
						/*CheckBox*/
						if(currentElement.getAttribute("type").equals("checkBox"))
						{
							label = new JLabel(currentElement.getAttribute("name")+" :");
							currentComponent = new JCheckBox();
						}
						
						/*The component is saved to read it when saving*/
						characterAttributeComponentTable.put(currentElement.getNodeName(), currentComponent );
						translationTable.put(currentElement.getNodeName(), currentElement.getAttribute("name"));
						
						/*Check if the component is mandatory*/
						if(currentElement.getAttribute("mandatory").equals("true"))
						{
							mandatoryCharacterAttributeComponentTable.add(currentElement.getNodeName());
						}
						
						/*The current component is placed in the GUI*/
						panel.add(label);
						panel.add(currentComponent);
						
							if(previousLabel == null) //first element 
							{
								layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, panel);
								layout.putConstraint(SpringLayout.NORTH, label, 7, SpringLayout.NORTH, panel);
								
								layout.putConstraint(SpringLayout.WEST, currentComponent, 5, SpringLayout.EAST, label);
								layout.putConstraint(SpringLayout.NORTH, currentComponent, 0, SpringLayout.NORTH, label);
							}else{
								layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, panel);
								layout.putConstraint(SpringLayout.NORTH, label, 7, SpringLayout.SOUTH,previousComponent );
								
								layout.putConstraint(SpringLayout.WEST, currentComponent, 7, SpringLayout.EAST, label);
								layout.putConstraint(SpringLayout.NORTH, currentComponent, -2, SpringLayout.NORTH, label);
								
								/*Size of the JTables*/
								if(currentElement.getAttribute("type").equals("table"))
								{
									layout.putConstraint(SpringLayout.SOUTH, currentComponent, 21, SpringLayout.SOUTH, label);
								}
								lastComponentY += (currentComponent.getPreferredSize().getHeight() + 10 );
							previousComponent = currentComponent;
						}
						
					}
				}
				
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		panel.setPreferredSize(new Dimension(getWidth(),lastComponentY + 50));
		getContentPane().add(new JScrollPane(panel), BorderLayout.CENTER);
		
		
		/*Validation button*/
		CharacterCreationFrameButton OKButton = new CharacterCreationFrameButton("Ok", this);
		OKButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(((CharacterCreationFrame) ((CharacterCreationFrameButton)e.getSource()).originalFrame).saveCharacter()){
					CharacterCreationConfirmationFrame cccf = new CharacterCreationConfirmationFrame(((CharacterCreationFrame) ((CharacterCreationFrameButton)e.getSource()).originalFrame)
							,((CharacterCreationFrame) ((CharacterCreationFrameButton)e.getSource()).originalFrame).module);
					cccf.setVisible(true);
				}else{
					String warningMandatoryString = "Les attributs suivants sont obligatoires: \n";
					
					for(int i = 0 ; i < mandatoryCharacterAttributeComponentTable.size(); ++i)
					{
						warningMandatoryString += "   -";
						warningMandatoryString += translationTable.get(mandatoryCharacterAttributeComponentTable.get(i));
						warningMandatoryString += "\n";
					}
						
					JOptionPane.showMessageDialog(((CharacterCreationFrame) ((CharacterCreationFrameButton)e.getSource()).originalFrame), warningMandatoryString, "Erreur saisie",JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(OKButton,BorderLayout.CENTER);
		getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
		
		pack();
		repaint();
		setVisible(true);
	}


	/*This function is used to create a table the user may fill with character informations*/
	private Component createTable(Element element)
	{
		/*The Table to display elements*/
		 DefaultTableModel dm = new DefaultTableModel();
		 dm.setDataVector(new Object[][] { }, new Object[] {});  
		dm.addRow(new Object[]{});	 
		for(int i = 0 ; i < element.getChildNodes().getLength(); ++i)
		{
		
			if(element.getChildNodes().item(i).getNodeType() == Node.ELEMENT_NODE)
			{
				dm.addColumn( ((Element)(element.getChildNodes().item(i))).getAttribute("name") );
				dm.setValueAt("", 0, dm.getColumnCount()-1);
			}
		}
		
		JTable table = new JTable(dm);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		TableScrollPane scrollpane = new TableScrollPane(table);
		scrollpane.setPreferredSize( new Dimension( (int) scrollpane.getPreferredSize().getWidth() , (int) table.getPreferredSize().getHeight() ) );
		return(scrollpane);
	}
	
	/*Save the characteristics of the character in the characterCreationModule's current character of the corresponding RPG*/
	@SuppressWarnings("rawtypes")
	public boolean saveCharacter()
	{	
		/*Create a hash table containing the character attributes*/
		
		Hashtable<String, Object> characterAttributeTable = new Hashtable<String,Object>();
		
		for(String str : characterAttributeComponentTable.keySet())
		{	
			if(characterAttributeComponentTable.get(str) instanceof JTextField)
				{
				if(mandatoryCharacterAttributeComponentTable.contains(str)
						&& ((JTextField)characterAttributeComponentTable.get(str)).getText().equals(""))
				{
					return false;
				}
				characterAttributeTable.put(str, ((JTextField)characterAttributeComponentTable.get(str)).getText());
			}else if(characterAttributeComponentTable.get(str) instanceof JComboBox)
			{	
				if(mandatoryCharacterAttributeComponentTable.contains(str)
				&& ((JComboBox)characterAttributeComponentTable.get(str)).getSelectedItem().equals(""))
				{
					return false;
				}
				characterAttributeTable.put(str, ((JComboBox)characterAttributeComponentTable.get(str)).getSelectedItem());
			}else if(characterAttributeComponentTable.get(str) instanceof StringListButton)
			{
				if(mandatoryCharacterAttributeComponentTable.contains(str)
						&& stringListFrameTable.get(str).getDefaultTabModel().getRowCount() == 0)
				{
					return false;
				}
				
				characterAttributeTable.put(str, stringListFrameTable.get(str).getDefaultTabModel());
			}else if(characterAttributeComponentTable.get(str) instanceof TableScrollPane)
			{	 
				
				//replace the "" by 0 in the table
				for(int a = 0 ; a < ((TableScrollPane)characterAttributeComponentTable.get(str)).table.getModel().getRowCount() ; ++a)
				{
					for(int b = 0 ; b < ((TableScrollPane)characterAttributeComponentTable.get(str)).table.getModel().getColumnCount() ; ++ b)
					{
						if(	((TableScrollPane)characterAttributeComponentTable.get(str)).table.getModel().getValueAt(a, b).equals("") )
						{
							if(mandatoryCharacterAttributeComponentTable.contains(str))
							{
								return false;
							}
							
							((TableScrollPane)characterAttributeComponentTable.get(str)).table.getModel().setValueAt("0" , a, b);
						}
					}
				}
				characterAttributeTable.put(str, ((TableScrollPane)characterAttributeComponentTable.get(str)).table.getModel());

			}else if(characterAttributeComponentTable.get(str) instanceof JCheckBox)
			{
				characterAttributeTable.put(str, ((JCheckBox)characterAttributeComponentTable.get(str)).isSelected());
			}
		}
		
		module.getCurrentCharacter().getGUIInputs(characterAttributeTable);
		
		return true;
	}
	
	//This class is used to create stringList creation frames
	public class StringListButton extends JButton
	{
		/*Attributes*/
		public JFrame originalFrame;
		public String attributeName;
		public StringListFrame stringListFrame;
		public int textSize;
		private static final long serialVersionUID = 9043332819853953864L;

		/*Methods*/
		public StringListButton(String _name, JFrame _originalFrame, String _attributeName,StringListFrame _stringListFrame, int _textSize)
		{
			super(_name);
			originalFrame = _originalFrame;
			attributeName = _attributeName;
			stringListFrame = _stringListFrame;
			textSize = _textSize;
			
		}
	}
	
	public class CharacterCreationFrameButton extends JButton
	{
		
		/*Attributes*/
		public JFrame originalFrame;
		private static final long serialVersionUID = 663766875385728272L;
		
		/*Methods*/
		public CharacterCreationFrameButton(String _name,JFrame _originalFrame )
		{
			super(_name);
			originalFrame = _originalFrame;
		}
	}
	
	public class TableScrollPane extends JScrollPane
	{
		/*Attributes*/
		public JTable table;
		private static final long serialVersionUID = 6254222749903243451L;
		
		/*Methods*/
		public TableScrollPane(JTable _table)
		{
			super(_table);
			table = _table;
		}
	}
}
