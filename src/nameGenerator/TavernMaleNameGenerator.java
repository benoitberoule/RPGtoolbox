/*This class randomly generate taverne's names
 * There is several ways to generate a name:
 * 
 * --1
 *  name + adjective
 *  
 * --2
 * 	name + "'s" ( chez machin)
 * 
 * --3
 * "the" number name
 * */
package nameGenerator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TavernMaleNameGenerator extends NameGenerator {

	
	/*Attributes*/
	FileInputStream ipsPart1;
	FileInputStream ipsPart2;
	FileInputStream ipsNumber;
	InputStreamReader ipsrPart1;
	InputStreamReader ipsrPart2;
	InputStreamReader ipsrNumber;
	BufferedReader brPart1;
	BufferedReader brPart2;
	BufferedReader brNumber;
	
	int part1Amount;
	int part2Amount;
	int numberAmount;
	
	ArrayList<String> vowel = new ArrayList<String>();
	
	/*Methods*/
	public TavernMaleNameGenerator()
	{
		try {
			ipsPart1 = new FileInputStream("./NameGenerator/Tavern/nameMalePart1");
			ipsrPart1 = new InputStreamReader(ipsPart1);
			
			ipsPart2 = new FileInputStream("./NameGenerator/Tavern/namePart2");
			ipsrPart2 = new InputStreamReader(ipsPart2);
			
			ipsNumber = new FileInputStream("./NameGenerator/Tavern/numbers");
			ipsrNumber = new InputStreamReader(ipsNumber);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		vowel.add("a");
		vowel.add("â");
		vowel.add("e");
		vowel.add("é");
		vowel.add("è");
		vowel.add("i");
		vowel.add("î");
		vowel.add("o");
		vowel.add("u");
		vowel.add("y");
	}

	/*Return a randomly generate dwarf name*/
	@Override
	public String generate() throws IOException
	{
		String name = "";
		int r = (int) (Math.random()*100);
		
		if(r <= 70) // name + adjective
		{
			/*select the first part*/
			int rand = (int) (Math.random()*part1Amount);
			for(int i = 0 ; i < rand ; ++i)
			{
				brPart1.readLine();
			}
			String name1 = brPart1.readLine();
			ipsPart1.getChannel().position(0);
			
			if(vowel.contains(name1.substring(1, 2)))
			{
				name = "L'"+name1.substring(1, name1.indexOf("/"));
			}else{
				name = "Le "+name1.substring(1, name1.indexOf("/"));
			}
			
			name += " ";
			/*select the second part*/
			String name2;
			do{
				rand = (int) (Math.random()*part2Amount);
				for(int i = 0 ; i < rand ; ++i)
				{
					brPart2.readLine();
				}
				name2 = brPart2.readLine();
				ipsPart2.getChannel().position(0);
				
			}while(!(name1.substring(0, 1)).equals(name2.substring(0, 1)) || (name2.substring(0, 1)).equals("="));
			
			name += name2.substring(1,name2.indexOf("/"));
		}else if (r > 70 && r <= 80) //name"'s" (chez machin)
		{
			int rr = (int) (Math.random()*100);
			NameGenerator ng;
			
			if(rr < 80) // dwarf name
			{
				ng = new DwarfMaleNameGenerator();
			}else  //elf name
			{
				ng = new ElfMaleNameGenerator();
			}
			
			ng.initiate();
			name = "Chez " + ng.generate();
			ng.close();
			
		}else if (r > 80 && r <= 100) //"the" number name
		{
			/*select the first part*/
			int rand = (int) (Math.random()*numberAmount);
			for(int i = 0 ; i < rand ; ++i)
			{
				brNumber.readLine();
			}
			
			name = "Les " + brNumber.readLine() + " ";
			ipsNumber.getChannel().position(0);
			
			/*select the second part*/
			rand = (int) (Math.random()*part1Amount);
			for(int i = 0 ; i < rand ; ++i)
			{
				brPart1.readLine();
			}
			String nameTemp = brPart1.readLine();
			name += nameTemp.substring(nameTemp.indexOf("/")+1);
			ipsPart1.getChannel().position(0);
		}
		
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
		
		brNumber = new BufferedReader(ipsrNumber);
		brNumber.mark(0);
		numberAmount = 0;
		while (brNumber.readLine() != null)
		{
			numberAmount++;
		}
		ipsNumber.getChannel().position(0);
	}

	@Override
	public void close() throws IOException {
		brPart1.close();
		brPart2.close();
		brNumber.close();
	}

	
}
