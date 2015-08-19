/*This class randomly generate Fantasy dwarf name
 * 
 * A dwarf name is composed of two syllabus which are chosen in the file namePart1 then nameFemalePart2
 * */


package nameGenerator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class DwarfFemaleNameGenerator extends NameGenerator {


	/*Attributes*/
	FileInputStream ipsPart1;
	FileInputStream ipsPart2;
	InputStreamReader ipsrPart1;
	InputStreamReader ipsrPart2;
	BufferedReader brPart1;
	BufferedReader brPart2;
	
	int part1Amount;
	int part2Amount;
	
	
	/*Methods*/
	public DwarfFemaleNameGenerator()
	{
		try {
			ipsPart1 = new FileInputStream("./NameGenerator/Dwarf/namePart1");
			ipsrPart1 = new InputStreamReader(ipsPart1);
			
			ipsPart2 = new FileInputStream("./NameGenerator/Dwarf/nameFemalePart2");
			ipsrPart2 = new InputStreamReader(ipsPart2);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*Return a randomly generate dwarf name*/
	@Override
	public String generate() throws IOException
	{
		String name = "";
		
		/*select the first part*/
		int rand = (int) (Math.random()*part1Amount);
		for(int i = 0 ; i < rand ; ++i)
		{
			brPart1.readLine();
		}
		
		name = brPart1.readLine();
		ipsPart1.getChannel().position(0);
		
		/*select the second part*/
		rand = (int) (Math.random()*part2Amount);
		for(int i = 0 ; i < rand ; ++i)
		{
			brPart2.readLine();
		}
		
		name += brPart2.readLine();
		ipsPart2.getChannel().position(0);

		
		return name;
	}

	@Override
	public void initiate() throws IOException {
		brPart1 = new BufferedReader(ipsrPart1);
		part1Amount = 0;
		while ( brPart1.readLine() != null)
		{
			part1Amount++;
		}
		ipsPart1.getChannel().position(0);		
		
		brPart2 = new BufferedReader(ipsrPart2);
		brPart2.mark(0);
		part2Amount = 0;
		while (brPart2.readLine() != null)
		{
			part2Amount++;
		}
		ipsPart2.getChannel().position(0);
	}

	@Override
	public void close() throws IOException {
		brPart1.close();
		brPart2.close();
	}


}
