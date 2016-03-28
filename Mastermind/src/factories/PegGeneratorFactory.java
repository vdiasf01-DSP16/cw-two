package factories;

import java.util.Map;

import controllers.IPegFactory;

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
	public IPegFactory create(Map<String, String> colourList);
}
