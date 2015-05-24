package warhammerUniverse;

import java.util.ArrayList;

public class Weapon extends Equipment{

	/*attributes*/
	protected String group;
	protected String damage;
	protected ArrayList<String> attributes = new ArrayList<String>();
	
	/*methods*/
	public Weapon(String _name)
	{
		name = _name;
	}
	
	public Weapon(String _name, int _enc, String _group, String _damage, ArrayList<String> _attributes, String _disponibility, int _value)
	{
		name = _name;
		enc = _enc;
		group = _group;
		damage = _damage;
		attributes = _attributes;
		disponibility = _disponibility;
		value = _value;
	}
	
	public Weapon(String _name, int _enc, String _group, String _damage, String _attributes, String _disponibility, int _value)
	{
		name = _name;
		enc = _enc;
		group = _group;
		damage = _damage;
		attributes.add(_attributes);
		disponibility = _disponibility;
		value = _value;
	}
	
	
}
