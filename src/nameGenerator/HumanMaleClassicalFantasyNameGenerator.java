/*This class generate classical fantasy names for human (or medieval names)
 * The names are simply randomly chosen in a list
 * */

package nameGenerator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanMaleClassicalFantasyNameGenerator extends NameGenerator{

	/*Attributes*/
	FileInputStream ipsName;
	InputStreamReader ipsrName;
	BufferedReader brName;

	
	int part1Name;
	
	
	/*Methods*/
	public HumanMaleClassicalFantasyNameGenerator()
	{
		try {
			ipsName = new FileInputStream("./NameGenerator/Human/classicalFantasyHuman");
			ipsrName = new InputStreamReader(ipsName);
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*Return a randomly generate human name*/
	@Override
	public String generate() throws IOException
	{
		String name = "";
		
		/*select the name*/
		int rand = (int) (Math.random()*part1Name);
		for(int i = 0 ; i < rand ; ++i)
		{
			brName.readLine();
		}
		
		name = brName.readLine();
		ipsName.getChannel().position(0);

		
		return name;
	}

	@Override
	public void initiate() throws IOException {
		brName = new BufferedReader(ipsrName);
		part1Name = 0;
		while ( brName.readLine() != null)
		{
			part1Name++;
		}
		ipsName.getChannel().position(0);		
	}

	@Override
	public void close() throws IOException {
		brName.close();
	}

}
