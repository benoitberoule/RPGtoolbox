package gui.nameGenerator;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import nameGenerator.DwarfFemaleNameGenerator;
import nameGenerator.DwarfMaleNameGenerator;
import nameGenerator.HumanFemaleClassicalFantasyNameGenerator;
import nameGenerator.HumanMaleClassicalFantasyNameGenerator;
import nameGenerator.NameGenerator;

public class nameGeneratorFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4205154714477088938L;
	private JPanel contentPane;
	private JComboBox<String> raceComboBox;
	private JRadioButton rdbtnMasculin;
	private JRadioButton rdbtnFeminin;
	private JLabel generateNamesLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nameGeneratorFrame frame = new nameGeneratorFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public nameGeneratorFrame() {
		setResizable(false);
		setTitle("Generateur de noms");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 377, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel);
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		
		JPanel ComboPanel = new JPanel();
		topPanel.add(ComboPanel);
		ComboPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		raceComboBox = new JComboBox<String>();
		raceComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Fantasy - Nain",
															"Fantasy - Humain (classique)"}));
		ComboPanel.add(raceComboBox);
		
		JPanel generationPanel = new JPanel();
		topPanel.add(generationPanel);
		generationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnGenerer = new JButton("Generer");
		generationPanel.add(btnGenerer);
		btnGenerer.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {			
				generateClick();				
			}
		});
		
		rdbtnMasculin = new JRadioButton("Masculin");
		rdbtnMasculin.setSelected(true);
		generationPanel.add(rdbtnMasculin);
		
		rdbtnFeminin = new JRadioButton("Feminin");
		generationPanel.add(rdbtnFeminin);
		
		ButtonGroup sexGroup = new ButtonGroup();
		sexGroup.add(rdbtnMasculin);
		sexGroup.add(rdbtnFeminin);
		
		JPanel namePanel = new JPanel();
		contentPane.add(namePanel);
		
		generateNamesLabel = new JLabel("<html>Nom11111     Nom22222    Nom33333 <br>\nNom11111     Nom22222    Nom33333 <br>\nNom11111     Nom22222    Nom33333</html>");
		namePanel.add(generateNamesLabel);
		
	}

	/*Action performed if the "generate" button is clicked, it display the name depending on user's choices*/
	public void generateClick()
	{
		
		NameGenerator nameGenerator = null;
		
		/*Selection of the right name generator*/
		
		/*Dwarf*/
		if(raceComboBox.getSelectedItem().equals("Fantasy - Nain"))
		{
			/*Male*/
			if(rdbtnMasculin.isSelected())
			{
				nameGenerator = new DwarfMaleNameGenerator();
			/*Female*/
			}else if (rdbtnFeminin.isSelected())
			{
				nameGenerator = new DwarfFemaleNameGenerator();
			}
		}
		
		/*classical fantasy human*/
		if(raceComboBox.getSelectedItem().equals("Fantasy - Humain (classique)"))
		{
			/*Male*/
			if(rdbtnMasculin.isSelected())
			{
				nameGenerator = new HumanMaleClassicalFantasyNameGenerator();
			/*Female*/
			}else if (rdbtnFeminin.isSelected())
			{
				nameGenerator = new HumanFemaleClassicalFantasyNameGenerator();
			}
			
		}
		
		
		try {
			nameGenerator.initiate();
			String names = "<html>";
			for(int i = 0 ; i < 3 ; ++i)
			{
				for(int j = 0 ; j < 3 ; ++j)
				{
					names += nameGenerator.generate() + "&nbsp; &nbsp; &nbsp;";
				}
				names += "<br>";
			}
			
			names += "</html>";
			nameGenerator.close();
			generateNamesLabel.setText(names);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
