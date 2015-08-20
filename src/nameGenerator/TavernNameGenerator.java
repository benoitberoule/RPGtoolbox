/*This class randomly generate a male/female name for a tavern using
 * TaverneMaleNameGenerator and
 * TavernFemaleNameGenerator classes*/

package nameGenerator;

import java.io.IOException;

public class TavernNameGenerator  extends NameGenerator{

	/*Attributes*/
	TavernFemaleNameGenerator tfng;
	TavernMaleNameGenerator tmng;
	
	/*Methods*/
	public TavernNameGenerator()
	{
		tfng = new TavernFemaleNameGenerator();
		tmng = new TavernMaleNameGenerator();
	}
	
	@Override
	public String generate() throws IOException {
		
		int r = (int)(Math.random()*100);
		
		if(r <50)
		{
			return tfng.generate();
		}else
		{
			return tmng.generate();
		}
		
	}

	@Override
	public void initiate() throws IOException {
		tfng.initiate();
		tmng.initiate();
		
	}

	@Override
	public void close() throws IOException {
		tfng.initiate();
		tmng.initiate();
		
	}

}
