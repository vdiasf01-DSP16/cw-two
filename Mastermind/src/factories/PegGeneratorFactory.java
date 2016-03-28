package factories;

import java.util.Map;

import controllers.IPegGenerator;

/**
 * @author Pedro Gordo
 *
 */
public interface PegGeneratorFactory
{
	/**
	 * Creates an instance of PegGenerator.
	 * 
	 * @param colourList
	 * @return the instance created
	 */
	public IPegGenerator create(Map<String, String> colourList);
}
