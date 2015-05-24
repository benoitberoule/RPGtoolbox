/*This class details all the characteristic of a warhammer character/monster */
package warhammerCharacter;

import java.io.Serializable;
import java.util.Hashtable;

public class Profil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7222947572807220776L;
	/*attributes*/
	protected Hashtable<String, Integer> caracTable = new  Hashtable<String, Integer>();
	
	/*methods*/
	public Profil()
	{
		createCaracTable();
	}
	
	public Profil(int _CC , int _CT, int _F, int _E, int _Ag, int _Int, int _FM, int _Soc, int _A, int _B, int _BF, int _BE , int _M, int _Mag, int _PF, int _PD)
	{
		caracTable = new Hashtable<String,Integer>();
		caracTable.put("CC", _CC);
		caracTable.put("CT",_CT);
		caracTable.put("F", _F);
		caracTable.put("E", _E);
		caracTable.put("Ag", _Ag);
		caracTable.put("Int", _Int);
		caracTable.put("FM", _FM);
		caracTable.put("Soc", _Soc);
		caracTable.put("A", _A);
		caracTable.put("B", _B);
		caracTable.put("BF", _BF);
		caracTable.put("BE", _BE);
		caracTable.put("M", _M);
		caracTable.put("Mag", _Mag);
		caracTable.put("PF", _PF);
		caracTable.put("PD", _PD);

	}
	
	/*create the hardcoded hashtable witch link carac as int and carac as string*/
	private void createCaracTable()
	{
		caracTable = new Hashtable<String,Integer>();
		caracTable.put("CC", 0);
		caracTable.put("CT",0);
		caracTable.put("F", 0);
		caracTable.put("E", 0);
		caracTable.put("Ag", 0);
		caracTable.put("Int", 0);
		caracTable.put("FM", 0);
		caracTable.put("Soc", 0);
		caracTable.put("A", 0);
		caracTable.put("B", 0);
		caracTable.put("BF", 0);
		caracTable.put("BE", 0);
		caracTable.put("M", 0);
		caracTable.put("Mag", 0);
		caracTable.put("PF", 0);
		caracTable.put("PD", 0);
	}

	/*getter & setter */
	
	/*get any car defined by a String*/
	public int get(String carName)
	{
		return caracTable.get(carName);
	}
	
	/*set any car defined by a String*/
	public void set(String carName, int val)
	{
		if(caracTable.contains(carName))
		{
			caracTable.put(carName, val);
		}
	
	}

	public Hashtable<String, Integer> getCaracTable() {
		return caracTable;
	}
	
	
	
	
}
