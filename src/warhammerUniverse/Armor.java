/*This class represent the armor a character may bear to improve its protection */
package warhammerUniverse;

public class Armor extends Equipment{

	/*attributes*/
	/*covered zones*/
	protected boolean head;
	protected boolean chest;
	protected boolean arms;
	protected boolean legs;
	protected int AP; //armor point
	protected String type; //leather, maille, plaque
	
	/*methods*/
	public Armor(String _name, int _enc, boolean _head, boolean _chest, boolean _arms, boolean _legs, int _AP, String _type, String _disponibility, int _value)
	{
		name = _name;
		enc = _enc;
		head = _head;
		chest = _chest;
		arms = _arms;
		legs = _legs;
		AP = _AP;
		type = _type;
		disponibility = _disponibility;
		value = _value;
	}
}
