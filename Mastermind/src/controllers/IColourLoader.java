/**
 * 
 */
package controllers;

import java.util.Map;

/**
 * @author Pedro Gordo
 *
 */
public interface IColourLoader
{

	/**
	 * Returns the list of colours loaded from the configuration file.
	 * 
	 * @return a map containing the loaded colours, the key is the colour code
	 *         (just one letter) and the value is the whole colour name, e.g.
	 *         "Green".
	 */
	public Map<String, String> getColours();

}
