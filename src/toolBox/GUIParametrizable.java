/*This interface is used for classes which need to get inputs from GUI (via a text fields for instance)*/
package toolBox;

import java.util.Hashtable;

public interface GUIParametrizable {
	
	/*This methods must be called by a listener which will send GUI inputs via "ht", it will corectly fill the concern attributes of the implemented class*/
	public void getGUIInputs(Hashtable<String, Object> ht);

}
