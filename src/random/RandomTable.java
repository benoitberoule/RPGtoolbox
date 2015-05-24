/*A randomTable is composed of two elements
 * 1- a function from A to B with
 * 		A: a dice produce by a number
 * 		B: a result  determine by the dice (value, skiils, talent, dotation...)
 * 2- a random number generator
 * 
 * 	example (with a D10):
 * 	1-2 -> result1
 * 	3-7 -> result2
 * 	8-9 -> result3
 * 	10  -> result4
 * 
 * WARNING: in the table, the first number will be 0
 * */

package random;

import java.util.ArrayList;
import java.util.Random;

public class RandomTable {

	/*attributes*/
	ArrayList<Object> table;
	
	/*methods*/
	public RandomTable(ArrayList<Object> _table)
	{
		table = _table;
	}
	
	public RandomTable()
	{
		
	}
	
	
	/*to obtain a random element of the table*/
	public Object getRandomElement()
	{
		Random rand = new Random();
		
		return table.get(rand.nextInt() % table.size());
		
	}

	/*getter & setter*/
	
		public void setTable(ArrayList<Object> table) {
		this.table = table;
	}
}
