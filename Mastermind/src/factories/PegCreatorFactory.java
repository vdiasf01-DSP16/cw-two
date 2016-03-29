package factories;

import java.util.Map;

import controllers.IPegCreator;

/**
 * @author Pedro Gordo
 *
 */
public interface PegCreatorFactory
{
	/**
	 * Creates an instance of PegGenerator.
	 * 
	 * @param colourList
	 * @return the instance created
	 */
	public IPegCreator create(Map<String, String> colourList);
}
