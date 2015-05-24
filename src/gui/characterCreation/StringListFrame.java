package gui.characterCreation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class StringListFrame extends JFrame {
	
	/*Attributes */
	private static final long serialVersionUID = 7101105264331598762L;
	protected final int textSize;
	protected Dimension screenDimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	protected JFrame originalFrame;
	protected DefaultTableModel defaultTabModel = new DefaultTableModel();
	
	/*Methods*/
	public StringListFrame(String _attributeName, int _textSize, JFrame _originalFrame)
	{
		setTitle(_attributeName);
		textSize = _textSize;
		originalFrame = _originalFrame;
		createFrame();
		setSize((int)screenDimension.getWidth()/10 + textSize*10, (int)(screenDimension.getHeight()/5));
	}
	
	/*Construction of the frame thanks to a cardlayout*/
	private void createFrame()
	{	
		/*The Table to display elements*/
		    defaultTabModel.setDataVector(new Object[][] { }, new Object[] { "nom", "supr." });
		JTable table = new JTable(defaultTabModel);
		
		table.getColumn("supr.").setCellRenderer(new ButtonRender());
		table.getColumn("supr.").setCellEditor(
		        new ButtonEditor(new JCheckBox()));
		JScrollPane scrollpane = new JScrollPane(table);
		
		/*the  panel which is used to add elements*/
		JPanel textFieldPanel = new JPanel(new FlowLayout());
		AddElementTextField addElementTextField = new AddElementTextField(textSize,defaultTabModel);
		JButton addElementButton = new AddElementButton("+",addElementTextField,defaultTabModel); 
		textFieldPanel.add(addElementTextField);
		textFieldPanel.add(addElementButton);
		
		
		getContentPane().add(textFieldPanel,BorderLayout.NORTH);
		getContentPane().add(scrollpane,BorderLayout.CENTER);
		pack();
		repaint();
		
	}
	
	
	/*This class is used to handle the buttons of the JTable*/
	class ButtonRender extends JButton implements TableCellRenderer
	{

		private static final long serialVersionUID = -3712675997670016491L;

		public ButtonRender()
		{
			setOpaque(true);
		}
		
		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			 if (isSelected) {
			      setForeground(table.getSelectionForeground());
			      setBackground(table.getSelectionBackground());
			    } else {
			      setForeground(table.getForeground());
			      setBackground(UIManager.getColor("Button.background"));
			    }
			    setText((value == null) ? "" : value.toString());
			    return this;
		}
		
	}
	
	
	
	class ButtonEditor extends DefaultCellEditor {

		private static final long serialVersionUID = 9128126180984794030L;
		protected JButton button;
		private String label;
		private boolean isPushed;
		private JTable table;
		private int row;
		
		
		  public ButtonEditor(JCheckBox checkBox) {
		    super(checkBox);
		    button = new JButton();
		    button.setOpaque(true);
		    button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        fireEditingStopped();
		        ((DefaultTableModel)table.getModel()).removeRow(row);
		      }
		    });
		  }

		  public Component getTableCellEditorComponent(JTable table, Object value,
		      boolean isSelected, int row, int column) {
		    if (isSelected) {
		      button.setForeground(table.getSelectionForeground());
		      button.setBackground(table.getSelectionBackground());
		    } else {
		      button.setForeground(table.getForeground());
		      button.setBackground(table.getBackground());
		    }
		    label = (value == null) ? "" : value.toString();
		    button.setText(label);
		    this.table = table;
		    this.row = row;
		    isPushed = true;
		    
		    return button;
		  }
		 
		  public Object getCellEditorValue() {
		    if (isPushed) {
		    	//action when button pressed if any
		    }
		    isPushed = false;
		    return new String(label);
		  }

		  public boolean stopCellEditing() {
		    isPushed = false;
		    return super.stopCellEditing();
		  }

		  protected void fireEditingStopped() {
			  super.fireEditingStopped();
		  }
		}

	
	/*Setters & getters*/
	public DefaultTableModel getDefaultTabModel() {
		return defaultTabModel;
	}
	
	
	/*The button class used to add elements*/
	class AddElementButton extends JButton
	{
		/*Attributes*/
		public JTextField textField;
		public DefaultTableModel model;
		private static final long serialVersionUID = 1957976901839654044L;
		
		/*Methods*/
		public AddElementButton(String name,  JTextField jt, DefaultTableModel mod){
			super(name);
			textField = jt;
			model = mod;			
			addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (! ((AddElementButton)(e.getSource())).textField.getText().equals("") )
					{
						((AddElementButton)(e.getSource())).model.addRow(new Object[]{((AddElementButton)(e.getSource())).textField.getText(), "X"});
						((AddElementButton)(e.getSource())).textField.setText("");
					}
					
				}
			});
		}
	}
	
	/*The TextField class used to written the ellement to add*/
	protected class AddElementTextField extends JTextField
	{
		/*Attributes*/
		private static final long serialVersionUID = 3167367600256213391L;
		public DefaultTableModel model;
		
		/*Methods*/
		public AddElementTextField(int columsize,DefaultTableModel mod)
		{
			super(columsize);
			model = mod;
			
			addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent ke) {
					if(((Character)(ke.getKeyChar())).hashCode() == KeyEvent.VK_ENTER
							&&  ! ((AddElementTextField)(ke.getSource())).getText().equals(""))
					{
						((AddElementTextField)(ke.getSource())).model.addRow(new Object[]{((AddElementTextField)(ke.getSource())).getText(), "X"});
						((AddElementTextField)(ke.getSource())).setText("");
					}				
					
				}
				
				@Override
				public void keyReleased(KeyEvent arg0) {
					// Nothing to do
					
				}
				
				@Override
				public void keyPressed(KeyEvent arg0) {
					// nothing to do
					
				}
			});

		}
	}

}
