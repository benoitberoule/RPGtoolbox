/*This class must be extend by each specific name generator
 * It is used to randomly generate names for character, monster, city...
 * The rules used to create the names must be detailled in the extended classes
 * 
 * NameGenerator classes must be used as :
 * 
 * NameGenerator ng = new NameGenerator
 * ng.initiate();
 * name = ng.generate()
 * ng.close()
 * */
package nameGenerator;

import java.io.IOException;

public abstract class NameGenerator {

	/*Methods*/
	
	/*Return a random name */
	public abstract String generate() throws IOException;

	/*To eventually open files*/
	public abstract void initiate() throws IOException;
	
	/*To close the eventual open files*/
	public abstract void close() throws IOException ;
	
}
