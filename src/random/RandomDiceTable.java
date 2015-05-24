/*A RandomDiceTable is a RandomTable with correspond to a simple dice operation
 * for example an operation like 1D6 + 5 may be represent by the following table:
 * 
 * 	1 -> 6
 * 	2 -> 7
 *  3 -> 8
 *  4 -> 9
 *  5 -> 10
 *  6 -> 11
 *  
 *  the operation will be determine like this:
 *  
 *  (x1Dx2)*x3 + (x4Dx5)*x6 + ... + xn
 *  
 *  and table = {x1,x2,x3,...,xn}
 *  
 *  
 *  WARNING: diceTable.size() = 1(3)
 *  
 *  */

package random;

import java.util.ArrayList;
import java.util.Random;

public class RandomDiceTable extends RandomTable{

	/*attributes*/
	protected ArrayList<Integer> diceTable;
	
	
	/*constructor for one die     1DX */
	public RandomDiceTable(int dieValue)
	{
		super();
		diceTable = new ArrayList<Integer>();
		diceTable.add(0,1);
		diceTable.add(1,dieValue);
		diceTable.add(2,1);
		diceTable.add(3,0);
	}
	
	/*constructor for several dice with the same value   nDX */
	public RandomDiceTable(int dieValue,int amount)
	{
		super();
		diceTable = new ArrayList<Integer>();
		diceTable.add(0,amount);
		diceTable.add(1,dieValue);
		diceTable.add(2,1);
		diceTable.add(3,0);
	}
	
	/*constructor for several dice with the same value added with an integer    nDX + a */
	public RandomDiceTable(int dieValue, int amount, int add)
	{
		super();
		diceTable.add(0,amount);
		diceTable.add(1,dieValue);
		diceTable.add(2,1);
		diceTable.add(3,add);
		
	}
	
	/*standard constructor*/
	public RandomDiceTable(ArrayList<Integer> _diceTable)
	{
		super();
		diceTable = _diceTable;
	}
	
	public Object getRandomElement()
	{
		int val = 0;
		Random rand = new Random();
		if(diceTable.size() % 3 != 1)
		{
			System.err.println("diceTbale.size() != 3 (1)");
		}else
		{
			for(int i = 0 ; i < diceTable.size() - 1; i += 3)
			{
				for(int j = 0 ; j < diceTable.get(i) ; ++j)
				{
					val += rand.nextInt() % diceTable.get(i+1);
				}
				val *= diceTable.get(i+2);
			}
		}
		
		val += diceTable.get(diceTable.size() - 1);
		
		return val;
	}
}
