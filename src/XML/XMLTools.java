package XML;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class XMLTools {

	private XMLTools(){}
	
	/**
	 * Serialize an object in a XML file
	 * @param object
	 * object to serialize 
	 * @param filename
	 * the name of the file to save the object
	 */
	public static void encodeToFile(Object object, String fileName) throws FileNotFoundException, IOException {
		XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));
		
		
		try{
			encoder.writeObject(object);
			encoder.flush();
		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			encoder.close();
		}
	}
	
}
